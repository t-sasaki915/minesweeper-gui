package net.st915.scalikeawt

import cats.effect.IO

import java.awt.event.{WindowAdapter, WindowEvent}
import scala.util.chaining.*

private[scalikeawt] object Kernel {

  val mainFrame: java.awt.Frame =
    new java.awt.Frame("")
      .tap(_.addWindowListener(new WindowAdapter {

        override def windowClosing(e: WindowEvent): Unit =
          System.exit(0)

      }))

  def updateFrame(newFrame: Frame): IO[Unit] =
    IO {
      mainFrame
        .tap(_.setTitle(newFrame.title))
        .tap(_.setSize(newFrame.size.width, newFrame.size.height))
    }

}
