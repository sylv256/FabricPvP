package io.github.tehcjs.fabricpvp.screen;

import com.mojang.authlib.Agent;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.Session;

import java.lang.reflect.Field;
import java.net.Proxy;

public class AccountScreen extends Screen {

    public AccountScreen() {
        this.client = MinecraftClient.getInstance();
        try {
            Field sessionField = MinecraftClient.class.getDeclaredField("session");
            sessionField.setAccessible(true);
            YggdrasilUserAuthentication auth = (YggdrasilUserAuthentication) new YggdrasilAuthenticationService(Proxy.NO_PROXY, "").createUserAuthentication(Agent.MINECRAFT);
            sessionField.set(this.client, new Session("", "", "", ""));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render(int mouseX, int mouseY, float delta) {
        renderBackground();
    }

    @Override
    public void buttonClicked(ButtonWidget button) {

    }
}
