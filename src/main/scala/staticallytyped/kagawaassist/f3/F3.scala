package staticallytyped.kagawaassist.f3

import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.FontRenderer
import net.minecraftforge.client.event.RenderGameOverlayEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber
class F3() {

  val fontRenderer: FontRenderer = Minecraft.getInstance.fontRenderer
  val textColor = 0xf3a305
  val valueColor = 0xFFFFFF

  @SubscribeEvent
  def render(event: RenderGameOverlayEvent): Unit = {
    if (event.getType == RenderGameOverlayEvent.ElementType.TEXT) {
      implicit val matrixStack: MatrixStack = event.getMatrixStack
      new Coordinate(0, this).render()
      new Facing(1, this).render()
      new Time(2, this).render()
    }
  }
}

