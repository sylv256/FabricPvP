package io.github.tehcjs.fabricpvp.screen;

import io.github.hydos.realcssparser.RealCssParser;
import io.github.hydos.screenss.CSSScreen;
import io.github.hydos.screenss.CssSelector;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ButtonWidget;

import static io.github.tehcjs.fabricpvp.utilities.Util.id;

public class CSSTestScreen extends CSSScreen {

	public CSSTestScreen() {
		super(id("screen/style/cosmeticEditor.fabricpvp.css"));
	}

	@Override
	public void init(MinecraftClient client, int width, int height) {
		super.init(client, width, height);
		parser.addElement(CssSelector.of(".", "test_selector"), 200, 20, "test_button");
		calculateLocations();
		RealCssParser.ElementData testButtonData = parser.getData("test_button");
		this.buttons.add(new ButtonWidget(0, testButtonData.getxPos(), testButtonData.getyPos(), "test_button go brr"));
	}

	@Override
	public void render(int mouseX, int mouseY, float delta) {
		renderBackground();
		super.render(mouseX, mouseY, delta);
	}
}
