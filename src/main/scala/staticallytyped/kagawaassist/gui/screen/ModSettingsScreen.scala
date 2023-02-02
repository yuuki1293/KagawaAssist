package staticallytyped.kagawaassist.gui.screen

import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraft.client.GameSettings
import net.minecraft.client.gui.screen.{Screen, SettingsScreen}
import net.minecraft.client.gui.widget.list.OptionsRowList
import net.minecraft.util.text.{ITextComponent, TranslationTextComponent}
import net.minecraftforge.api.distmarker.{Dist, OnlyIn}

@OnlyIn(Dist.CLIENT)
class ModSettingsScreen(previousScreen: Screen, gameSettingsObj: GameSettings)
  extends SettingsScreen(previousScreen, gameSettingsObj,
    new TranslationTextComponent("options.kagawaassist.title")) {
  private var optionsRowList: Option[OptionsRowList] = None

  override protected def init(): Unit = {
    optionsRowList = Option(new OptionsRowList(this.minecraft, this.width, this.height, 32, this.height - 32, 25))
  }

  override def render(matrixStack: MatrixStack, mouseX: Int, mouseY: Int, partialTicks: Float): Unit = {
    this.renderBackground(matrixStack)
    super.render(matrixStack, mouseX, mouseY, partialTicks)
  }
}

object ModSettingsScreen {
}