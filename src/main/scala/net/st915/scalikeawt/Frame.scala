package net.st915.scalikeawt

import net.st915.scalikeawt.menus.MenuBar

case class Frame[Msg](
  title: String,
  size: Dimension,
  mainMenu: Option[MenuBar[Msg]] = None
)
