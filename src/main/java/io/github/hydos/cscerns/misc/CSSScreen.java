package io.github.hydos.cscerns.misc;

import com.steadystate.css.parser.CSSOMParser;
import io.github.hydos.cscerns.css.RealCssParser;
import io.github.hydos.cscerns.xml.XmlScreenParser;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.css.sac.CSSException;
import org.w3c.css.sac.InputSource;
import org.w3c.dom.css.CSSStyleSheet;

import java.io.IOException;
import java.io.InputStreamReader;

public class CSSScreen extends Screen {
	public static final Logger LOGGER = LogManager.getLogger("Css Screen");
	public CSSStyleSheet stylesheet;
	public RealCssParser cssParser;
	public XmlScreenParser xmlParser;

	public CSSScreen(Identifier location) {
		try {
			InputSource cssInput = toSource("/assets/" + location.getNamespace() + "/" + location.getPath() + ".css");
			CSSOMParser cssParser = new CSSOMParser();
			this.xmlParser = new XmlScreenParser("/assets/" + location.getNamespace() + "/" + location.getPath() + ".xml");
			this.stylesheet = cssParser.parseStyleSheet(cssInput, null, null);
		} catch (IOException | CSSException e) {
			LOGGER.fatal("An Exception has occurred while trying to read the style sheet!");
			e.printStackTrace();
		}

	}

	private InputSource toSource(String path) {
		return new InputSource(new InputStreamReader(CSSScreen.class.getResourceAsStream(path)));
	}

	@Override
	public void init(MinecraftClient client, int width, int height) {
		super.init(client, width, height);
		xmlParser.parse(width);
		this.buttons = xmlParser.getButtons();
		cssParser = new RealCssParser(this.width, this.height, stylesheet);
		CSSSEvents.WINDOW_RESIZED.register(client2 -> cssParser.onScreenResize(client.width, client.height));
		cssParser.calculatePositions();
	}

	@Override
	public void render(int mouseX, int mouseY, float delta) {
		renderBackground();
		super.render(mouseX, mouseY, delta);
		//TODO: mixin into all widgets and give them widget interface so i can put them in a list and render them
	}
}
