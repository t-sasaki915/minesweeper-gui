package net.st915.minesweeper

import cats.effect.{ExitCode, IO}
import net.st915.scalikeawt.*

object Minesweeper extends ScalikeAwtApp[Model, Msg] {

  override def init(args: List[String]): IO[Model] =
    IO {
      Model(difficulty =
        Difficulty.default
      )
    }

  override def update(msg: Msg)(using model: Model): IO[Model] =
    msg match
      case Msg.UpdateDifficulty(newDifficulty) =>
        IO(model.copy(difficulty = newDifficulty))

      case Msg.Exit =>
        ScalikeAwtApp.exitUpdate(ExitCode.Success)

  override def render(using model: Model): Frame[Model, Msg] =
    Frame(
      title = s"Minesweeper - ${model.difficulty.name}",
      size = Dimension(300, 400),
      mainMenu = Some {
        import net.st915.scalikeawt.menus.dsl.*

        menuBar(
          menu("File")(
            item("Exit", Msg.Exit)
          ),
          menu("Difficulty")(
            Difficulty.all.map { diff =>
              item(
                label = diff.name,
                action = Msg.UpdateDifficulty(diff),
                enabled = model.difficulty != diff
              )
            }: _*
          )
        )
      }
    )

}
