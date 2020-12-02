package io.github.tehcjs.fabricpvp.player;

import io.github.tehcjs.fabricpvp.world.FakeClientWorld;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.stat.StatHandler;
import net.minecraft.world.World;

public class FakeClientPlayerEntity extends ClientPlayerEntity {

	public FakeClientPlayerEntity(MinecraftClient client, World world, ClientPlayNetworkHandler networkHandler, StatHandler stats) {
		super(client, world, networkHandler, stats);
	}

	public FakeClientPlayerEntity(MinecraftClient client, FakeClientWorld world) {
		super(client, world, world.getNetHandler(), new StatHandler());
		loadSkin(getSkinTexture(), getName().asString());
	}

	/**
	 * force renderer to render this player thanks {@link net.minecraft.client.render.entity.PlayerEntityRenderer} line 47
	 *
	 * @return false
	 */
	@Override
	public boolean isMainPlayer() {
		return false;
	}

	/**
	 * a network manager has not been initialized. notchjank 100. why is that in the network manager
	 *
	 * @return false
	 */
	@Override
	public boolean isSpectator() {
		return false;
	}

	// ignore this pls
	/*@Override
	public Identifier getSkinTexture() {
		return getSkinId(getName().asString());
	}

	@Override
	public Text getName() {
		Text t = super.getName();
		Text text = new LiteralText("Herobrine");
		text.setStyle(t.getStyle());
		return text;
	}*/
}
