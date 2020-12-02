package io.github.tehcjs.fabricpvp.api.gui.element.component;

import io.github.tehcjs.fabricpvp.api.gui.element.Element;
import io.github.tehcjs.fabricpvp.api.gui.screen.Screen;

public abstract class Component implements Element {
	protected int x = 0;
	protected int y = 0;
	protected Screen screen;
	// todo hydos do css
	//protected CSSProperty.Position position = CSSProperty.Position.STATIC;

	public Component(Screen screen) {
		this.screen = screen;
	}

	@Override
	public String getStyleTag() {
		return "component";
	}

	// todo hydos do css
	/*@Override
	public void declare(String property, Term<?> value, NodeData nd) {
		info(property);
		switch (property) {
			case "position":
				position = nd.getProperty(property);
				break;
			case "top":
				TermLengthOrPercent t = (TermLengthOrPercent) value;
				//y = (int) (screen.height / (Math.pow(t.getValue(), 2) - t.getValue()));
				break;
			default:
				warn("Unknown CSS property: " + property);
		}
	}*/

	public Screen getScreen() {
		return screen;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
