package net.st915.minesweeper

object Msg {

  case object MenuClick1 extends Msg

  case object MenuClick2 extends Msg

  case object Exit extends Msg

}

sealed trait Msg
