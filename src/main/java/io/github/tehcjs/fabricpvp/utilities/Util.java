package io.github.tehcjs.fabricpvp.utilities;

import io.github.tehcjs.fabricpvp.FabricPvP;
import net.minecraft.text.TranslatableText;

public abstract class Util {
	public static TranslatableText trans(String key) {
		return new TranslatableText(FabricPvP.MOD_ID + "." + key);
	}
}
