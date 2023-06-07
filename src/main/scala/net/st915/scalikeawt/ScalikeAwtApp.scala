package net.st915.scalikeawt

import cats.effect.*

trait ScalikeAwtApp[Model, Msg] extends IOApp {

  def init(args: List[String]): IO[Model]

  def update(msg: Msg, model: Model): IO[Model]

  def render(model: Model): IO[Frame]

  override final def run(args: List[String]): IO[ExitCode] =
    for {
      initModel <- init(args)
      initFrame <- render(initModel)
      _ <- Kernel.updateFrame(initFrame)
      _ <- IO { Kernel.mainFrame.setVisible(true) }
    } yield ExitCode.Success

}
