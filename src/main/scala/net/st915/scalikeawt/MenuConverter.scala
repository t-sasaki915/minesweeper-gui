package net.st915.scalikeawt

import java.awt.event.ActionListener
import scala.util.chaining.*

private[scalikeawt] class MenuConverter[Model, Msg] {

  private def convertMenuItem(menuItem: MenuItem[Model, Msg]): java.awt.MenuItem =
    new java.awt.MenuItem()
      .tap(_.setLabel(menuItem.label))
      .tap(_.addActionListener { _ =>
        import cats.effect.unsafe.implicits.global
        menuItem.action(menuItem.model).flatMap { msg =>
          Kernel.performMsg(msg, menuItem.model)
        }.unsafeRunSync()
      })

  private def convertMenu(menu: Menu[Model, Msg]): java.awt.Menu =
    new java.awt.Menu()
      .tap(_.setLabel(menu.label))
      .tap(_.setName("F"))
      .tap { nativeMenu =>
        menu.children.foreach {
          case i: MenuItem[Model, Msg] =>
            nativeMenu.add(convertMenuItem(i))

          case m: Menu[Model, Msg] =>
            nativeMenu.add(convertMenu(m))
        }
      }

  def convertMenuBar(menuBar: MenuBar[Model, Msg]): java.awt.MenuBar =
    new java.awt.MenuBar()
      .tap { nativeMenuBar => menuBar.menus.foreach { m => nativeMenuBar.add(convertMenu(m)) } }

}
