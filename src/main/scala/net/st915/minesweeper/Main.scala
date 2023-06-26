package net.st915.minesweeper

import cats.effect.{ExitCode, IO}
import net.st915.scalikeawt.*

object Main extends ScalikeAwtApp[Model, Msg] {

  override def init(args: List[String]): Model =
    Model(Difficulty.default)

  override def update(msg: Msg)(using model: Model): IO[Model] =
    msg match
      case Msg.UpdateDifficulty(newDifficulty) =>
        IO(model.copy(difficulty = newDifficulty))

      case Msg.Exit =>
        system.exitUpdate(ExitCode.Success)

  override def render(using model: Model): Frame[Model, Msg] =
    Frame(
      title = s"${model.difficulty.name} Minesweeper",
      size = Dimension(300, 400),
      resizable = false,
      onCloseButtonClick = Msg.Exit,
      components = Map(
        Coordinate(0, 0) -> {
          import net.st915.scalikeawt.graphics.dsl.*

          canvas[Model, Msg](Dimension(30, 30))(
            Image.MineIcon.draw: _*
          )
        },
        Coordinate(30, 0) -> {
          import net.st915.scalikeawt.graphics.dsl.*

          canvas[Model, Msg](Dimension(22, 22))(
            Image.FlagIcon.draw: _*
          )
        }
      ),
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
                onClick = Msg.UpdateDifficulty(diff),
                enabled = model.difficulty != diff
              )
            }: _*
          )
        )
      }
    )

}
