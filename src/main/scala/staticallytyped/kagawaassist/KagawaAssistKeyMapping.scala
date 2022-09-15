package staticallytyped.kagawaassist

import net.minecraft.client.KeyMapping

class KagawaAssistKeyMapping(name: String, key: Int, val f: Unit => _)(implicit category: String)
  extends KeyMapping(name, key, category){
}
