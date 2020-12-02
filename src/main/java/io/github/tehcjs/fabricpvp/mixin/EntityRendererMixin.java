package io.github.tehcjs.fabricpvp.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.entity.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityRenderer.class)
public class EntityRendererMixin {

	@Inject(method = "getFontRenderer", at = @At("HEAD"), cancellable = true)
	private void returnRealFontRenderer(CallbackInfoReturnable<TextRenderer> cir) {
		cir.setReturnValue(MinecraftClient.getInstance().textRenderer);
	}

}
