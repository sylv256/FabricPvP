package io.github.tehcjs.fabricpvp.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.PlayerListEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.UUID;

@Mixin(AbstractClientPlayerEntity.class)
public class AbstractClientPlayerEntityMixin {

	@Shadow private PlayerListEntry cachedScoreboardEntry;

	@Inject(method = "getPlayerListEntry", at = @At("HEAD"), cancellable = true)
	private void supportFakeEntities(CallbackInfoReturnable<PlayerListEntry> cir){
		if (this.cachedScoreboardEntry == null) {
			this.cachedScoreboardEntry = new PlayerListEntry(new GameProfile(UUID.randomUUID(), "E A SPORTS"));
		}
	}

}
