package staticallytyped.kagawaassist.f3

import com.mojang.blaze3d.matrix.MatrixStack
import staticallytyped.kagawaassist.Config

import java.time.LocalTime
import java.time.format.DateTimeFormatter

class Time(column: Int, f3: F3)(implicit matrixStack: MatrixStack) extends AbstractPart(column)(f3){
  override def render(): Unit = {
    if(Config.displayTime.get()) {
      val timePattern = Config.timePattern.get()
      val time = LocalTime.now().format(DateTimeFormatter.ofPattern(timePattern))
      drawText("time: ", f3.textColor)
      drawText(time, f3.valueColor)
    }
  }
}
