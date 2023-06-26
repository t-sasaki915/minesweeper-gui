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

          canvas(Dimension(100, 100))(
            rect(
              coord = Coordinate(0, 0),
              size = Dimension(50, 50),
              color = if model.difficulty != Difficulty.Hard then Color.Red else Color.Blue,
              fill = true
            ),
            rect(
              coord = Coordinate(50, 50),
              size = Dimension(50, 50),
              color = if model.difficulty != Difficulty.Hard then Color.Blue else Color.Red,
              fill = true
            )
          )
        },
        Coordinate(100, 100) -> {
          import net.st915.scalikeawt.graphics.dsl.*

          canvas(Dimension(100, 100))(
            rect(
              coord = Coordinate(0, 0),
              size = Dimension(50, 50),
              color = if model.difficulty != Difficulty.Hard then Color.Yellow else Color.Green,
              fill = true
            ),
            rect(
              coord = Coordinate(50, 50),
              size = Dimension(50, 50),
              color = if model.difficulty != Difficulty.Hard then Color.Green else Color.Yellow,
              fill = true
            )
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
