package net.st915.scalikeawt

case class MenuBar[Model, Msg]()(val menus: Menu[Model, Msg]*)
