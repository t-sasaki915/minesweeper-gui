package net.st915.minesweeper

object Difficulty {

  val default: Difficulty = Difficulty.Easy

  val all: List[Difficulty] =
    List(
      Easy,
      Normal,
      Hard,
      Impossible
    )

}

enum Difficulty(val name: String, width: Int, height: Int, mineCount: Int) {

  case Easy extends Difficulty("Easy", 9, 9, 10)

  case Normal extends Difficulty("Normal", 16, 16, 40)

  case Hard extends Difficulty("Hard", 30, 16, 99)

  case Impossible extends Difficulty("Impossible", 9, 9, 67)

}
