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

          canvas[Model, Msg](Dimension(30, 30))(Images.mineIcon: _*)
        },
        Coordinate(30, 0) -> {
          import net.st915.scalikeawt.graphics.dsl.*

          canvas[Model, Msg](Dimension(22, 22))(Images.flagIcon: _*)
        },
        Coordinate(52, 0) -> {
          import net.st915.scalikeawt.graphics.dsl.*

          canvas[Model, Msg](Dimension(22, 22))(Images.fakeFlagIcon: _*)
        },
        Coordinate(74, 0) -> {
          import net.st915.scalikeawt.graphics.dsl.*

          canvas[Model, Msg](Dimension(22, 22))(Images.wrongFlagIcon: _*)
        },
        Coordinate(0, 30) -> {
          import net.st915.scalikeawt.graphics.dsl.*

          canvas[Model, Msg](Dimension(30, 30))(Images.numIcon(1): _*)
        },
        Coordinate(30, 30) -> {
          import net.st915.scalikeawt.graphics.dsl.*

          canvas[Model, Msg](Dimension(30, 30))(Images.numIcon(2): _*)
        },
        Coordinate(60, 30) -> {
          import net.st915.scalikeawt.graphics.dsl.*

          canvas[Model, Msg](Dimension(30, 30))(Images.numIcon(3): _*)
        },
        Coordinate(90, 30) -> {
          import net.st915.scalikeawt.graphics.dsl.*

          canvas[Model, Msg](Dimension(30, 30))(Images.numIcon(4): _*)
        },
        Coordinate(0, 60) -> {
          import net.st915.scalikeawt.graphics.dsl.*

          canvas[Model, Msg](Dimension(30, 30))(Images.numIcon(5): _*)
        },
        Coordinate(30, 60) -> {
          import net.st915.scalikeawt.graphics.dsl.*

          canvas[Model, Msg](Dimension(30, 30))(Images.numIcon(6): _*)
        },
        Coordinate(60, 60) -> {
          import net.st915.scalikeawt.graphics.dsl.*

          canvas[Model, Msg](Dimension(30, 30))(Images.numIcon(7): _*)
        },
        Coordinate(90, 60) -> {
          import net.st915.scalikeawt.graphics.dsl.*

          canvas[Model, Msg](Dimension(30, 30))(Images.numIcon(8): _*)
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
