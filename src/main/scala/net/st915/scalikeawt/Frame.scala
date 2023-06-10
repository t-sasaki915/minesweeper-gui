package net.st915.scalikeawt

import net.st915.scalikeawt.menus.MenuBar

case class Frame[Model, Msg](
  title: String,
  size: Dimension,
  mainMenu: Option[MenuBar[Model, Msg]] = None
)
