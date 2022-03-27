package com.staticallytyped.kagawaassist.coordinate.f3

import com.mojang.blaze3d.matrix.MatrixStack

class Time(column: Int, f3: F3)(implicit matrixStack: MatrixStack) extends AbstractPart(column)(f3){
  override def render(): Unit = {
    //hh.mm.ss
    val time = java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"))
    drawText("time: ", f3.textColor)
    drawText(time, f3.valueColor)
  }
}
