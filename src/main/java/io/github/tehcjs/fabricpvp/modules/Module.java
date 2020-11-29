package io.github.tehcjs.fabricpvp.modules;

import net.minecraft.text.TranslatableText;

public abstract class Module {
	private static Module INSTANCE;

	// initialize every module
	static {
		for (var c : Module.class.getClasses()) {
			try {
				INSTANCE = (Module) c.newInstance();
			} catch (IllegalAccessException | InstantiationException e) {
				e.printStackTrace();
			}
		}
	}

	public abstract TranslatableText getName();
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
