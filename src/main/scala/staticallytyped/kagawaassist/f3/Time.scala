package staticallytyped.kagawaassist.f3

import com.mojang.blaze3d.vertex.PoseStack
import net.minecraft.client.gui.Font
import staticallytyped.kagawaassist.Config
import staticallytyped.kagawaassist.monad.Reader._

import java.time.LocalTime
import java.time.format.DateTimeFormatter

object Time extends Part {
  override def render(xy: (Int, Int))(x0: Int, poseStack: PoseStack, font: Font): (Int, Int) = {
    if (!Config.displayTime.get()) cancel = true
    if (cancel) return xy

    val timePattern = Config.timePattern.get()
    val time = LocalTime.now().format(DateTimeFormatter.ofPattern(timePattern))
    (DrawText.apply _)(xy)
      .map(DrawText.draw("time: ", F3.textColor))
      .map(DrawText.draw(time, F3.valueColor))
      .apply(x0, poseStack, font)
  }
}
