package net.st915.minesweeper

import net.st915.scalikeawt.graphics.Element
import net.st915.scalikeawt.{Color, Coordinate, Dimension}

object Image {

  import net.st915.scalikeawt.graphics.dsl.*

  case object MineIcon extends Image {

    override val draw: List[Element] =
      List(
        circle(Coordinate(15, 15), 11),
        rect(Coordinate(14, 0), Dimension(2, 30)),
        rect(Coordinate(0, 14), Dimension(30, 2)),
        polygon()(
          Coordinate(5, 6),
          Coordinate(6, 5),
          Coordinate(25, 24),
          Coordinate(24, 25)
        ),
        polygon()(
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
        polygon()(
          Coordinate(0, 22),
          Coordinate(5, 15),
          Coordinate(17, 15),
          Coordinate(22, 22)
        ),
        rect(Coordinate(10, 1), Dimension(2, 14)),
        polygon(Color.Red)(
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
