package net.st915.scalikeawt

package object graphics {

  trait Element

  case class Canvas(override val size: Dimension, elements: List[Element]) extends Frame.Component

  case class Line(
    c1: Coordinate,
    c2: Coordinate,
    color: Color
  ) extends Element

  case class Rect(
    coord: Coordinate,
    size: Dimension,
    color: Color,
    fill: Boolean
  ) extends Element

  case class RoundRect(
    coord: Coordinate,
    size: Dimension,
    arc: Dimension,
    color: Color,
    fill: Boolean
  ) extends Element

  case class Oval(
    coord: Coordinate,
    size: Dimension,
    color: Color,
    fill: Boolean
  ) extends Element

  case class Arc(
    coord: Coordinate,
    size: Dimension,
    startAngle: Int,
    arcAngle: Int,
    color: Color,
    fill: Boolean
  ) extends Element

  case class Polyline(
    points: List[Coordinate],
    nPoints: Int,
    color: Color
  ) extends Element

  case class Polygon(
    points: List[Coordinate],
    nPoints: Int,
    color: Color,
    fill: Boolean
  ) extends Element

  case class Text(
    content: String,
    coord: Coordinate,
    color: Color
  ) extends Element

  object dsl {

    def canvas(size: Dimension)(elements: Element*): Canvas =
      Canvas(size, elements.toList)

    def line(
      c1: Coordinate,
      c2: Coordinate,
      color: Color = Color.default
    ): Line = Line(c1, c2, color)

    def rect(
      coord: Coordinate,
      size: Dimension,
      color: Color = Color.default,
      fill: Boolean = false
    ): Rect = Rect(coord, size, color, fill)

    def roundRect(
      coord: Coordinate,
      size: Dimension,
      arc: Dimension,
      color: Color = Color.default,
      fill: Boolean = false
    ): RoundRect = RoundRect(coord, size, arc, color, fill)

    def oval(
      coord: Coordinate,
      size: Dimension,
      color: Color = Color.default,
      fill: Boolean = false
    ): Oval = Oval(coord, size, color, fill)

    def arc(
      coord: Coordinate,
      size: Dimension,
      startAngle: Int,
      arcAngle: Int,
      color: Color = Color.default,
      fill: Boolean = false
    ): Arc = Arc(coord, size, startAngle, arcAngle, color, fill)

    def polyline(
      points: List[Coordinate],
      nPoints: Int,
      color: Color = Color.default
    ): Polyline = Polyline(points, nPoints, color)

    def polygon(
      points: List[Coordinate],
      nPoints: Int,
      color: Color = Color.default,
      fill: Boolean = false
    ): Polygon = Polygon(points, nPoints, color, fill)

    def text(
      content: String,
      coord: Coordinate,
      color: Color = Color.default
    ): Text = Text(content, coord, color)

  }

}
