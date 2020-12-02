package io.github.tehcjs.fabricpvp.screen;

import io.github.hydos.screenss.CSSScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.util.Identifier;

import static io.github.tehcjs.fabricpvp.utilities.Util.id;

public class CosmeticsEditor extends CSSScreen {
	public PlayerEntityModel playerModel = new PlayerEntityModel(1, true);

	public CosmeticsEditor(Identifier styleSheet) {
		super(id("screen/style/cosmeticEditor.fabricpvp.css"));
	}

	@Override
	public void init(MinecraftClient client, int width, int height) {
		super.init(client, width, height);
	}
}
