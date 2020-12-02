package io.github.tehcjs.fabricpvp.api.gui.element.component;

import com.mojang.blaze3d.platform.GlStateManager;
import io.github.tehcjs.fabricpvp.api.gui.screen.Screen;
import io.github.tehcjs.fabricpvp.screen.CosmeticEditorScreen;
import net.minecraft.client.gui.screen.ingame.SurvivalInventoryScreen;
import net.minecraft.client.render.entity.model.PlayerEntityModel;

public class RenderedPlayerComponent extends Component {
	private final PlayerEntityModel playerModel;
	private final int size;

	private float mouseX;
	private float mouseY;

	public RenderedPlayerComponent(Screen screen, int size, PlayerEntityModel playerModel) {
		super(screen);
		this.size = size;
		this.playerModel = playerModel;
	}

	@Override
	public void render(int mouseX, int mouseY) {
		this.mouseX = (float) mouseX;
		this.mouseY = (float) mouseY;
		GlStateManager.enableDepthTest();
		SurvivalInventoryScreen.renderEntity(this.x, this.y, size, (float)(this.x) - this.mouseX, (float)(this.y - 1.5 * size) - this.mouseY, getScreen().fakePlayer);
		GlStateManager.disableDepthTest();
	}

	@Override
	public String getStyleClass() {
		return "renderedPlayer";
	}

	public CosmeticEditorScreen getScreen() {
		return (CosmeticEditorScreen) super.getScreen();
	}
}
