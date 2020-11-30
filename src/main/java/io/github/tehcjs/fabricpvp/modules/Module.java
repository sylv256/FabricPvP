package io.github.tehcjs.fabricpvp.modules;

import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

import static io.github.tehcjs.fabricpvp.utilities.Util.trans;

public abstract class Module {
	private static final List<Module> MODULES = new ArrayList<>();

	public TranslatableText getName() {
		return trans(this.getId().getPath());
	}

	public abstract Identifier getId();
	public abstract void register();
}
