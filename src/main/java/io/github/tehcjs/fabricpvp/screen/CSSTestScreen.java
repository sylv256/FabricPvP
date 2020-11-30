package io.github.tehcjs.fabricpvp.screen;

import io.github.hydos.screenss.CSSScreen;
import io.github.hydos.screenss.widget.CssButtonWidget;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;

import static io.github.tehcjs.fabricpvp.utilities.Util.id;

public class CSSTestScreen extends CSSScreen {

	public CSSTestScreen() {
		super(id("screen/style/cosmeticEditor.css"));
	}

	@Override
	public void init(MinecraftClient client, int width, int height) {
		super.init(client, width, height);
		this.cssWidgets.add(new CssButtonWidget(1, "centeredButton?", "cosmeticSelection"));
	}
}
