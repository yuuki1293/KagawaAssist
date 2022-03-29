package staticallytyped.kagawaassist.f3

import com.mojang.blaze3d.matrix.MatrixStack

import java.time.LocalTime
import java.time.format.DateTimeFormatter

class Time(column: Int, f3: F3)(implicit matrixStack: MatrixStack) extends AbstractPart(column)(f3){
  override def render(): Unit = {
    //hh.mm.ss
    val time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))
    drawText("time: ", f3.textColor)
    drawText(time, f3.valueColor)
  }
}
