package net.st915.scalikeawt.system

import net.st915.scalikeawt.Color
import net.st915.scalikeawt.graphics.*

import java.awt.event.MouseEvent
import scala.util.chaining.*

private[scalikeawt] case class CanvasConverter[Model, Msg]() {

  private def updateColor(color: Color, g: java.awt.Graphics): Unit =
    g.setColor(new java.awt.Color(color.r, color.g, color.b))

  def convertCanvas(canvas: Canvas[Model, Msg]): java.awt.Canvas =
    new java.awt.Canvas() {

      override def paint(g: java.awt.Graphics): Unit =
        canvas.elements.foreach {
          case Line(c1, c2, color) =>
            updateColor(color, g)
            g.drawLine(c1.x, c1.y, c2.x, c2.y)

          case Rect(coord, size, color, fill) =>
            updateColor(color, g)
            if fill then
              g.fillRect(coord.x, coord.y, size.width, size.height)
            else
              g.drawRect(coord.x, coord.y, size.width, size.height)

          case RoundRect(coord, size, arc, color, fill) =>
            updateColor(color, g)
            if fill then
              g.fillRoundRect(coord.x, coord.y, size.width, size.height, arc.width, arc.height)
            else
              g.drawRoundRect(coord.x, coord.y, size.width, size.height, arc.width, arc.height)

          case Oval(coord, size, color, fill) =>
            updateColor(color, g)
            if fill then
              g.fillOval(coord.x, coord.y, size.width, size.height)
            else
              g.drawOval(coord.x, coord.y, size.width, size.height)

          case Arc(coord, size, startAngle, arcAngle, color, fill) =>
            updateColor(color, g)
            if fill then
              g.fillArc(coord.x, coord.y, size.width, size.height, startAngle, arcAngle)
            else
              g.drawArc(coord.x, coord.y, size.width, size.height, startAngle, arcAngle)

          case Polyline(points, color) =>
            updateColor(color, g)
            g.drawPolyline(points.map(_.x).toArray, points.map(_.y).toArray, points.size)

          case Polygon(points, color, fill) =>
            updateColor(color, g)
            if fill then
              g.fillPolygon(points.map(_.x).toArray, points.map(_.y).toArray, points.size)
            else
              g.drawPolygon(points.map(_.x).toArray, points.map(_.y).toArray, points.size)

          case Text(content, coord, color) =>
            updateColor(color, g)
            g.drawString(content, coord.x, coord.y)

        }

    }.tap(_.setSize(canvas.size.width, canvas.size.height))
      .tap { nativeCanvas =>
        if canvas.onClick.nonEmpty then
          nativeCanvas.addMouseListener(new java.awt.event.MouseAdapter() {

            override def mouseClicked(e: MouseEvent): Unit = {
              import cats.effect.unsafe.implicits.global

              Kernel.performMsg(canvas.onClick.get, canvas.model).unsafeRunSync()
            }

          })
      }

}
