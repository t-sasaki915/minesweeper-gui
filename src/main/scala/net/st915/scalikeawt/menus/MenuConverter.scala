package net.st915.scalikeawt.menus

import scala.util.chaining.*

private[scalikeawt] case class MenuConverter[Msg]() {

  private def convertMenuItem(menuItem: MenuItem[Msg]): java.awt.MenuItem =
    new java.awt.MenuItem()
      // TODO: action
      .tap(_.setLabel(menuItem.label))

  private def convertMenu(menu: Menu[Msg]): java.awt.Menu =
    new java.awt.Menu()
      .tap(_.setLabel(menu.label))
      .tap { nativeMenu =>
        menu.children.foreach {
          case x: MenuItem[Msg] =>
            nativeMenu.add(convertMenuItem(x))

          case x: Menu[Msg] =>
            nativeMenu.add(convertMenu(x))

          case _: MenuSeparator[Msg] =>
            nativeMenu.addSeparator()
        }
      }

  def convertMenuBar(menuBar: MenuBar[Msg]): java.awt.MenuBar =
    new java.awt.MenuBar()
      .tap { nativeMenuBar => menuBar.children.foreach { m => nativeMenuBar.add(convertMenu(m)) } }

}
