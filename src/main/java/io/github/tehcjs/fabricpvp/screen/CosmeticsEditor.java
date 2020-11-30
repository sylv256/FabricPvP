package io.github.tehcjs.fabricpvp.screen;

import com.mojang.blaze3d.platform.GlStateManager;
import io.github.tehcjs.fabricpvp.entity.FakeEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.entity.model.PlayerEntityModel;

public class CosmeticsEditor extends Screen {

	public PlayerEntityModel playerModel = new PlayerEntityModel(1, true);

	@Override
	public void init(MinecraftClient client, int width, int height) {
		super.init(client, width, height);
	}

	@Override
	public void render(int mouseX, int mouseY, float delta) {
		super.render(mouseX, mouseY, delta);
		this.renderBackground();
		GlStateManager.pushMatrix();
		GlStateManager.translatef(100,100,0);
		playerModel.render(FakeEntity.INSTANCE, 62.070034f, 1.7083983E-33f, 356.44022f, -7.3862f, -7.950007f, 0.0625f);
		GlStateManager.popMatrix();
	}
}
