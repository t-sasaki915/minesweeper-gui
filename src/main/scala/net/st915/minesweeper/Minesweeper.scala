package net.st915.minesweeper

import cats.effect.*

import java.awt.Frame

object Minesweeper extends IOApp {

  override def run(args: List[String]): IO[ExitCode] =
    IO {
      val frame = new Frame("Minesweeper")
      frame.setSize(300, 400)
      frame.setVisible(true)
    } >> IO(ExitCode.Success)

}
