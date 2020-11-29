package io.github.tehcjs.fabricpvp.mixin;

import io.github.tehcjs.fabricpvp.screen.AccountScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.IdentifibleBooleanConsumer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen implements IdentifibleBooleanConsumer {

    @ModifyConstant(method = "method_2845", constant = @Constant(stringValue = "menu.online"))
    private static String replaceWithAccounts(String realmsTranslationKey) {
        return "Accounts";
    }

    @Inject(method = "buttonClicked", at = @At("HEAD"), cancellable = true)
    private void clickOurButtons(ButtonWidget button, CallbackInfo ci){
        if(button.id == 14){
            this.client.openScreen(new AccountScreen());
            ci.cancel();
        }
    }
}
