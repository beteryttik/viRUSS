package com.viruss.client.mixin;

import com.viruss.client.util.CpsCounter;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class CpsMixin {
    @Inject(method = "doAttack", at = @At("HEAD"))
    private void viruss$click(CallbackInfo ci) { CpsCounter.click(); }
}
