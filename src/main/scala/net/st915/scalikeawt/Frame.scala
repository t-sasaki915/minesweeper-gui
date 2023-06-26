package net.st915.scalikeawt

import net.st915.scalikeawt.menus.MenuBar

object Frame {

  trait Component {

    val size: Dimension

  }

}

case class Frame[Model, Msg](
  title: String,
  size: Dimension,
  mainMenu: Option[MenuBar[Model, Msg]] = None,
  resizable: Boolean = true,
  onCloseButtonClick: Msg,
  components: Map[Coordinate, Frame.Component]
)
