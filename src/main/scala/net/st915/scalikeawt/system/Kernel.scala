package net.st915.scalikeawt.system

import cats.effect.IO
import net.st915.scalikeawt.Frame
import net.st915.scalikeawt.graphics.Canvas

import java.awt.event.{WindowAdapter, WindowEvent}
import scala.util.chaining.*

private[scalikeawt] object Kernel {

  case class Program[Model, Msg](initializer: List[String] => Model)(
    val updater: Msg => Model ?=> IO[Model],
    val renderer: Model ?=> Frame[Model, Msg]
  )

  val mainFrame: java.awt.Frame =
    new java.awt.Frame("")
      .tap(_.add(new java.awt.Panel()))

  var instance: Option[Program[_, _]] = None

  def performMsg[Model, Msg](msg: Msg, model: Model): IO[Unit] =
    for {
      inst <- IO { instance.get.asInstanceOf[Program[Model, Msg]] }
      given Model <- IO(model)
      given Model <- inst.updater(msg)
      _ <- updateFrame(inst.renderer, model)
    } yield ()

  def updateFrame[Model, Msg](newFrame: Frame[Model, Msg], model: Model): IO[Unit] =
    IO {
      mainFrame
        .tap(_.setTitle(newFrame.title))
        .tap(_.setSize(newFrame.size.width, newFrame.size.height))
        .tap(_.setResizable(newFrame.resizable))
        .tap(_.remove(0))
        .tap(_.add {
          new java.awt.Panel()
            .tap(_.setSize(newFrame.size.width, newFrame.size.height))
            .tap(_.setLayout(null))
            .tap { panel =>
              newFrame.components.foreach {
                case (coord, component) =>
                  val nativeComponent = (
                    component match
                      case x: Canvas[_, _] =>
                        CanvasConverter().convertCanvas(x)
                  ).tap(_.setBounds(coord.x, coord.y, component.size.width, component.size.height))

                  panel.add(nativeComponent)
              }
            }
        })
        .tap { nativeFrame =>
          nativeFrame.getWindowListeners.foreach {
            nativeFrame.removeWindowListener
          }
        }
        .tap(_.addWindowListener(new WindowAdapter {

          override def windowClosing(e: WindowEvent): Unit = {
            import cats.effect.unsafe.implicits.global

            performMsg(newFrame.onCloseButtonClick, model).unsafeRunSync()
          }

        }))
        .tap { nativeFrame =>
          newFrame.mainMenu match
            case Some(menuBar) =>
              nativeFrame.setMenuBar(MenuConverter().convertMenuBar(menuBar))

            case None =>
        }
    }

}
