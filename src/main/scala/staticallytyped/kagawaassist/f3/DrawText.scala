package staticallytyped.kagawaassist.f3

import com.mojang.blaze3d.vertex.PoseStack
import net.minecraft.client.gui.Font
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue

class DrawText(fontRenderer: Font) {
  private var beforeText: String = ""
  private var column = -1

  def draw(text: String, color: ConfigValue[Int])(implicit poseStack: PoseStack): Unit = {
    val dx = fontRenderer.width(beforeText)
    val dy = fontRenderer.lineHeight + 1
    fontRenderer.drawShadow(poseStack, text, 2 + dx, 2 + dy * column, color.get())
    beforeText += text
  }

  def newLine(): Unit = {
    column += 1
    beforeText = ""
  }
}
