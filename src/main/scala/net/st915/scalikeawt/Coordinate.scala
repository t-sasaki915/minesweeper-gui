package net.st915.scalikeawt

import cats.Monoid

object Coordinate {

  given Monoid[Coordinate] with
    override def empty: Coordinate =
      Coordinate(0, 0)

    override def combine(x: Coordinate, y: Coordinate): Coordinate =
      Coordinate(x.x + y.x, x.y + y.y)

}

case class Coordinate(x: Int, y: Int)
