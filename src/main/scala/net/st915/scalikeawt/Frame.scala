package net.st915.scalikeawt

case class Frame[Model, Msg](
  title: String,
  size: Dimension,
  mainMenu: Option[MenuBar[Model, Msg]] = None
)
