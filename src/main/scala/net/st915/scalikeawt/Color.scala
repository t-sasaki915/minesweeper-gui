package net.st915.scalikeawt

object Color {

  final val White = Color(255, 255, 255)

  final val LightGray = Color(192, 192, 192)

  final val Gray = Color(128, 128, 128)

  final val DarkGray = Color(64, 64, 64)

  final val Black = Color(0, 0, 0)

  final val Red = Color(255, 0, 0)

  final val Pink = Color(255, 175, 175)

  final val Orange = Color(255, 200, 0)

  final val Yellow = Color(255, 255, 0)

  final val Green = Color(0, 255, 0)

  final val Magenta = Color(255, 0, 255)

  final val Cyan = Color(0, 255, 255)

  final val Blue = Color(0, 0, 255)

  val default: Color = Black

  def fromRGB(r: Int, g: Int, b: Int): Color =
    Color(r, g, b)

}

case class Color(r: Int, g: Int, b: Int)
