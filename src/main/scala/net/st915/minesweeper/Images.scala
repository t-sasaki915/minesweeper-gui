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

  private val redCell: List[Element] =
    List(
      rect(Coordinate(0, 0), Dimension(32, 32), Color.fromRGB(133, 133, 133)),
      rect(Coordinate(1, 1), Dimension(30, 30), Color.Red)
    )

  private val mineIcon: List[Element] =
    List(
      circle(Coordinate(16, 16), 11),
      rect(Coordinate(15, 1), Dimension(2, 30)),
      rect(Coordinate(1, 15), Dimension(30, 2)),
      polygon()(
        Coordinate(6, 7),
        Coordinate(7, 6),
        Coordinate(26, 25),
        Coordinate(25, 26)
      ),
      polygon()(
        Coordinate(26, 7),
        Coordinate(25, 6),
        Coordinate(6, 25),
        Coordinate(7, 26)
      )
    )

  private val flagIcon: List[Element] =
    List(
      polygon()(
        Coordinate(5, 27),
        Coordinate(10, 20),
        Coordinate(22, 20),
        Coordinate(27, 27)
      ),
      rect(Coordinate(15, 6), Dimension(2, 14)),
      polygon(Color.Red)(
        Coordinate(15, 6),
        Coordinate(15, 15),
        Coordinate(6, 10)
      )
    )

  private val fakeFlagIcon: List[Element] =
    List(
      polygon(Color.Gray)(
        Coordinate(5, 27),
        Coordinate(10, 20),
        Coordinate(22, 20),
        Coordinate(27, 27)
      ),
      rect(Coordinate(15, 6), Dimension(2, 14), Color.Gray),
      polygon(Color.Gray)(
        Coordinate(15, 6),
        Coordinate(15, 15),
        Coordinate(6, 10)
      )
    )

  private val wrongFlagIcon: List[Element] =
    List(
      polygon()(
        Coordinate(5, 27),
        Coordinate(10, 20),
        Coordinate(22, 20),
        Coordinate(27, 27)
      ),
      rect(Coordinate(15, 6), Dimension(2, 14)),
      polygon(Color.Red)(
        Coordinate(15, 6),
        Coordinate(15, 15),
        Coordinate(6, 10)
      ),
      polygon(Color.Red)(
        Coordinate(7, 5),
        Coordinate(5, 5),
        Coordinate(25, 27),
        Coordinate(27, 27)
      ),
      polygon(Color.Red)(
        Coordinate(5, 27),
        Coordinate(7, 27),
        Coordinate(27, 5),
        Coordinate(25, 5)
      )
    )

  private def numIcon(n: Int): List[Element] =
    n match
      case 1 =>
        List(
          rect(Coordinate(14, 3), Dimension(5, 21), Color.fromRGB(2, 0, 249)),
          rect(Coordinate(6, 24), Dimension(20, 5), Color.fromRGB(2, 0, 249)),
          rect(Coordinate(7, 8), Dimension(7, 5), Color.fromRGB(2, 0, 249))
        )

      case 2 =>
        List(
          rect(Coordinate(6, 3), Dimension(20, 5), Color.fromRGB(0, 128, 1)),
          rect(Coordinate(21, 8), Dimension(5, 6), Color.fromRGB(0, 128, 1)),
          rect(Coordinate(6, 14), Dimension(20, 5), Color.fromRGB(0, 128, 1)),
          rect(Coordinate(6, 19), Dimension(5, 5), Color.fromRGB(0, 128, 1)),
          rect(Coordinate(6, 24), Dimension(20, 5), Color.fromRGB(0, 128, 1))
        )

      case 3 =>
        List(
          rect(Coordinate(6, 3), Dimension(20, 5), Color.fromRGB(253, 1, 0)),
          rect(Coordinate(21, 8), Dimension(5, 6), Color.fromRGB(253, 1, 0)),
          rect(Coordinate(6, 14), Dimension(20, 5), Color.fromRGB(253, 1, 0)),
          rect(Coordinate(21, 19), Dimension(5, 5), Color.fromRGB(253, 1, 0)),
          rect(Coordinate(6, 24), Dimension(20, 5), Color.fromRGB(253, 1, 0))
        )

      case 4 =>
        List(
          rect(Coordinate(6, 3), Dimension(5, 11), Color.fromRGB(1, 0, 128)),
          rect(Coordinate(21, 3), Dimension(5, 26), Color.fromRGB(1, 0, 128)),
          rect(Coordinate(6, 14), Dimension(15, 5), Color.fromRGB(1, 0, 128))
        )

      case 5 =>
        List(
          rect(Coordinate(6, 3), Dimension(20, 5), Color.fromRGB(128, 0, 2)),
          rect(Coordinate(6, 8), Dimension(5, 6), Color.fromRGB(128, 0, 2)),
          rect(Coordinate(6, 14), Dimension(20, 5), Color.fromRGB(128, 0, 2)),
          rect(Coordinate(21, 19), Dimension(5, 5), Color.fromRGB(128, 0, 2)),
          rect(Coordinate(6, 24), Dimension(20, 5), Color.fromRGB(128, 0, 2))
        )

      case 6 =>
        List(
          rect(Coordinate(6, 3), Dimension(20, 5), Color.fromRGB(0, 129, 124)),
          rect(Coordinate(6, 8), Dimension(5, 16), Color.fromRGB(0, 129, 124)),
          rect(Coordinate(11, 14), Dimension(15, 5), Color.fromRGB(0, 129, 124)),
          rect(Coordinate(21, 19), Dimension(5, 5), Color.fromRGB(0, 129, 124)),
          rect(Coordinate(6, 24), Dimension(20, 5), Color.fromRGB(0, 129, 124))
        )

      case 7 =>
        List(
          rect(Coordinate(6, 3), Dimension(20, 5), Color.Black),
          rect(Coordinate(6, 8), Dimension(5, 6), Color.Black),
          rect(Coordinate(21, 8), Dimension(5, 21), Color.Black)
        )

      case 8 =>
        List(
          rect(Coordinate(11, 3), Dimension(10, 5), Color.fromRGB(128, 128, 128)),
          rect(Coordinate(11, 14), Dimension(10, 5), Color.fromRGB(128, 128, 128)),
          rect(Coordinate(6, 3), Dimension(5, 26), Color.fromRGB(128, 128, 128)),
          rect(Coordinate(21, 3), Dimension(5, 26), Color.fromRGB(128, 128, 128)),
          rect(Coordinate(11, 24), Dimension(10, 5), Color.fromRGB(128, 128, 128))
        )

      case _ =>
        Nil

  val notOpenedCellWithFlag: List[Element] =
    notOpenedCell ++ flagIcon

  val notOpenedCellWithFakeFlag: List[Element] =
    notOpenedCell ++ fakeFlagIcon

  val notOpenedCellWithWrongFlag: List[Element] =
    notOpenedCell ++ wrongFlagIcon

  val openedCellWithMine: List[Element] =
    openedCell ++ mineIcon

  val causeCell: List[Element] =
    redCell ++ mineIcon

  def openedCellWithNumber(n: Int): List[Element] =
    openedCell ++ numIcon(n)

}
