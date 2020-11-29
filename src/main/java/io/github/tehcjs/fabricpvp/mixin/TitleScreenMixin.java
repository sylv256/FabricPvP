package io.github.tehcjs.fabricpvp.mixin;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.IdentifibleBooleanConsumer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen implements IdentifibleBooleanConsumer {

    @ModifyConstant(method = "method_2845", constant = @Constant(stringValue = "menu.online"))
    private static String replaceWithAccounts(String realmsTranslationKey) {
        return "Accounts";
    }
}
