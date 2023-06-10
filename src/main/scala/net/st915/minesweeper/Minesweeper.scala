package net.st915.minesweeper

import cats.effect.{ExitCode, IO}
import net.st915.scalikeawt.*

object Minesweeper extends ScalikeAwtApp[Model, Msg] {

  override def init(args: List[String]): IO[Model] =
    IO(Model())

  override def update(msg: Msg)(using Model): IO[Model] =
    msg match
      case Msg.Exit =>
        ScalikeAwtApp.exitWithModel(ExitCode.Success)

  override def render(using Model): Frame[Model, Msg] =
    Frame(
      title = "Minesweeper",
      size = Dimension(300, 400),
      mainMenu = Some {
        import net.st915.scalikeawt.menus.dsl.*

        menuBar(
          menu("File")(
            menu("TEST")(
              item("AAA", Msg.Exit),
              item("BBB", Msg.Exit)
            ),
            separator,
            item("Exit", Msg.Exit)
          )
        )
      }
    )

}
