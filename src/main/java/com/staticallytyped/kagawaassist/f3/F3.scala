package com.staticallytyped.kagawaassist.f3

import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.FontRenderer
import net.minecraftforge.api.distmarker.{Dist, OnlyIn}
import net.minecraftforge.client.event.RenderGameOverlayEvent
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.eventbus.api.SubscribeEvent

@OnlyIn(Dist.CLIENT)
class F3() {
  MinecraftForge.EVENT_BUS.register(this)

  val fontRenderer: FontRenderer = Minecraft.getInstance.fontRenderer
  val textColor = 0xf3a305
  val valueColor = 0xFFFFFF

  @SubscribeEvent
  def render(event: RenderGameOverlayEvent): Unit = {
    event.getType match {
      case RenderGameOverlayEvent.ElementType.TEXT =>
        implicit val matrixStack: MatrixStack = event.getMatrixStack
        new Coordinate(0, this).render()
        new Facing(1, this).render()
        new Time(2, this).render()
      case _ => ()
    }
  }
}

