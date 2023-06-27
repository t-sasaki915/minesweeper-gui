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

          canvas[Model, Msg](Dimension(32, 32))(Images.notOpenedCell: _*)
        },
        Coordinate(32, 0) -> {
          import net.st915.scalikeawt.graphics.dsl.*

          canvas[Model, Msg](Dimension(32, 32))(Images.notOpenedCellWithFlag: _*)
        },
        Coordinate(64, 0) -> {
          import net.st915.scalikeawt.graphics.dsl.*

          canvas[Model, Msg](Dimension(32, 32))(Images.notOpenedCellWithFakeFlag: _*)
        },
        Coordinate(96, 0) -> {
          import net.st915.scalikeawt.graphics.dsl.*

          canvas[Model, Msg](Dimension(32, 32))(Images.notOpenedCellWithWrongFlag: _*)
        },
        Coordinate(0, 32) -> {
          import net.st915.scalikeawt.graphics.dsl.*

          canvas[Model, Msg](Dimension(32, 32))(Images.openedCell: _*)
        },
        Coordinate(32, 32) -> {
          import net.st915.scalikeawt.graphics.dsl.*

          canvas[Model, Msg](Dimension(32, 32))(Images.openedCellWithMine: _*)
        },
        Coordinate(64, 32) -> {
          import net.st915.scalikeawt.graphics.dsl.*

          canvas[Model, Msg](Dimension(32, 32))(Images.causeCell: _*)
        },
        Coordinate(96, 32) -> {
          import net.st915.scalikeawt.graphics.dsl.*

          canvas[Model, Msg](Dimension(32, 32))(Images.openedCellWithNumber(8): _*)
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
