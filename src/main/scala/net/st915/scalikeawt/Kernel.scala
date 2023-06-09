package net.st915.scalikeawt

import cats.effect.IO
import net.st915.scalikeawt.menus.MenuConverter

import java.awt.event.{WindowAdapter, WindowEvent}
import scala.util.chaining.*

private[scalikeawt] object Kernel {

  case class Program[Model, Msg](
    initializer: List[String] => IO[Model],
    updater: (Msg, Model) => IO[Model],
    renderer: Model => IO[Frame[Msg]]
  )

  val mainFrame: java.awt.Frame =
    new java.awt.Frame("")
      .tap(_.addWindowListener(new WindowAdapter {

        override def windowClosing(e: WindowEvent): Unit =
          System.exit(0)

      }))

  var instance: Option[Program[_, _]] = None

  def performMsg[Model, Msg](msg: Msg, model: Model): IO[Unit] =
    for {
      inst <- IO { instance.get.asInstanceOf[Program[Model, Msg]] }
      newModel <- inst.updater(msg, model)
      newFrame <- inst.renderer(newModel)
      _ <- updateFrame(newFrame)
    } yield ()

  def updateFrame[Model, Msg](newFrame: Frame[Msg]): IO[Unit] =
    IO {
      mainFrame
        .tap(_.setTitle(newFrame.title))
        .tap(_.setSize(newFrame.size.width, newFrame.size.height))
        .tap { nativeFrame =>
          newFrame.mainMenu match
            case Some(menuBar) =>
              nativeFrame.setMenuBar(new MenuConverter[Msg].convertMenuBar(menuBar))

            case None =>
        }
    }

}
