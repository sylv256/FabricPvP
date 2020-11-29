package io.github.tehcjs.fabricpvp.modules.optimizations.chunk;

import io.github.tehcjs.fabricpvp.modules.Module;
import net.minecraft.text.TranslatableText;

import static io.github.tehcjs.fabricpvp.utilities.Util.trans;

public class ChunkOptimizationsModule extends Module {
	@Override
	public TranslatableText getName() {
		return trans("chunk_optimizations");
	}
}
