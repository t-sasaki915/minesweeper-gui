package net.st915.minesweeper

import cats.effect.*
import net.st915.scalikeawt.*

object Minesweeper extends ScalikeAwtApp[Model, Msg] {

  override def init(args: List[String]): IO[Model] =
    IO(Model())

  override def update(msg: Msg, model: Model): IO[Model] =
    IO(model)

  override def render(model: Model): IO[Frame] =
    IO {
      Frame(
        title = "Minesweeper",
        size = Dimension(300, 400)
      )
    }

}
