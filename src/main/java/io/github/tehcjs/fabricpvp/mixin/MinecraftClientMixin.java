package io.github.tehcjs.fabricpvp.mixin;

import io.github.hydos.screenss.CSSSEvents;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

	@Inject(method = "method_2289", at = @At("TAIL"))
	private void onResizeHook(CallbackInfo ci){
		CSSSEvents.WINDOW_RESIZED.invoker().onClientStarted(MinecraftClient.getInstance());
	}

}
