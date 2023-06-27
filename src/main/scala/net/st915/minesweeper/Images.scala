package net.st915.minesweeper

import net.st915.scalikeawt.graphics.Element
import net.st915.scalikeawt.{Color, Coordinate, Dimension}

object Images {

  import net.st915.scalikeawt.graphics.dsl.*

  val notOpenedCell: List[Element] =
    List(
      polygon(Color.White)(
        Coordinate(0, 0),
        Coordinate(32, 0),
        Coordinate(27, 5),
        Coordinate(0, 5)
      ),
      polygon(Color.White)(
        Coordinate(0, 5),
        Coordinate(0, 32),
        Coordinate(5, 27),
        Coordinate(5, 5)
      ),
      polygon(Color.fromRGB(160, 160, 160))(
        Coordinate(0, 32),
        Coordinate(32, 32),
        Coordinate(32, 27),
        Coordinate(5, 27)
      ),
      polygon(Color.fromRGB(160, 160, 160))(
        Coordinate(32, 0),
        Coordinate(32, 27),
        Coordinate(27, 27),
        Coordinate(27, 5)
      ),
      rect(Coordinate(5, 5), Dimension(22, 22), Color.fromRGB(187, 187, 187))
    )

  val openedCell: List[Element] =
    List(
      rect(Coordinate(0, 0), Dimension(32, 32), Color.fromRGB(133, 133, 133)),
      rect(Coordinate(1, 1), Dimension(30, 30), Color.fromRGB(192, 192, 192))
    )

  val redCell: List[Element] =
    List(
      rect(Coordinate(0, 0), Dimension(32, 32), Color.fromRGB(133, 133, 133)),
      rect(Coordinate(1, 1), Dimension(30, 30), Color.Red)
    )

  val mineIcon: List[Element] =
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

  val flagIcon: List[Element] =
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

  val fakeFlagIcon: List[Element] =
    List(
      polygon(Color.Gray)(
        Coordinate(0, 22),
        Coordinate(5, 15),
        Coordinate(17, 15),
        Coordinate(22, 22)
      ),
      rect(Coordinate(10, 1), Dimension(2, 14), Color.Gray),
      polygon(Color.Gray)(
        Coordinate(10, 1),
        Coordinate(10, 10),
        Coordinate(1, 5)
      )
    )

  val wrongFlagIcon: List[Element] =
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
      ),
      polygon(Color.Red)(
        Coordinate(2, 0),
        Coordinate(0, 0),
        Coordinate(20, 22),
        Coordinate(22, 22)
      ),
      polygon(Color.Red)(
        Coordinate(0, 22),
        Coordinate(2, 22),
        Coordinate(22, 0),
        Coordinate(20, 0)
      )
    )

  def numIcon(n: Int): List[Element] =
    n match
      case 1 =>
        List(
          rect(Coordinate(13, 2), Dimension(5, 21), Color.fromRGB(2, 0, 249)),
          rect(Coordinate(5, 23), Dimension(20, 5), Color.fromRGB(2, 0, 249)),
          rect(Coordinate(6, 7), Dimension(7, 5), Color.fromRGB(2, 0, 249))
        )

      case 2 =>
        List(
          rect(Coordinate(5, 2), Dimension(20, 5), Color.fromRGB(0, 128, 1)),
          rect(Coordinate(20, 7), Dimension(5, 6), Color.fromRGB(0, 128, 1)),
          rect(Coordinate(5, 13), Dimension(20, 5), Color.fromRGB(0, 128, 1)),
          rect(Coordinate(5, 18), Dimension(5, 5), Color.fromRGB(0, 128, 1)),
          rect(Coordinate(5, 23), Dimension(20, 5), Color.fromRGB(0, 128, 1))
        )

      case 3 =>
        List(
          rect(Coordinate(5, 2), Dimension(20, 5), Color.fromRGB(253, 1, 0)),
          rect(Coordinate(20, 7), Dimension(5, 6), Color.fromRGB(253, 1, 0)),
          rect(Coordinate(5, 13), Dimension(20, 5), Color.fromRGB(253, 1, 0)),
          rect(Coordinate(20, 18), Dimension(5, 5), Color.fromRGB(253, 1, 0)),
          rect(Coordinate(5, 23), Dimension(20, 5), Color.fromRGB(253, 1, 0))
        )

      case 4 =>
        List(
          rect(Coordinate(5, 2), Dimension(5, 11), Color.fromRGB(1, 0, 128)),
          rect(Coordinate(20, 2), Dimension(5, 26), Color.fromRGB(1, 0, 128)),
          rect(Coordinate(5, 13), Dimension(15, 5), Color.fromRGB(1, 0, 128))
        )

      case 5 =>
        List(
          rect(Coordinate(5, 2), Dimension(20, 5), Color.fromRGB(128, 0, 2)),
          rect(Coordinate(5, 7), Dimension(5, 6), Color.fromRGB(128, 0, 2)),
          rect(Coordinate(5, 13), Dimension(20, 5), Color.fromRGB(128, 0, 2)),
          rect(Coordinate(20, 18), Dimension(5, 5), Color.fromRGB(128, 0, 2)),
          rect(Coordinate(5, 23), Dimension(20, 5), Color.fromRGB(128, 0, 2))
        )

      case 6 =>
        List(
          rect(Coordinate(5, 2), Dimension(20, 5), Color.fromRGB(0, 129, 124)),
          rect(Coordinate(5, 7), Dimension(5, 16), Color.fromRGB(0, 129, 124)),
          rect(Coordinate(10, 13), Dimension(15, 5), Color.fromRGB(0, 129, 124)),
          rect(Coordinate(20, 18), Dimension(5, 5), Color.fromRGB(0, 129, 124)),
          rect(Coordinate(5, 23), Dimension(20, 5), Color.fromRGB(0, 129, 124))
        )

      case 7 =>
        List(
          rect(Coordinate(5, 2), Dimension(20, 5), Color.Black),
          rect(Coordinate(5, 7), Dimension(5, 6), Color.Black),
          rect(Coordinate(20, 7), Dimension(5, 21), Color.Black)
        )

      case 8 =>
        List(
          rect(Coordinate(10, 2), Dimension(10, 5), Color.fromRGB(128, 128, 128)),
          rect(Coordinate(10, 13), Dimension(10, 5), Color.fromRGB(128, 128, 128)),
          rect(Coordinate(5, 2), Dimension(5, 26), Color.fromRGB(128, 128, 128)),
          rect(Coordinate(20, 2), Dimension(5, 26), Color.fromRGB(128, 128, 128)),
          rect(Coordinate(10, 23), Dimension(10, 5), Color.fromRGB(128, 128, 128))
        )

      case _ =>
        Nil

}
