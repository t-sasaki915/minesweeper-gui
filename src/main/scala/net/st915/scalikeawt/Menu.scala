package net.st915.scalikeawt

case class Menu[Model, Msg](label: String)(val children: (MenuItem[Model, Msg] | Menu[Model, Msg])*)
