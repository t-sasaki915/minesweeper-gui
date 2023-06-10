package net.st915.scalikeawt.menus

import net.st915.scalikeawt.Kernel

import scala.util.chaining.*

private[scalikeawt] case class MenuConverter[Model, Msg]() {

  private def convertMenuItem(menuItem: MenuItem[Model, Msg]): java.awt.MenuItem =
    new java.awt.MenuItem()
      .tap(_.setLabel(menuItem.label))
      .tap(_.setEnabled(menuItem.enabled))
      .tap(_.addActionListener(_ => {
        import cats.effect.unsafe.implicits.global

        Kernel.performMsg(menuItem.action, menuItem.model).unsafeRunSync()
      }))

  private def convertMenu(menu: Menu[Model, Msg]): java.awt.Menu =
    new java.awt.Menu()
      .tap(_.setLabel(menu.label))
      .tap(_.setEnabled(menu.enabled))
      .tap { nativeMenu =>
        menu.children.foreach {
          case x: MenuItem[Model, Msg] =>
            nativeMenu.add(convertMenuItem(x))

          case x: Menu[Model, Msg] =>
            nativeMenu.add(convertMenu(x))

          case _: MenuSeparator[Model, Msg] =>
            nativeMenu.addSeparator()
        }
      }

  def convertMenuBar(menuBar: MenuBar[Model, Msg]): java.awt.MenuBar =
    new java.awt.MenuBar()
      .tap { nativeMenuBar => menuBar.children.foreach { m => nativeMenuBar.add(convertMenu(m)) } }

}
