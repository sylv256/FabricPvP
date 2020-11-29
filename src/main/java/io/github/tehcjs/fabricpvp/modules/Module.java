package io.github.tehcjs.fabricpvp.modules;

import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

import static io.github.tehcjs.fabricpvp.utilities.Util.trans;

public abstract class Module {
	private static Module INSTANCE;
	private static final List<Module> MODULES = new ArrayList<>();

	// initialize every module
	static {
		for (var c : Module.class.getClasses()) {
			try {
				INSTANCE = (Module) c.newInstance();
				MODULES.add(INSTANCE);
			} catch (IllegalAccessException | InstantiationException e) {
				e.printStackTrace();
			}
		}
	}

	public TranslatableText getName() {
		return trans(this.getId().getPath());
	}

	public abstract Identifier getId();
	public abstract void register();

	public static Module getInstance() {
		if (INSTANCE != null) return INSTANCE;

		try {
			return INSTANCE = Module.class.newInstance();
		} catch (IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
		return null;
	}
}
