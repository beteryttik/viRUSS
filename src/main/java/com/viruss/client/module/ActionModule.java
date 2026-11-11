package com.viruss.client.module;

/** Модуль-действие (пресет): при включении применяет набор тогглов и выключается. */
public class ActionModule extends Module {
    public interface Action { void run(); }
    private final Action action;

    public ActionModule(String name, String category, String description, Action action) {
        super(name, category, description);
        this.action = action;
    }

    @Override
    protected void onEnable() {
        action.run();
        setEnabled(false);
    }
}
