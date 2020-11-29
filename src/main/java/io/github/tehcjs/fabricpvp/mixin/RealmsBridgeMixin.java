package io.github.tehcjs.fabricpvp.mixin;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.realms.RealmsScreenProxy;
import net.minecraft.realms.RealmsBridge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * used to silence a realms NoSuchMethodException
 */
@Mixin(RealmsBridge.class)
public class RealmsBridgeMixin {

    @Inject(method = "getNotificationScreen", at = @At("HEAD"), cancellable = true)
    private void no(Screen screen, CallbackInfoReturnable<RealmsScreenProxy> cir){
        cir.setReturnValue(null);
    }

}
