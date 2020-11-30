package io.github.hydos.screenss.widget;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.widget.ButtonWidget;

public class CssButtonWidget extends ButtonWidget implements CssWidget {

	private final String styleClass;

	public CssButtonWidget(int id, String message, String styleClass) {
		super(id, 0, 0, message);
		this.styleClass = styleClass;
	}

	@Override
	public void render(MinecraftClient client, int mouseX, int mouseY) {
		super.render(client, mouseX, mouseY);
	}

	@Override
	public String getStyleClass() {
		return styleClass;
	}
}
