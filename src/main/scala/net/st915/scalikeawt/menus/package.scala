package net.st915.scalikeawt

package object menus {

  case class MenuItem[Msg](label: String, action: Msg)

  case class MenuSeparator[Msg]()

  case class Menu[Msg](label: String,
                       children: List[Menu[Msg] | MenuItem[Msg] | MenuSeparator[Msg]]
  )

  case class MenuBar[Msg](children: List[Menu[Msg]])

  def menuItem[Msg](label: String, action: Msg): MenuItem[Msg] =
    MenuItem(label, action)

  def menuSeparator[Msg]: MenuSeparator[Msg] =
    MenuSeparator()

  def menu[Msg](label: String)(children: (Menu[Msg] | MenuItem[Msg] | MenuSeparator[Msg])*)
    : Menu[Msg] =
    Menu(label, children.toList)

  def menuBar[Msg](children: Menu[Msg]*): MenuBar[Msg] =
    MenuBar(children.toList)

}
