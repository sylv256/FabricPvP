package io.github.tehcjs.fabricpvp.utilities;

import io.github.tehcjs.fabricpvp.FabricPvP;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

public abstract class Util {
	public static TranslatableText trans(String key) {
		return new TranslatableText(FabricPvP.MOD_ID + "." + key);
	}
	public static Identifier id(String id) {
		return new Identifier(FabricPvP.MOD_ID, id);
	}
}
