package io.github.tehcjs.fabricpvp.screen;

import com.mojang.authlib.GameProfile;
import io.github.tehcjs.fabricpvp.api.gui.element.component.RenderedPlayerComponent;
import io.github.tehcjs.fabricpvp.api.gui.screen.Screen;
import io.github.tehcjs.fabricpvp.player.FakeClientPlayerEntity;
import io.github.tehcjs.fabricpvp.world.FakeClientWorld;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.model.PlayerEntityModel;

import java.util.UUID;

import static io.github.tehcjs.fabricpvp.utilities.Util.id;

public class CosmeticEditorScreen extends Screen {
	public FakeClientWorld fakeWorld;
	public FakeClientPlayerEntity fakePlayer;
	private final RenderedPlayerComponent rpc = new RenderedPlayerComponent(this,
			50, new PlayerEntityModel(1, true));

	public CosmeticEditorScreen() {
		super(id("screen/style/cosmeticEditor.fabricpvp.css"));
		this.addElement(rpc);
	}

	@Override
	public void init(MinecraftClient client, int width, int height) {
		super.init(client, width, height);
		fakeWorld = new FakeClientWorld(this,
				this.client.session.getProfile());
		fakePlayer = new FakeClientPlayerEntity(this.client, fakeWorld);
		MinecraftClient.getInstance().player = fakePlayer;
		rpc.setX(this.width / 2);
		rpc.setY(this.height / 2 + 50);
	}

	@Override
	public void render(int mouseX, int mouseY, float delta) {
		this.renderBackground();
		super.render(mouseX, mouseY, delta);
	}
}
