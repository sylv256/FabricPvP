package io.github.tehcjs.fabricpvp.world;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.NetworkSide;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.LevelGeneratorType;
import net.minecraft.world.level.LevelInfo;

public class FakeClientWorld extends ClientWorld {

	public FakeClientWorld(Screen screen, GameProfile gameProfile) {
		super(new ClientPlayNetworkHandler(
				MinecraftClient.getInstance(),
				screen,
				new ClientConnection(NetworkSide.CLIENTBOUND),
				gameProfile
				), new LevelInfo(
				0L,
				LevelInfo.GameMode.CREATIVE,
				false,
				false,
				LevelGeneratorType.DEFAULT
		), 0, Difficulty.EASY, MinecraftClient.getInstance().profiler);
	}

	public ClientPlayNetworkHandler getNetHandler() {
		return clientNetHandler;
	}
}
