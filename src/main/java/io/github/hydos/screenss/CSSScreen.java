package io.github.hydos.screenss;

import cz.vutbr.web.css.*;
import io.github.hydos.screenss.widget.CssButtonWidget;
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
	public final List<CssButtonWidget> cssWidgets = new ArrayList<>();

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
			e.printStackTrace();
		}
	}

	@Override
	public void render(int mouseX, int mouseY, float delta) {
		super.render(mouseX, mouseY, delta);
	}

	public Map<String, RuleSet> getCache(){
		return cachedCssRules;
	}

	private String readFile(InputStream inputStream) throws IOException {
		byte[] encoded = IOUtils.toByteArray(inputStream);
		return new String(encoded, StandardCharsets.UTF_8);
	}
}
