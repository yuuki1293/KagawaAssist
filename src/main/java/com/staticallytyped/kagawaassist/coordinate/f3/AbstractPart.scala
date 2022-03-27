package com.staticallytyped.kagawaassist.coordinate.f3

abstract class AbstractPart(column: Int, val f3: F3) {
  val drawText: (String, Int) => Unit = new DrawText(f3.fontRenderer).draw(column)

  def render(): Unit
}
