package net.st915.scalikeawt

package object menus {

  case class MenuItem[Model, Msg](label: String, action: Msg, model: Model, enabled: Boolean)

  case class MenuSeparator[Model, Msg]()

  case class Menu[Model, Msg](
    label: String,
    children: List[Menu[Model, Msg] | MenuItem[Model, Msg] | MenuSeparator[Model, Msg]],
    enabled: Boolean
  )

  case class MenuBar[Model, Msg](children: List[Menu[Model, Msg]])

  object dsl {

    def item[Model, Msg](label: String, action: Msg, enabled: Boolean = true)(using
    model: Model): MenuItem[Model, Msg] =
      MenuItem(label, action, model, enabled)

    def separator[Model, Msg]: MenuSeparator[Model, Msg] =
      MenuSeparator()

    def menu[Model, Msg](label: String,
                         enabled: Boolean = true
    )(children: (Menu[Model, Msg] | MenuItem[Model, Msg] |
      MenuSeparator[Model, Msg])*): Menu[Model, Msg] =
      Menu(label, children.toList, enabled)

    def menuBar[Model, Msg](children: Menu[Model, Msg]*): MenuBar[Model, Msg] =
      MenuBar(children.toList)

  }

}
