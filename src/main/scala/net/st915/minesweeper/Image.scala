package net.st915.minesweeper

import net.st915.scalikeawt.graphics.Element
import net.st915.scalikeawt.{Color, Coordinate, Dimension}

object Image {

  import net.st915.scalikeawt.graphics.dsl.*

  case object MineIcon extends Image {

    override val draw: List[Element] =
      List(
        circle(coord = Coordinate(15, 15), r = 11, fill = true),
        rect(coord = Coordinate(14, 0), size = Dimension(2, 30), fill = true),
        rect(coord = Coordinate(0, 14), size = Dimension(30, 2), fill = true),
        polygon(fill = true)(
          Coordinate(5, 6),
          Coordinate(6, 5),
          Coordinate(25, 24),
          Coordinate(24, 25)
        ),
        polygon(fill = true)(
          Coordinate(25, 6),
          Coordinate(24, 5),
          Coordinate(5, 24),
          Coordinate(6, 25)
        )
      )

  }

  case object FlagIcon extends Image {

    override val draw: List[Element] =
      List(
        polygon(fill = true)(
          Coordinate(0, 22),
          Coordinate(5, 15),
          Coordinate(17, 15),
          Coordinate(22, 22)
        ),
        rect(coord = Coordinate(10, 1), size = Dimension(2, 14), fill = true),
        polygon(color = Color.Red, fill = true)(
          Coordinate(10, 1),
          Coordinate(10, 10),
          Coordinate(1, 5)
        )
      )

  }

}

trait Image {

  val draw: List[Element]

}
