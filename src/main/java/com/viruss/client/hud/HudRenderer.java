package com.viruss.client.hud;

import com.viruss.client.VIrussClient;
import com.viruss.client.module.HudModule;
import com.viruss.client.module.Module;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;

import java.util.ArrayList;
import java.util.List;

public class HudRenderer {
    private static final int PAD = 4;
    private static final int LINE = 11;

    public static void register() {
        HudRenderCallback.EVENT.register((DrawContext ctx, RenderTickCounter tick) -> {
            if (!VIrussClient.hudVisible) return;
            MinecraftClient mc = MinecraftClient.getInstance();
            if (mc.player == null || mc.getDebugHud().shouldShowDebugHud()) return;
            TextRenderer font = mc.textRenderer;

            List<List<HudModule>> corners = List.of(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
            int i = 0;
            for (Module m : VIrussClient.modules.all()) {
                if (m instanceof HudModule h && m.isEnabled()) {
                    List<HudModule> list = (List<HudModule>) corners.get(h.getCorner());
                    h.setSlot(list.size());
                    list.add(h);
                    i++;
                }
            }
            if (i == 0) return;

            int sw = ctx.getScaledWindowWidth();
            int sh = ctx.getScaledWindowHeight();

            for (int c = 0; c < 4; c++) {
                for (HudModule h : corners.get(c)) {
                    String text = h.getText().get();
                    if (text == null) continue;
                    int w = font.getWidth(text);
                    int x = (c == 1 || c == 3) ? sw - w - PAD : PAD;
                    int y = (c < 2 ? PAD : sh - LINE - PAD) + h.getSlot() * LINE;
                    ctx.fill(x - 2, y - 2, x + w + 2, y + LINE - 2, 0x88000000);
                    ctx.drawTextWithShadow(font, text, x, y, h.getColor());
                }
            }
        });
    }
}
