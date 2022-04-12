package staticallytyped.kagawaassist.f3

import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.FontRenderer
import net.minecraftforge.client.event.RenderGameOverlayEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import staticallytyped.kagawaassist.Config

@Mod.EventBusSubscriber
class F3() {

  val fontRenderer: FontRenderer = Minecraft.getInstance.fontRenderer
  val textColor: Int = Config.textColor.get()
  val valueColor: Int = Config.valueColor.get()

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

