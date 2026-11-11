package com.viruss.client.module;

/** Модуль-переключатель: применяет настройку при включении, откатывает при выключении. */
public class FlagModule extends Module {
    public interface Applier { void apply(boolean on); }
    private final Applier applier;

    public FlagModule(String name, String category, String description, Applier applier) {
        super(name, category, description);
        this.applier = applier;
    }

    @Override
    protected void onEnable() { applier.apply(true); }

    @Override
    protected void onDisable() { applier.apply(false); }
}
