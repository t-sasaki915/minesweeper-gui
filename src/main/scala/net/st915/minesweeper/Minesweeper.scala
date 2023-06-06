package net.st915.minesweeper

import cats.effect.*

import swing.*

object Minesweeper extends IOApp {

  val mainWindow: MainFrame =
    new MainFrame {

      title = "Minesweeper"

      size = new Dimension(300, 400)

    }

  override def run(args: List[String]): IO[ExitCode] =
    IO(mainWindow.visible = true) >> IO(ExitCode.Success)

}
