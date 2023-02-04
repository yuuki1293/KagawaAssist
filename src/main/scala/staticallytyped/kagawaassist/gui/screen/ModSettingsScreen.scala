package staticallytyped.kagawaassist.gui.screen

import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraft.client.gui.AbstractGui.drawCenteredString
import net.minecraft.client.gui.screen.{Screen, SettingsScreen}
import net.minecraft.client.gui.widget.TextFieldWidget
import net.minecraft.client.gui.widget.list.OptionsRowList
import net.minecraft.client.{AbstractOption, GameSettings}
import net.minecraft.util.text.TranslationTextComponent
import net.minecraftforge.api.distmarker.{Dist, OnlyIn}
import staticallytyped.kagawaassist.ModOption
import staticallytyped.kagawaassist.gui.screen.ModSettingsScreen.OPTIONS

@OnlyIn(Dist.CLIENT)
class ModSettingsScreen(val previousScreen: Screen)
  extends Screen(new TranslationTextComponent("options.kagawaassist.title")) {
  private var optionsRowList: Option[OptionsRowList] = None
  private var textFields: List[TextFieldWidget] = List()

  override protected def init(): Unit = {
    optionsRowList = Option(new OptionsRowList(this.minecraft, this.width, this.height, 32, this.height - 32, 25))
    for (options <- optionsRowList) {
      options.addOptions(OPTIONS)
      children.add(options)
    }
  }


  override def render(matrixStack: MatrixStack, mouseX: Int, mouseY: Int, partialTicks: Float): Unit = {
    this.renderBackground(matrixStack)
    drawCenteredString(matrixStack, this.font, this.title, this.width / 2, 5, 16777215)

    for (optionsRow <- optionsRowList) {
      optionsRow.render(matrixStack, mouseX, mouseY, partialTicks)
    }

    for (textField <- textFields) {
      textField.render(matrixStack, mouseX, mouseY, partialTicks)
    }

    super.render(matrixStack, mouseX, mouseY, partialTicks)
  }
}

object ModSettingsScreen {
  private val OPTIONS = Array[AbstractOption](
    ModOption.TEXT_COLOR,
    ModOption.VALUE_COLOR,
    ModOption.DISPLAY_COORDINATES,
    ModOption.DISPLAY_FACING,
    ModOption.DISPLAY_DIRECTION,
    ModOption.DISPLAY_TIME)
}