package net.st915.scalikeawt

package object menus {

  case class MenuItem[Model, Msg](label: String, action: Msg, model: Model)

  case class MenuSeparator[Model, Msg]()

  case class Menu[Model, Msg](
    label: String,
    children: List[Menu[Model, Msg] | MenuItem[Model, Msg] | MenuSeparator[Model, Msg]]
  )

  case class MenuBar[Model, Msg](children: List[Menu[Model, Msg]])

  object dsl {

    def item[Model, Msg](label: String, action: Msg)(using model: Model): MenuItem[Model, Msg] =
      MenuItem(label, action, model)

    def separator[Model, Msg]: MenuSeparator[Model, Msg] =
      MenuSeparator()

    def menu[Model, Msg](label: String)(children: (Menu[Model, Msg] | MenuItem[Model, Msg] |
      MenuSeparator[Model, Msg])*): Menu[Model, Msg] =
      Menu(label, children.toList)

    def menuBar[Model, Msg](children: Menu[Model, Msg]*): MenuBar[Model, Msg] =
      MenuBar(children.toList)

  }

}
