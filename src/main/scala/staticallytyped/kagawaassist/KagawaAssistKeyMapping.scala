package staticallytyped.kagawaassist

import com.mojang.blaze3d.platform.InputConstants
import net.minecraft.client.KeyMapping
import net.minecraftforge.client.settings.{IKeyConflictContext, KeyModifier}

class KagawaAssistKeyMapping(description: String, keyConflictContext: IKeyConflictContext, keyModifier: KeyModifier, keyCode: InputConstants.Key, val f: Unit => _)(implicit category: String)
  extends KeyMapping(description, keyConflictContext, keyModifier, keyCode, category){
}
