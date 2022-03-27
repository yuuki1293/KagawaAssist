package com.staticallytyped.kagawaassist.coordinate.f3

abstract class AbstractPart(val f3: F3) {
  val drawText = new DrawText(f3.fontRenderer)

  def render(): Unit
}
