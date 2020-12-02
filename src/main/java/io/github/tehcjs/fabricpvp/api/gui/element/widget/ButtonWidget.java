package io.github.tehcjs.fabricpvp.api.gui.element.widget;

public abstract class ButtonWidget extends net.minecraft.client.gui.widget.ButtonWidget implements Widget {
	public ButtonWidget(int id, String message) {
		super(id, 0, 0, message);
	}

	@Override
	public String getStyleTag() {
		return "button";
	}
}
