package io.github.tehcjs.fabricpvp.modules;

import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

import static io.github.tehcjs.fabricpvp.utilities.Util.trans;

public interface Module {
	default TranslatableText getName() {
		return trans(this.getId().getPath());
	}

	Identifier getId();

	void register();
}
