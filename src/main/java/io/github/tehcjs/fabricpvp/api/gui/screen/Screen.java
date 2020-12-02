package io.github.tehcjs.fabricpvp.api.gui.screen;

import io.github.tehcjs.fabricpvp.api.gui.element.Element;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Screen extends net.minecraft.client.gui.screen.Screen {
	// todo hydos do css
	//private StyleSheet styleSheet;
	private final List<Element> elements = new ArrayList<>();

	public Screen(Identifier styleSheetPath) {
		/*try {
			String content = IOUtils.toString(Screen.class
					.getResourceAsStream("/assets/"
							+ styleSheetPath.getNamespace() + "/" + styleSheetPath.getPath()));
			styleSheet = CSSFactory.parseString(content, null);
		} catch (IOException | CSSException e) {
			e.printStackTrace();
		}*/
	}

	@Override
	public void init(MinecraftClient client, int width, int height) {
		super.init(client, width, height);
		// todo hydos do css
		/*for (RuleBlock<?> ruleBlock : styleSheet) {
			RuleSet rule = (RuleSet) ruleBlock;
			for (CombinedSelector combinedSelector : rule.getSelectors()) {
				for (Selector sel : combinedSelector) {
					for (Element el : elements) {
						if (el.getStyleClass().equals(sel.getClassName())
								|| el.getStyleTag().equals(sel.getElementName())) {
							for (Declaration decl : rule) {
								NodeData nd = CSSFactory.createNodeData();
								nd.push(decl);
								el.declare(decl.getProperty(), decl.get(0), nd);
							}
							break;
						}
					}
				}
			}
		}*/
	}

	@Override
	public void render(int mouseX, int mouseY, float delta) {
		for (Element el : elements) {
			el.render(mouseX, mouseY);
		}
		super.render(mouseX, mouseY, delta);
	}

	protected void addElement(Element element) {
		elements.add(element);
	}
}
