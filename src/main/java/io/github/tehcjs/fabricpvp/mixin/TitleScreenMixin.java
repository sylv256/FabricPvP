package io.github.tehcjs.fabricpvp.mixin;

import io.github.tehcjs.fabricpvp.screen.CosmeticEditorScreen;
import io.github.tehcjs.fabricpvp.screen.AccountScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.IdentifibleBooleanConsumer;
import net.minecraft.client.resource.language.I18n;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen implements IdentifibleBooleanConsumer {

	@Inject(method = "init", at = @At("TAIL"))
	private void replaceRealms(CallbackInfo ci) {
		this.buttons.removeIf(button -> button.id == 14);
		this.buttons.add(new ButtonWidget(14, this.width / 2 - 100, (this.height / 4 + 48) + 24 * 2, 98, 20, I18n.translate("fabricpvp.menu.alts")));
		this.buttons.add(new ButtonWidget(100, this.width / 2 + 2, (this.height / 4 + 48) + 24 * 2, 98, 20, I18n.translate("fabricpvp.menu.cosmetic_editor")));
	}

	@Inject(method = "buttonClicked", at = @At("HEAD"), cancellable = true)
	private void clickOurButtons(ButtonWidget button, CallbackInfo ci) {
		if (button.id == 14) {
			this.client.openScreen(new AccountScreen());
			ci.cancel();
		}
		if (button.id == 100) {
			this.client.openScreen(new CosmeticEditorScreen());
		}
	}
}
