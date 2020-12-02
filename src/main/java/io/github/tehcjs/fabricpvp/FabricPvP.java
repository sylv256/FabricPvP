package io.github.tehcjs.fabricpvp;

import io.github.tehcjs.fabricpvp.modules.Module;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FabricPvP implements ModInitializer {
	public static final String MOD_ID = "fabricpvp";
	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public void onInitialize() {
		// init modules
		// todo tell oracle to un-deprecate their cursed reflection api
		Reflections reflections = new Reflections("io.github.tehcjs." + MOD_ID);
		for (Class<?> c : reflections.getSubTypesOf(Module.class)) {
			try {
				Field instanceField = c.getDeclaredField("INSTANCE");
				instanceField.setAccessible(true);
				Module instance = (Module) instanceField.get(null);

				Method registerMethod = c.getMethod("register");
				registerMethod.setAccessible(true);
				registerMethod.invoke(instance);
			} catch (NoSuchFieldException | IllegalAccessException
					| NoSuchMethodException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}

	public static void log(Level level, String message) {
		LOGGER.log(level, message);
	}

	public static void info(String message) {
		log(Level.INFO, message);
	}

	public static void warn(String message) {
		log(Level.WARN, message);
	}

	public static void debug(String message) {
		log(Level.DEBUG, message);
	}

	public static void error(String message) {
		log(Level.ERROR, message);
	}

	public static void fatal(String message) {
		log(Level.FATAL, message);
	}
}
