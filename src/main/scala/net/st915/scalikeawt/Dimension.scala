package net.st915.scalikeawt

import cats.Monoid

object Dimension {

  given Monoid[Dimension] with
    override def empty: Dimension =
      Dimension(0, 0)

    override def combine(x: Dimension, y: Dimension): Dimension =
      Dimension(x.width + y.width, x.height + y.height)

}

case class Dimension(width: Int, height: Int)
