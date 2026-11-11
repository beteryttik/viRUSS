package com.viruss.client.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Config {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path FILE = FabricLoader.getInstance().getConfigDir().resolve("virussclient.json");
    public Map<String, Boolean> enabled = new HashMap<>();

    public void save(java.util.List<Module> modules) {
        enabled.clear();
        for (Module m : modules) if (m.isEnabled()) enabled.put(m.getName(), true);
        try { Files.createDirectories(FILE.getParent()); Files.writeString(FILE, GSON.toJson(this)); }
        catch (IOException ignored) {}
    }

    public void load(java.util.List<Module> modules) {
        try {
            if (!Files.exists(FILE)) return;
            Config c = GSON.fromJson(Files.readString(FILE), Config.class);
            if (c == null) return;
            for (Module m : modules) m.setEnabled(c.enabled.getOrDefault(m.getName(), false));
        } catch (Exception ignored) {}
    }
}
