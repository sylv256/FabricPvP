package io.github.tehcjs.fabricpvp.modules.optimizations.chunk;

import io.github.tehcjs.fabricpvp.modules.Module;
import net.minecraft.util.Identifier;

import static io.github.tehcjs.fabricpvp.utilities.Util.id;

public class ChunkOptimizationsModule extends Module {
	@Override
	public Identifier getId() {
		return id("chunk_optimizations");
	}

	@Override
	public void register() {
	}
}
