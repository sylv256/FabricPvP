package io.github.tehcjs.fabricpvp.api.gui.element;


public interface Element {
	String getStyleTag();
	String getStyleClass();
	// todo hydos do css
	//void declare(String property, Term<?> value, NodeData nd);
	default void render(int mouseX, int mouseY) {}
}
