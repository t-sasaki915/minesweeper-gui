package net.st915.minesweeper

import cats.effect.{ExitCode, IO}
import net.st915.scalikeawt.*

object Minesweeper extends ScalikeAwtApp[Model, Msg] {

  override def init(args: List[String]): IO[Model] =
    IO(Model("ABCD"))

  override def update(msg: Msg)(using model: Model): IO[Model] =
    msg match
      case Msg.MenuClick1 =>
        IO(model.copy(test = "1234"))

      case Msg.MenuClick2 =>
        IO(model.copy(test = "!@#$"))

      case Msg.Exit =>
        ScalikeAwtApp.exitWithModel(ExitCode.Success)

  override def render(using model: Model): Frame[Model, Msg] =
    Frame(
      title = model.test,
      size = Dimension(300, 400),
      mainMenu = Some {
        import net.st915.scalikeawt.menus.dsl.*

        menuBar(
          menu("File")(
            menu("TEST")(
              item("AAA", Msg.MenuClick1, model.test != "1234"),
              item("BBB", Msg.MenuClick2, model.test != "!@#$")
            ),
            separator,
            item("Exit", Msg.Exit)
          )
        )
      }
    )

}
