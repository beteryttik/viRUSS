package com.viruss.client.gui;

import com.viruss.client.VIrussClient;
import com.viruss.client.module.Module;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class MenuScreen extends Screen {
    private static final String[] CATS = {"ВСЕ", "HUD", "Оптимизация", "Утилиты", "Пресеты"};
    private static final int PER_PAGE = 10;
    private int cat = 0;
    private int page = 0;
    private final List<Rect> hitboxes = new ArrayList<>();

    public MenuScreen() { super(Text.literal("VIruss Client")); }

    private List<Module> filtered() {
        List<Module> list = new ArrayList<>();
        String c = CATS[cat];
        for (Module m : VIrussClient.modules.all())
            if (c.equals("ВСЕ") || m.getCategory().equalsIgnoreCase(c)) list.add(m);
        return list;
    }

    @Override
    public void render(DrawContext ctx, int mouseX, int mouseY, float delta) {
        this.renderBackground(ctx, mouseX, mouseY, delta);
        int w = this.width, h = this.height;
        int pw = Math.min(360, w - 40), ph = Math.min(340, h - 60);
        int px = (w - pw) / 2, py = (h - ph) / 2;

        ctx.fill(px, py, px + pw, py + ph, 0xE005070A);
        ctx.drawBorder(px, py, pw, ph, 0xFF00E5FF);
        ctx.drawCenteredTextWithShadow(this.textRenderer, "VIRUSS CLIENT", w / 2, py + 6, 0xFF00E5FF);

        hitboxes.clear();
        int tx = px + 8;
        for (int i = 0; i < CATS.length; i++) {
            int tw = this.textRenderer.getWidth(CATS[i]) + 8;
            boolean active = i == cat;
            ctx.fill(tx - 2, py + 18, tx + tw - 2, py + 30, active ? 0xFF00E5FF : 0xFF0F1418);
            ctx.drawTextWithShadow(this.textRenderer, CATS[i], tx, py + 21, active ? 0xFF000000 : 0xFF8B94A0);
            final int idx = i;
            hitboxes.add(new Rect(tx - 2, py + 18, tw, 12, () -> { cat = idx; page = 0; }));
            tx += tw + 4;
        }

        List<Module> list = filtered();
        int pages = Math.max(1, (int) Math.ceil(list.size() / (double) PER_PAGE));
        page = Math.min(page, pages - 1);
        int y = py + 38;
        for (int i = page * PER_PAGE; i < Math.min(list.size(), (page + 1) * PER_PAGE); i++) {
            Module m = list.get(i);
            boolean on = m.isEnabled();
            int by = y;
            ctx.fill(px + 8, by, px + pw - 8, by + 24, on ? 0xFF0A2A33 : 0xFF0F1418);
            int color = on ? 0xFF00E5FF : 0xFFFFFFFF;
            ctx.drawTextWithShadow(this.textRenderer, (on ? "[ON] " : "[OFF] ") + m.getName(), px + 14, by + 4, color);
            ctx.drawTextWithShadow(this.textRenderer, m.getDescription(), px + 14, by + 14, 0xFF8B94A0);
            final Module fm = m;
            hitboxes.add(new Rect(px + 8, by, pw - 16, 24, fm::toggle));
            y += 26;
        }

        if (pages > 1) {
            int by = py + ph - 18;
            ctx.fill(px + 8, by, px + 38, by + 14, 0xFF0F1418);
            ctx.drawCenteredTextWithShadow(this.textRenderer, "<", px + 23, by + 3, 0xFFFFFFFF);
            ctx.drawCenteredTextWithShadow(this.textRenderer, (page + 1) + "/" + pages, px + pw / 2, by + 3, 0xFF8B94A0);
            ctx.fill(px + pw - 38, by, px + pw - 8, by + 14, 0xFF0F1418);
            ctx.drawCenteredTextWithShadow(this.textRenderer, ">", px + pw - 23, by + 3, 0xFFFFFFFF);
            hitboxes.add(new Rect(px + 8, by, 30, 14, () -> page = Math.max(0, page - 1)));
            hitboxes.add(new Rect(px + pw - 38, by, 30, 14, () -> page = Math.min(pages - 1, page + 1)));
        }

        ctx.drawCenteredTextWithShadow(this.textRenderer, "Right Shift — закрыть | O — HUD", w / 2, py + ph + 8, 0xFF8B94A0);
        super.render(ctx, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0)
            for (Rect r : hitboxes)
                if (r.hit(mouseX, mouseY)) { r.action.run(); VIrussClient.modules.saveConfig(); return true; }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean shouldPause() { return false; }

    private record Rect(int x, int y, int w, int h, Runnable action) {
        boolean hit(double mx, double my) { return mx >= x && mx <= x + w && my >= y && my <= y + h; }
    }
}
