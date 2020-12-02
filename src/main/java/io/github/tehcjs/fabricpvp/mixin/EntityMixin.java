package io.github.tehcjs.fabricpvp.mixin;

import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {

	@Inject(method = "squaredDistanceTo(Lnet/minecraft/entity/Entity;)D", at = @At("HEAD"), cancellable = true)
	private void returnZeroIfNull(Entity entity, CallbackInfoReturnable<Double> cir) {
		if (entity == null) {
			cir.setReturnValue(0D);
		}
	}

}
