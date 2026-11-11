package com.viruss.client.module;

import java.util.function.Supplier;

/** HUD-модуль: строка текста в одном из углов экрана. */
public class HudModule extends Module {
    private final Supplier<String> text;
    private final int corner; // 0 = верх-лево, 1 = верх-право, 2 = низ-лево, 3 = низ-право
    private final int color;
    private int slot = -1;

    public HudModule(String name, String description, Supplier<String> text, int corner, int color) {
        super(name, "HUD", description);
        this.text = text;
        this.corner = corner;
        this.color = color;
    }

    public Supplier<String> getText() { return text; }
    public int getCorner() { return corner; }
    public int getColor() { return color; }
    public int getSlot() { return slot; }
    public void setSlot(int slot) { this.slot = slot; }
}
