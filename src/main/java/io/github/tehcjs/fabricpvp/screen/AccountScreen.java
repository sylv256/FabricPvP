package io.github.tehcjs.fabricpvp.screen;

import com.mojang.authlib.Agent;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.util.Session;

import java.net.Proxy;

public class AccountScreen extends Screen {

	public TextFieldWidget username;
	public TextFieldWidget password;
	private int loginStatus;

	@Override
	public void init(MinecraftClient client, int width, int height) {
		super.init(client, width, height);

		this.username = new TextFieldWidget(2, this.textRenderer, this.width / 2 - 100, 96, 200, 20);
		this.username.setMaxLength(128);
		this.username.setFocused(true);

		this.password = new TextFieldWidget(2, this.textRenderer, this.width / 2 - 100, 126, 200, 20);
		this.password.setMaxLength(128);
		this.password.setFocused(false);

		this.buttons.add(new ButtonWidget(1, this.width / 2 - 100, 176, 200, 20, "Login"));
	}

	private void setSessionInfo() throws AuthenticationException {
		YggdrasilUserAuthentication auth = (YggdrasilUserAuthentication) new YggdrasilAuthenticationService(Proxy.NO_PROXY, "").createUserAuthentication(Agent.MINECRAFT);
		auth.setUsername(username.getText());
		auth.setPassword(password.getText());
		auth.logIn();
		this.client.session = new Session(auth.getSelectedProfile().getName(), auth.getSelectedProfile().getId().toString(), auth.getAuthenticatedToken(), "mojang");
	}

	@Override
	protected void keyPressed(char character, int code) {
		super.keyPressed(character, code);
		this.username.keyPressed(character, code);
		this.password.keyPressed(character, code);
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int button) {
		super.mouseClicked(mouseX, mouseY, button);
		this.username.mouseClicked(mouseX, mouseY, button);
		this.password.mouseClicked(mouseX, mouseY, button);
	}

	@Override
	public void render(int mouseX, int mouseY, float delta) {
		renderBackground();
		this.username.render();
		this.password.render();
		switch (loginStatus) {
			case 0:
				drawCenteredString("Put in login info", this.width / 2, 66, 0xFFFFFFFF);
				break;
			case 1:
				drawCenteredString("Login Failed!", this.width / 2, 66, 0xFFFF0000);
				break;
			case 2:
				drawCenteredString("Login Success!", this.width / 2, 66, 0xFF00FF00);
				break;
		}
		super.render(mouseX, mouseY, delta);
	}

	public void drawCenteredString(String text, int x, int y, int colour) {
		this.textRenderer.draw(text, x - (textRenderer.getStringWidth(text) / 2), y, colour);
	}

	@Override
	public void buttonClicked(ButtonWidget button) {
		if (button.id == 1) {
			try {
				setSessionInfo();
				loginStatus = 2;
			} catch (AuthenticationException e) {
				loginStatus = 1;
			}
		}
	}
}
