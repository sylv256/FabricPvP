package io.github.tehcjs.fabricpvp.api.gui.element.component;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.ingame.SurvivalInventoryScreen;
import net.minecraft.client.render.entity.model.PlayerEntityModel;

//public class RenderedPlayerComponent extends DrawableHelper {
//	private final PlayerEntityModel playerModel;
//	private final int size;
//
//	private float mouseX;
//	private float mouseY;
//
//	private int x,y;
//
//	public RenderedPlayerComponent(int x, int y, int size, PlayerEntityModel playerModel) {
//		this.size = size;
//		this.playerModel = playerModel;
//	}
//
//	public void render(int mouseX, int mouseY) {
//		this.mouseX = (float) mouseX;
//		this.mouseY = (float) mouseY;
//		GlStateManager.enableDepthTest();
//		SurvivalInventoryScreen.renderEntity(this.x, this.y, size, (float)(this.x) - this.mouseX, (float)(this.y - 1.5 * size) - this.mouseY, getScreen().fakePlayer);
//		GlStateManager.disableDepthTest();
//	}
//}
