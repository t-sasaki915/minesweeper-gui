package net.st915.minesweeper

enum Msg {

  case UpdateDifficulty(newDifficulty: Difficulty) extends Msg

  case Exit extends Msg

}
