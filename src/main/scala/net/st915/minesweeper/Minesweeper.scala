package net.st915.minesweeper

import cats.effect.IO
import net.st915.scalikeawt.*
import net.st915.scalikeawt.menus.*

object Minesweeper extends ScalikeAwtApp[Model, Msg] {

  override def init(args: List[String]): IO[Model] =
    IO(Model())

  override def update(msg: Msg, model: Model): IO[Model] =
    msg match
      case Msg.Exit =>
        System.exit(0)
        IO(model)

  override def render(model: Model): IO[Frame[Msg]] =
    IO {
      Frame(
        title = "Minesweeper",
        size = Dimension(300, 400),
        mainMenu = Some(
          menuBar(
            menu("File")(
              menuItem("Exit", Msg.Exit),
              menuSeparator,
              menu("TEST")(
                menuItem("AAA", Msg.Exit),
                menuItem("BBB", Msg.Exit)
              )
            )
          )
        )
      )
    }

}
