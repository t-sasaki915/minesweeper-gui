package net.st915.scalikeawt

package object graphics {

  trait Element

  case class Canvas[Model, Msg](
    override val size: Dimension,
    elements: List[Element],
    onClick: Option[Msg],
    model: Model
  ) extends Frame.Component

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
    color: Color
  ) extends Element

  case class Polygon(
    points: List[Coordinate],
    color: Color,
    fill: Boolean
  ) extends Element

  case class Text(
    content: String,
    coord: Coordinate,
    color: Color
  ) extends Element

  object dsl {

    def canvas[Model, Msg](
      size: Dimension,
      onClick: Option[Msg] = None
    )(elements: Element*)(using model: Model): Canvas[Model, Msg] =
      Canvas[Model, Msg](size, elements.toList, onClick, model)

    def line(
      c1: Coordinate,
      c2: Coordinate,
      color: Color = Color.default
    ): Line = Line(c1, c2, color)

    def rect(
      coord: Coordinate,
      size: Dimension,
      color: Color = Color.default,
      fill: Boolean = true
    ): Rect = Rect(coord, size, color, fill)

    def roundRect(
      coord: Coordinate,
      size: Dimension,
      arc: Dimension,
      color: Color = Color.default,
      fill: Boolean = true
    ): RoundRect = RoundRect(coord, size, arc, color, fill)

    def oval(
      coord: Coordinate,
      size: Dimension,
      color: Color = Color.default,
      fill: Boolean = true
    ): Oval = Oval(coord, size, color, fill)

    def circle(
      coord: Coordinate,
      r: Int,
      color: Color = Color.default,
      fill: Boolean = true
    ): Oval = Oval(Coordinate(coord.x - r, coord.y - r), Dimension(r * 2, r * 2), color, fill)

    def arc(
      coord: Coordinate,
      size: Dimension,
      startAngle: Int,
      arcAngle: Int,
      color: Color = Color.default,
      fill: Boolean = true
    ): Arc = Arc(coord, size, startAngle, arcAngle, color, fill)

    def polyline(
      color: Color = Color.default
    )(points: Coordinate*): Polyline = Polyline(points.toList, color)

    def polygon(
      color: Color = Color.default,
      fill: Boolean = true
    )(points: Coordinate*): Polygon = Polygon(points.toList, color, fill)

    def text(
      content: String,
      coord: Coordinate,
      color: Color = Color.default
    ): Text = Text(content, coord, color)

  }

}
