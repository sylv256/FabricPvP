package io.github.hydos.screenss;

import cz.vutbr.web.css.*;
import io.github.hydos.screenss.widget.CssWidget;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.Identifier;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CSSScreen extends Screen {
	public static final Logger LOGGER = LogManager.getLogger("Css Screens");

	private final Map<String, RuleSet> cachedCssRules = new HashMap<>();
	public final List<CssWidget> cssWidgets = new ArrayList<>();

	public CSSScreen(Identifier styleSheet) {
		try {
			String css = readFile(CSSScreen.class.getResourceAsStream("/assets/" + styleSheet.getNamespace() + "/" + styleSheet.getPath()));
			StyleSheet style = CSSFactory.parseString(css, null);
			for (RuleBlock<?> ruleBlock : style) {
				RuleSet rule = (RuleSet) ruleBlock;
				cachedCssRules.put(rule.getSelectors()[0].toString().substring(1), rule);
			}
		} catch (IOException | CSSException e) {
			LOGGER.fatal("An IO or CSS Exception has occurred while trying to read the style sheet!");
			// ignore this hydos lol
			LOGGER.fatal(new String(new byte[]{0x79, 0x65, 0x61, 0x20, 0x69, 0x64, 0x6b, 0x20, 0x69, 0x66, 0x20, 0x69, 0x74, 0x20, 0x77, 0x61, 0x73, 0x20, 0x61, 0x6e, 0x20, 0x69, 0x6f, 0x20, 0x6f, 0x72, 0x20, 0x63, 0x73, 0x73, 0x20, 0x65, 0x78, 0x63, 0x65, 0x70, 0x74, 0x69, 0x6f, 0x6e, 0x20, 0x6c, 0x6f, 0x6c, 0x20, 0x73, 0x72, 0x79}));
			e.printStackTrace();
		}
	}

	@Override
	public void render(int mouseX, int mouseY, float delta) {
		super.render(mouseX, mouseY, delta);
	}

	public Map<String, RuleSet> getCache() {
		return cachedCssRules;
	}

	private String readFile(InputStream inputStream) throws IOException {
		byte[] encoded = IOUtils.toByteArray(inputStream);
		return new String(encoded, StandardCharsets.UTF_8);
	}
}
