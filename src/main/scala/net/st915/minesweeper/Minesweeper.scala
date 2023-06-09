package net.st915.minesweeper

import cats.effect.IO
import net.st915.scalikeawt.*

object Minesweeper extends ScalikeAwtApp[Model, Msg] {

  override def init(args: List[String]): IO[Model] =
    IO(Model())

  override def update(msg: Msg, model: Model): IO[Model] =
    msg match
      case Msg.Exit =>
        System.exit(0)
        IO(model)

  override def render(model: Model): IO[Frame[Model, Msg]] =
    IO {
      Frame(
        title = "Minesweeper",
        size = Dimension(300, 400),
        mainMenu = Some(
          MenuBar()(
            Menu("File")(
              MenuItem("Exit", _ => IO(Msg.Exit), model)
            )
          )
        )
      )
    }

}
