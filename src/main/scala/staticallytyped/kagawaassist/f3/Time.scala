package staticallytyped.kagawaassist.f3

import com.mojang.blaze3d.vertex.PoseStack
import staticallytyped.kagawaassist.Config

import java.time.LocalTime
import java.time.format.DateTimeFormatter

class Time(f3: F3)(implicit poseStack: PoseStack) extends AbstractPart(f3) {
  override def render(): Unit = {
    if (!Config.displayTime.get()) cancel = true
    if (cancel) return

    val timePattern = Config.timePattern.get()
    val time = LocalTime.now().format(DateTimeFormatter.ofPattern(timePattern))
    f3.drawText.newLine()
    draw("time: ", f3.textColor)
    draw(time, f3.valueColor)
  }
}
