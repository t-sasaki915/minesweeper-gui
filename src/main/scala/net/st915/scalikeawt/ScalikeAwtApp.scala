package net.st915.scalikeawt

import cats.effect.*
import net.st915.scalikeawt.system.Kernel

trait ScalikeAwtApp[Model, Msg] extends IOApp {

  def init(args: List[String]): Model

  def update(msg: Msg)(using model: Model): IO[Model]

  def render(using model: Model): Frame[Model, Msg]

  override final def run(args: List[String]): IO[ExitCode] = {
    given Model = init(args)

    for {
      _ <- Kernel.updateFrame(render, summon)
      _ <- IO {
        Kernel.mainFrame.setVisible(true)
      }
      instance <- IO(Kernel.Program(init)(update, render))
      _ <- IO {
        Kernel.instance = Some(instance)
      }
    } yield ExitCode.Success
  }

}
