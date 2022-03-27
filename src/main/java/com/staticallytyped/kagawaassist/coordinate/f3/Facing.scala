package com.staticallytyped.kagawaassist.coordinate.f3

import net.minecraft.client.Minecraft
import net.minecraftforge.client.event.RenderGameOverlayEvent


//NOTE: north = -180, south = 0, east = -90, west = 90
class Facing(column: Int)(implicit event: RenderGameOverlayEvent) extends AbstractPart(column)(event) {
  override def render(): Unit = {
    implicit val col: Int = column
    val player = Minecraft.getInstance.player
    val facing = player.getHorizontalFacing.getHorizontalAngle
    val text = s"facing: "
    val valueUS = facing.toString
    draw(text, "", textColor)
    draw(valueUS, text, valueColor)
  }
}
