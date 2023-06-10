package net.st915.scalikeawt

import cats.effect.*

trait ScalikeAwtApp[Model, Msg] extends IOApp {

  def init(args: List[String]): IO[Model]

  def update(msg: Msg, model: Model): IO[Model]

  def render(using model: Model): Frame[Model, Msg]

  override final def run(args: List[String]): IO[ExitCode] =
    for {
      given Model <- init(args)
      _ <- Kernel.updateFrame(render)
      _ <- IO { Kernel.mainFrame.setVisible(true) }
      instance <- IO(Kernel.Program(init, update)(render))
      _ <- IO { Kernel.instance = Some(instance) }
    } yield ExitCode.Success

}
