package net.st915.scalikeawt

import cats.effect.*

trait ScalikeAwtApp[Model, Msg] extends IOApp {

  def init(args: List[String]): IO[Model]

  def update(msg: Msg, model: Model): IO[Model]

  def render(model: Model): Frame[Msg]

  override final def run(args: List[String]): IO[ExitCode] =
    for {
      initModel <- init(args)
      _ <- Kernel.updateFrame(render(initModel))
      _ <- IO { Kernel.mainFrame.setVisible(true) }
      instance <- IO {
        Kernel.Program(
          initializer = init,
          updater = update,
          renderer = render
        )
      }
      _ <- IO { Kernel.instance = Some(instance) }
    } yield ExitCode.Success

}
