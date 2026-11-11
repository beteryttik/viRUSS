package com.viruss.client;

import com.viruss.client.gui.MenuScreen;
import com.viruss.client.hud.HudRenderer;
import com.viruss.client.module.Config;
import com.viruss.client.module.Module;
import com.viruss.client.module.ModuleManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class VIrussClient implements ClientModInitializer {
    public static final String VERSION = "1.0.0";
    public static ModuleManager modules;
    public static boolean hudVisible = true;

    private static KeyBinding menuKey;
    private static KeyBinding hudKey;

    public static MinecraftClient mc() { return MinecraftClient.getInstance(); }

    @Override
    public void onInitializeClient() {
        System.out.println("[VIruss Client] Initializing v" + VERSION);
        modules = new ModuleManager();
        modules.registerAll();
        modules.loadConfig();

        menuKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.virussclient.menu", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_RIGHT_SHIFT, "category.virussclient"));
        hudKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.virussclient.hud", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_O, "category.virussclient"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (menuKey.wasPressed()) client.setScreen(new MenuScreen());
            while (hudKey.wasPressed()) hudVisible = !hudVisible;
        });

        HudRenderer.register();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> modules.saveConfig()));
        System.out.println("[VIruss Client] Ready. Modules: " + modules.all().size());
    }

    public static void toggle(Module m) { m.toggle(); }
}
