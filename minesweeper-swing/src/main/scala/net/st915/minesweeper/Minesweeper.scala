package net.st915.minesweeper

import cats.effect.*

object Minesweeper extends IOApp {

  override def run(args: List[String]): IO[ExitCode] =
    IO.println("AAAA") >> IO(ExitCode.Success)

}
