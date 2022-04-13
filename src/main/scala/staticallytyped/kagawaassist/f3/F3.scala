package staticallytyped.kagawaassist.f3

import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.FontRenderer
import net.minecraftforge.client.event.RenderGameOverlayEvent
import net.minecraftforge.common.ForgeConfigSpec
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import staticallytyped.kagawaassist.Config

@Mod.EventBusSubscriber
class F3() {

  val fontRenderer: FontRenderer = Minecraft.getInstance.fontRenderer
  val textColor: ForgeConfigSpec.ConfigValue[Int] = Config.textColor
  val valueColor: ForgeConfigSpec.ConfigValue[Int] = Config.valueColor
  var drawText = new DrawText(fontRenderer)

  @SubscribeEvent
  def render(event: RenderGameOverlayEvent): Unit = {
    if (event.getType == RenderGameOverlayEvent.ElementType.TEXT) {
      implicit val matrixStack: MatrixStack = event.getMatrixStack
      drawText = new DrawText(fontRenderer)
      new Coordinate(this).render()
      new Facing(this).render()
      new Time(this).render()
    }
  }
}

