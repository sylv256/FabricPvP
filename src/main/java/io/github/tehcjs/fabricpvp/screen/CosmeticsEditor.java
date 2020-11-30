package io.github.tehcjs.fabricpvp.screen;

import com.mojang.blaze3d.platform.GlStateManager;
import io.github.tehcjs.fabricpvp.player.FakeClientPlayerEntity;
import io.github.tehcjs.fabricpvp.world.FakeClientWorld;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.SurvivalInventoryScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.stat.StatHandler;

public class CosmeticsEditor extends Screen {

	public FakeClientWorld fakeWorld;
	public ClientPlayerEntity fakePlayer;

	public PlayerEntityModel playerModel = new PlayerEntityModel(1, true);

	@Override
	public void init(MinecraftClient client, int width, int height) {
		super.init(client, width, height);
		fakeWorld = new FakeClientWorld(this, this.client.session.getProfile());
		fakePlayer = new FakeClientPlayerEntity(this.client, fakeWorld, fakeWorld.getNetHandler(), createFakeStats());
		MinecraftClient.getInstance().player = fakePlayer;
	}

	private StatHandler createFakeStats() {
		return new StatHandler();
	}

	@Override
	public void render(int mouseX, int mouseY, float delta) {
		super.render(mouseX, mouseY, delta);
		this.renderBackground();
		GlStateManager.enableDepthTest();
		SurvivalInventoryScreen.renderEntity(250,250, 100, 0, 0, fakePlayer);
		GlStateManager.disableDepthTest();
	}
}
