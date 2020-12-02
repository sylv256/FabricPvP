package io.github.hydos.screenss;

import com.steadystate.css.parser.CSSOMParser;
import io.github.hydos.realcssparser.RealCssParser;
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

public abstract class CSSScreen extends Screen {
	public static final Logger LOGGER = LogManager.getLogger("Css Screens");
	public CSSStyleSheet stylesheet;
	public RealCssParser parser;

	public CSSScreen(Identifier styleSheet) {
		try {
			InputSource source = new InputSource(new InputStreamReader(CSSScreen.class.getResourceAsStream("/assets/" + styleSheet.getNamespace() + "/" + styleSheet.getPath())));
			CSSOMParser parser = new CSSOMParser();
			this.stylesheet = parser.parseStyleSheet(source, null, null);
		} catch (IOException | CSSException e) {
			LOGGER.fatal("An IO or CSS Exception has occurred while trying to read the style sheet!");
			// ignore this hydos lol
			LOGGER.fatal(new String(new byte[]{0x79, 0x65, 0x61, 0x20, 0x69, 0x64, 0x6b, 0x20, 0x69, 0x66, 0x20, 0x69, 0x74, 0x20, 0x77, 0x61, 0x73, 0x20, 0x61, 0x6e, 0x20, 0x69, 0x6f, 0x20, 0x6f, 0x72, 0x20, 0x63, 0x73, 0x73, 0x20, 0x65, 0x78, 0x63, 0x65, 0x70, 0x74, 0x69, 0x6f, 0x6e, 0x20, 0x6c, 0x6f, 0x6c, 0x20, 0x73, 0x72, 0x79}));
			e.printStackTrace();
		}

	}

	public void calculateLocations(){
		parser.calculatePositions();
	}

	@Override
	public void init(MinecraftClient client, int width, int height) {
		super.init(client, width, height);
		parser = new RealCssParser(this.width, this.height, stylesheet);
		CSSSEvents.WINDOW_RESIZED.register(client2 -> parser.onScreenResize(client.width, client.height));
	}

	@Override
	public void render(int mouseX, int mouseY, float delta) {
		super.render(mouseX, mouseY, delta);
	}
}
