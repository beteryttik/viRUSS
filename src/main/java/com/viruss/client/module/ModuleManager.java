package com.viruss.client.module;

import com.viruss.client.VIrussClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private final List<Module> modules = new ArrayList<>();
    private final Config config = new Config();

    public List<Module> all() { return modules; }

    public Module byName(String name) {
        for (Module m : modules) if (m.getName().equals(name)) return m;
        return null;
    }

    public void registerAll() {
        MinecraftClient mc = MinecraftClient.getInstance();
        GameOptions o = mc.options;
        final Integer[] prevMipmap = {null};
        final Integer[] prevMipmap2 = {null};
        final Integer[] prevMipmap3 = {null};
        final Double[] prevEntDist = {null};
        final Double[] prevEntDist2 = {null};
        final Integer[] prevFps = {null};
        final Integer[] prevFps2 = {null};
        final Integer[] prevFps3 = {null};
        final Integer[] prevFps4 = {null};
        final Integer[] prevRender1 = {null};
        final Integer[] prevRender2 = {null};
        final Integer[] prevRender3 = {null};
        final Integer[] prevRender4 = {null};
        final Integer[] prevSim1 = {null};
        final Integer[] prevSim2 = {null};
        final Integer[] prevSim3 = {null};
        final Integer[] prevBlend = {null};
        final Integer[] prevScale1 = {null};
        final Integer[] prevScale2 = {null};
        final Integer[] prevScale3 = {null};
        final Double[] prevGamma = {null};
        final Double[] prevGamma2 = {null};
        final Double[] prevGamma3 = {null};
        final Double[] prevFovA = {null};
        final Double[] prevFovB = {null};
        final Double[] prevFovC = {null};
        final Double[] prevFovD = {null};
        final Double[] prevFovE = {null};
        final Double[] prevSens1 = {null};
        final Double[] prevSens2 = {null};
        final Double[] lastX = {0.0};
        final Double[] lastZ = {0.0};
        final Long[] start = {System.currentTimeMillis()};
        final Integer[] prevRender5 = {null};
        final Integer[] prevSim4 = {null};
        final Double[] prevGamma4 = {null};

        add(new FlagModule("Clouds OFF", "Оптимизация", "Отключить облака", on -> { o.getCloudRenderMode().setValue(on ? net.minecraft.client.option.CloudRenderMode.OFF : net.minecraft.client.option.CloudRenderMode.FANCY); }));
        add(new FlagModule("Clouds FAST", "Оптимизация", "Быстрые облака", on -> { o.getCloudRenderMode().setValue(on ? net.minecraft.client.option.CloudRenderMode.FAST : net.minecraft.client.option.CloudRenderMode.FANCY); }));
        add(new FlagModule("Particles Minimal", "Оптимизация", "Минимум частиц", on -> { o.getParticlesMode().setValue(on ? net.minecraft.client.option.ParticlesMode.MINIMAL : net.minecraft.client.option.ParticlesMode.ALL); }));
        add(new FlagModule("Particles Decreased", "Оптимизация", "Уменьшенные частицы", on -> { o.getParticlesMode().setValue(on ? net.minecraft.client.option.ParticlesMode.DECREASED : net.minecraft.client.option.ParticlesMode.ALL); }));
        add(new FlagModule("Entity Shadows OFF", "Оптимизация", "Отключить тени сущностей", on -> { o.getEntityShadows().setValue(!on); }));
        add(new FlagModule("Smooth Lighting OFF", "Оптимизация", "Отключить мягкое освещение", on -> { o.getSmoothLighting().setValue(!on); }));
        add(new FlagModule("Mipmap 0", "Оптимизация", "Отключить мипмап-текстуры", on -> { if (on) { prevMipmap[0] = o.getMipmapLevels().getValue(); o.getMipmapLevels().setValue(0); } else if (prevMipmap[0] != null) o.getMipmapLevels().setValue(prevMipmap[0]); }));
        add(new FlagModule("Mipmap 2", "Оптимизация", "Мипмап 2", on -> { if (on) { prevMipmap2[0] = o.getMipmapLevels().getValue(); o.getMipmapLevels().setValue(2); } else if (prevMipmap2[0] != null) o.getMipmapLevels().setValue(prevMipmap2[0]); }));
        add(new FlagModule("Mipmap 4", "Оптимизация", "Мипмап 4 (по умолчанию)", on -> { if (on) { prevMipmap3[0] = o.getMipmapLevels().getValue(); o.getMipmapLevels().setValue(4); } else if (prevMipmap3[0] != null) o.getMipmapLevels().setValue(prevMipmap3[0]); }));
        add(new FlagModule("Fast Graphics", "Оптимизация", "Быстрый режим графики", on -> { o.getGraphicsMode().setValue(on ? net.minecraft.client.option.GraphicsMode.FAST : net.minecraft.client.option.GraphicsMode.FANCY); }));
        add(new FlagModule("Graphics Fancy", "Оптимизация", "Красивый режим графики", on -> { o.getGraphicsMode().setValue(on ? net.minecraft.client.option.GraphicsMode.FANCY : net.minecraft.client.option.GraphicsMode.FAST); }));
        add(new FlagModule("Vignette OFF", "Оптимизация", "Убрать виньетку", on -> { o.getVignette().setValue(!on); }));
        add(new FlagModule("Entity Distance 75%", "Оптимизация", "Дистанция сущностей 75%", on -> { if (on) { prevEntDist[0] = o.getEntityDistanceScaling().getValue(); o.getEntityDistanceScaling().setValue(0.75); } else if (prevEntDist[0] != null) o.getEntityDistanceScaling().setValue(prevEntDist[0]); }));
        add(new FlagModule("Entity Distance 50%", "Оптимизация", "Дистанция сущностей 50%", on -> { if (on) { prevEntDist2[0] = o.getEntityDistanceScaling().getValue(); o.getEntityDistanceScaling().setValue(0.5); } else if (prevEntDist2[0] != null) o.getEntityDistanceScaling().setValue(prevEntDist2[0]); }));
        add(new FlagModule("Max FPS Unlimited", "Оптимизация", "Лимит FPS 260", on -> { if (on) { prevFps[0] = o.getMaxFps().getValue(); o.getMaxFps().setValue(260); } else if (prevFps[0] != null) o.getMaxFps().setValue(prevFps[0]); }));
        add(new FlagModule("Max FPS 60", "Оптимизация", "Лимит FPS 60", on -> { if (on) { prevFps2[0] = o.getMaxFps().getValue(); o.getMaxFps().setValue(60); } else if (prevFps2[0] != null) o.getMaxFps().setValue(prevFps2[0]); }));
        add(new FlagModule("Max FPS 120", "Оптимизация", "Лимит FPS 120", on -> { if (on) { prevFps3[0] = o.getMaxFps().getValue(); o.getMaxFps().setValue(120); } else if (prevFps3[0] != null) o.getMaxFps().setValue(prevFps3[0]); }));
        add(new FlagModule("Max FPS 240", "Оптимизация", "Лимит FPS 240", on -> { if (on) { prevFps4[0] = o.getMaxFps().getValue(); o.getMaxFps().setValue(240); } else if (prevFps4[0] != null) o.getMaxFps().setValue(prevFps4[0]); }));
        add(new FlagModule("Render Distance 6", "Оптимизация", "Прорисовка 6 чанков", on -> { if (on) { prevRender1[0] = o.getViewDistance().getValue(); o.getViewDistance().setValue(6); } else if (prevRender1[0] != null) o.getViewDistance().setValue(prevRender1[0]); }));
        add(new FlagModule("Render Distance 8", "Оптимизация", "Прорисовка 8 чанков", on -> { if (on) { prevRender2[0] = o.getViewDistance().getValue(); o.getViewDistance().setValue(8); } else if (prevRender2[0] != null) o.getViewDistance().setValue(prevRender2[0]); }));
        add(new FlagModule("Render Distance 10", "Оптимизация", "Прорисовка 10 чанков", on -> { if (on) { prevRender3[0] = o.getViewDistance().getValue(); o.getViewDistance().setValue(10); } else if (prevRender3[0] != null) o.getViewDistance().setValue(prevRender3[0]); }));
        add(new FlagModule("Render Distance 12", "Оптимизация", "Прорисовка 12 чанков", on -> { if (on) { prevRender4[0] = o.getViewDistance().getValue(); o.getViewDistance().setValue(12); } else if (prevRender4[0] != null) o.getViewDistance().setValue(prevRender4[0]); }));
        add(new FlagModule("Simulation Distance 6", "Оптимизация", "Симуляция 6 чанков", on -> { if (on) { prevSim1[0] = o.getSimulationDistance().getValue(); o.getSimulationDistance().setValue(6); } else if (prevSim1[0] != null) o.getSimulationDistance().setValue(prevSim1[0]); }));
        add(new FlagModule("Simulation Distance 8", "Оптимизация", "Симуляция 8 чанков", on -> { if (on) { prevSim2[0] = o.getSimulationDistance().getValue(); o.getSimulationDistance().setValue(8); } else if (prevSim2[0] != null) o.getSimulationDistance().setValue(prevSim2[0]); }));
        add(new FlagModule("Simulation Distance 12", "Оптимизация", "Симуляция 12 чанков", on -> { if (on) { prevSim3[0] = o.getSimulationDistance().getValue(); o.getSimulationDistance().setValue(12); } else if (prevSim3[0] != null) o.getSimulationDistance().setValue(prevSim3[0]); }));
        add(new FlagModule("Biome Blend 0", "Оптимизация", "Без сглаживания биомов", on -> { if (on) { prevBlend[0] = o.getBiomeBlendRadius().getValue(); o.getBiomeBlendRadius().setValue(0); } else if (prevBlend[0] != null) o.getBiomeBlendRadius().setValue(prevBlend[0]); }));
        add(new FlagModule("Ambient Occlusion OFF", "Оптимизация", "Отключить AO-затенение", on -> { o.getAo().setValue(!on); }));
        add(new FlagModule("View Bobbing OFF", "Оптимизация", "Без покачивания камеры", on -> { o.getBobView().setValue(!on); }));
        add(new FlagModule("Auto Jump OFF", "Оптимизация", "Отключить автопрыжок", on -> { o.getAutoJump().setValue(!on); }));
        add(new FlagModule("GUI Scale 1", "Оптимизация", "Масштаб интерфейса 1", on -> { if (on) { prevScale1[0] = o.getGuiScale().getValue(); o.getGuiScale().setValue(1); } else if (prevScale1[0] != null) o.getGuiScale().setValue(prevScale1[0]); }));
        add(new FlagModule("GUI Scale 2", "Оптимизация", "Масштаб интерфейса 2", on -> { if (on) { prevScale2[0] = o.getGuiScale().getValue(); o.getGuiScale().setValue(2); } else if (prevScale2[0] != null) o.getGuiScale().setValue(prevScale2[0]); }));
        add(new FlagModule("GUI Scale 3", "Оптимизация", "Масштаб интерфейса 3", on -> { if (on) { prevScale3[0] = o.getGuiScale().getValue(); o.getGuiScale().setValue(3); } else if (prevScale3[0] != null) o.getGuiScale().setValue(prevScale3[0]); }));
        add(new FlagModule("Sneak Toggle ON", "Оптимизация", "Переключаемый шифт", on -> { o.getSneakToggled().setValue(on); }));
        add(new FlagModule("Sneak Toggle OFF", "Оптимизация", "Обычный шифт", on -> { o.getSneakToggled().setValue(!on); }));
        add(new FlagModule("Sprint Toggle ON", "Оптимизация", "Переключаемый спринт", on -> { o.getSprintToggled().setValue(on); }));
        add(new FlagModule("Sprint Toggle OFF", "Оптимизация", "Обычный спринт", on -> { o.getSprintToggled().setValue(!on); }));
        add(new FlagModule("Fullbright", "Утилиты", "Максимальная яркость", on -> { if (on) { prevGamma[0] = o.getGamma().getValue(); o.getGamma().setValue(16.0); } else if (prevGamma[0] != null) o.getGamma().setValue(prevGamma[0]); }));
        add(new FlagModule("Gamma 1.0", "Утилиты", "Чуть выше стандартной яркости", on -> { if (on) { prevGamma2[0] = o.getGamma().getValue(); o.getGamma().setValue(1.0); } else if (prevGamma2[0] != null) o.getGamma().setValue(prevGamma2[0]); }));
        add(new FlagModule("Gamma 8.0", "Утилиты", "Высокая яркость", on -> { if (on) { prevGamma3[0] = o.getGamma().getValue(); o.getGamma().setValue(8.0); } else if (prevGamma3[0] != null) o.getGamma().setValue(prevGamma3[0]); }));
        add(new FlagModule("FOV 70", "Утилиты", "Обзор 70", on -> { if (on) { prevFovA[0] = o.getFov().getValue(); o.getFov().setValue(70.0); } else if (prevFovA[0] != null) o.getFov().setValue(prevFovA[0]); }));
        add(new FlagModule("FOV 80", "Утилиты", "Обзор 80 (PvP)", on -> { if (on) { prevFovB[0] = o.getFov().getValue(); o.getFov().setValue(80.0); } else if (prevFovB[0] != null) o.getFov().setValue(prevFovB[0]); }));
        add(new FlagModule("FOV 90", "Утилиты", "Обзор 90", on -> { if (on) { prevFovC[0] = o.getFov().getValue(); o.getFov().setValue(90.0); } else if (prevFovC[0] != null) o.getFov().setValue(prevFovC[0]); }));
        add(new FlagModule("FOV 100", "Утилиты", "Обзор 100", on -> { if (on) { prevFovD[0] = o.getFov().getValue(); o.getFov().setValue(100.0); } else if (prevFovD[0] != null) o.getFov().setValue(prevFovD[0]); }));
        add(new FlagModule("FOV 110", "Утилиты", "Обзор 110 (широкий)", on -> { if (on) { prevFovE[0] = o.getFov().getValue(); o.getFov().setValue(110.0); } else if (prevFovE[0] != null) o.getFov().setValue(prevFovE[0]); }));
        add(new FlagModule("Sensitivity 50%", "Утилиты", "Чувствительность мыши 50%", on -> { if (on) { prevSens1[0] = o.getMouseSensitivity().getValue(); o.getMouseSensitivity().setValue(0.5); } else if (prevSens1[0] != null) o.getMouseSensitivity().setValue(prevSens1[0]); }));
        add(new FlagModule("Sensitivity 100%", "Утилиты", "Чувствительность мыши 100%", on -> { if (on) { prevSens2[0] = o.getMouseSensitivity().getValue(); o.getMouseSensitivity().setValue(1.0); } else if (prevSens2[0] != null) o.getMouseSensitivity().setValue(prevSens2[0]); }));
        add(new FlagModule("Hide GUI", "Утилиты", "Скрыть весь интерфейс игры", on -> { o.getHideGui().setValue(on); }));
        add(new FlagModule("HUD OFF", "Утилиты", "Скрыть модули VIruss HUD", on -> { VIrussClient.hudVisible = !on; }));
        add(new HudModule("FPS", "Кадры в секунду", () -> { return "FPS: " + mc.getCurrentFps(); }, 0, 0xff00e5ff));
        add(new HudModule("XYZ", "Координаты игрока", () -> { var p = mc.player; return String.format("XYZ: %.1f / %.1f / %.1f", p.getX(), p.getY(), p.getZ()); }, 0, 0xffffffff));
        add(new HudModule("Block Pos", "Целые координаты блока", () -> { var p = mc.player.getBlockPos(); return "Block: " + p.toShortString(); }, 0, 0xffffffff));
        add(new HudModule("Chunk", "Позиция внутри чанка", () -> { var p = mc.player.getBlockPos(); return "In-chunk: " + (p.getX() & 15) + " " + (p.getY() & 15) + " " + (p.getZ() & 15); }, 0, 0xff7cff7c));
        add(new HudModule("Direction", "Сторона света", () -> { return "Facing: " + mc.player.getHorizontalFacing().asString().toUpperCase(); }, 0, 0xff00e5ff));
        add(new HudModule("Biome", "Текущий биом", () -> { var k = mc.world.getBiome(mc.player.getBlockPos()).getKey(); return "Biome: " + k.map(b -> b.getValue().getPath()).orElse("unknown"); }, 0, 0xff7cff7c));
        add(new HudModule("CPS", "Клики в секунду", () -> { return "CPS: " + com.viruss.client.util.CpsCounter.getCps(); }, 0, 0xffffd54f));
        add(new HudModule("Ping", "Задержка до сервера", () -> { if (mc.getNetworkHandler() == null) return "Ping: -"; var e = mc.getNetworkHandler().getPlayerList(); if (e.isEmpty()) return "Ping: -"; return "Ping: " + e.get(0).getLatency() + "ms"; }, 0, 0xff7cff7c));
        add(new HudModule("RAM", "Память JVM", () -> { Runtime r = Runtime.getRuntime(); return String.format("RAM: %dM / %dM", (r.totalMemory()-r.freeMemory())/1048576, r.maxMemory()/1048576); }, 0, 0xff00e5ff));
        add(new HudModule("Health", "Здоровье", () -> { return String.format("HP: %.1f", mc.player.getHealth()); }, 1, 0xff7cff7c));
        add(new HudModule("Health %", "Здоровье в процентах", () -> { return String.format("HP: %.0f%%", mc.player.getHealth() / 20.0 * 100); }, 1, 0xff7cff7c));
        add(new HudModule("Absorption", "Абсорбция (золотые сердца)", () -> { return String.format("Absorb: %.0f", mc.player.getAbsorptionAmount()); }, 1, 0xffffd54f));
        add(new HudModule("Hunger", "Голод", () -> { return "Food: " + mc.player.getHungerManager().getFoodLevel(); }, 1, 0xff7cff7c));
        add(new HudModule("Saturation", "Насыщение", () -> { return String.format("Sat: %.1f", mc.player.getHungerManager().getSaturationLevel()); }, 1, 0xffffd54f));
        add(new HudModule("Speed", "Скорость (блоков/с)", () -> { var d = mc.player.getPos(); double s = Math.hypot(d.x - lastX[0], d.z - lastZ[0]) * 20; lastX[0] = d.x; lastZ[0] = d.z; return String.format("Speed: %.1f b/s", s); }, 1, 0xff00e5ff));
        add(new HudModule("Yaw", "Горизонтальный поворот", () -> { return String.format("Yaw: %.0f", mc.player.getYaw()); }, 1, 0xffffffff));
        add(new HudModule("Pitch", "Вертикальный поворот", () -> { return String.format("Pitch: %.0f", mc.player.getPitch()); }, 1, 0xffffffff));
        add(new HudModule("Yaw/Pitch", "Оба угла", () -> { return String.format("Y/P: %.0f / %.0f", mc.player.getYaw(), mc.player.getPitch()); }, 1, 0xffffffff));
        add(new HudModule("Held Item", "Предмет в руке", () -> { var st = mc.player.getMainHandStack(); return "Held: " + (st.isEmpty() ? "-" : st.getName().getString()); }, 2, 0xffffffff));
        add(new HudModule("Server", "Текущий сервер", () -> { if (mc.getCurrentServerEntry() == null) return "Server: Singleplayer"; return "Server: " + mc.getCurrentServerEntry().address; }, 2, 0xff7cff7c));
        add(new HudModule("Server IP", "IP сервера", () -> { if (mc.getCurrentServerEntry() == null) return "IP: Singleplayer"; return "IP: " + mc.getCurrentServerEntry().address + ":" + mc.getCurrentServerEntry().port; }, 2, 0xff7cff7c));
        add(new HudModule("Players Online", "Игроков в списке", () -> { if (mc.getNetworkHandler() == null) return "Players: -"; return "Players: " + mc.getNetworkHandler().getPlayerList().size(); }, 2, 0xff00e5ff));
        add(new HudModule("Avg Ping", "Средний пинг", () -> { if (mc.getNetworkHandler() == null) return "Avg: -"; var e = mc.getNetworkHandler().getPlayerList(); if (e.isEmpty()) return "Avg: -"; int s = 0; for (var p : e) s += p.getLatency(); return "Avg: " + (s / e.size()) + "ms"; }, 2, 0xff7cff7c));
        add(new HudModule("Game Time", "Время в мире", () -> { long t = mc.world.getTimeOfDay() % 24000; return String.format("Time: %02d:%02d", (t/1000+6)%24, (int)((t%1000)*60/1000)); }, 2, 0xff00e5ff));
        add(new HudModule("Day", "День мира", () -> { return "Day: " + (mc.world.getTimeOfDay() / 24000 + 1); }, 2, 0xff7cff7c));
        add(new HudModule("Playtime", "Сессия (мин)", () -> { return "Session: " + ((System.currentTimeMillis() - start[0]) / 60000) + " min"; }, 2, 0xff00e5ff));
        add(new HudModule("Real Time", "Реальное время ПК", () -> { return java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss")); }, 2, 0xffffffff));
        add(new HudModule("Light Level", "Уровень света", () -> { return "Light: " + mc.world.getLightLevel(mc.player.getBlockPos()); }, 2, 0xffffd54f));
        add(new HudModule("Dimension", "Измерение", () -> { return "Dim: " + mc.world.getRegistryKey().getValue().getPath(); }, 2, 0xff00e5ff));
        add(new HudModule("Armor Pieces", "Надето брони", () -> { int n = 0; for (var it : mc.player.getArmorItems()) if (!it.isEmpty()) n++; return "Armor: " + n + "/4"; }, 3, 0xff7cff7c));
        add(new HudModule("Exp Level", "Уровень опыта", () -> { return "XP: lvl " + mc.player.experienceLevel; }, 3, 0xffffd54f));
        add(new HudModule("Game Mode", "Режим игры", () -> { return "Mode: " + (mc.player.isCreative() ? "Creative" : mc.player.isSpectator() ? "Spectator" : "Survival"); }, 3, 0xff7cff7c));
        add(new HudModule("Version", "Версия клиента", () -> { return "VIruss " + VIrussClient.VERSION + " / MC 1.21.1"; }, 3, 0xff00e5ff));
        add(new HudModule("Module Count", "Число модулей", () -> { return "Modules: " + VIrussClient.modules.all().size(); }, 3, 0xff7cff7c));
        add(new HudModule("Enabled Count", "Активных модулей", () -> { long n = VIrussClient.modules.all().stream().filter(Module::isEnabled).count(); return "Active: " + n; }, 3, 0xff7cff7c));
        add(new HudModule("Looking At", "Блок под прицелом", () -> { var hit = mc.player.raycast(6.0, 0.0f, true); var b = mc.world.getBlockState(net.minecraft.util.math.BlockPos.ofFloored(hit.getPos())); return "Look: " + b.getBlock().getName().getString(); }, 3, 0xffffffff));
        add(new HudModule("Underwater", "Под водой?", () -> { return mc.player.isSubmergedInWater() ? "WATER: YES" : "WATER: NO"; }, 3, 0xff00e5ff));
        add(new HudModule("On Ground", "На земле?", () -> { return mc.player.isOnGround() ? "GROUND: YES" : "GROUND: NO"; }, 3, 0xff00e5ff));
        add(new HudModule("Sneaking", "Приседает?", () -> { return mc.player.isSneaking() ? "SNEAK: YES" : "SNEAK: NO"; }, 3, 0xff00e5ff));
        add(new HudModule("Sprinting", "Бежит?", () -> { return mc.player.isSprinting() ? "SPRINT: YES" : "SPRINT: NO"; }, 3, 0xff00e5ff));
        add(new HudModule("Elytra", "Планирует?", () -> { return mc.player.isGliding() ? "ELYTRA: YES" : "ELYTRA: NO"; }, 3, 0xffb388ff));
        add(new HudModule("Raining", "Дождь?", () -> { return mc.world.isRaining() ? "RAIN: YES" : "RAIN: NO"; }, 3, 0xffb388ff));
        add(new HudModule("Thundering", "Гроза?", () -> { return mc.world.isThundering() ? "THUNDER: YES" : "THUNDER: NO"; }, 3, 0xffb388ff));
        add(new HudModule("Hotbar Slot", "Слот в хотбаре", () -> { return "Slot: " + (mc.player.getInventory().selectedSlot + 1) + "/9"; }, 3, 0xffffffff));
        add(new ActionModule("Максимальный FPS", "Пресеты", "Всё ради FPS", () -> applyPreset(new String[]{"Clouds OFF", "Particles Minimal", "Entity Shadows OFF", "Smooth Lighting OFF", "Mipmap 0", "Fast Graphics", "Vignette OFF", "Entity Distance 75%", "Max FPS Unlimited", "Render Distance 8", "Simulation Distance 8", "Biome Blend 0", "Ambient Occlusion OFF", "View Bobbing OFF"})));

        add(new ActionModule("Баланс", "Пресеты", "Умеренный буст", () -> applyPreset(new String[]{"Clouds OFF", "Particles Decreased", "Max FPS Unlimited", "Mipmap 2", "Entity Shadows OFF"})));

        add(new ActionModule("PvP", "Пресеты", "Готовка к бою", () -> applyPreset(new String[]{"Max FPS Unlimited", "FOV 80", "Sprint Toggle ON", "Sneak Toggle ON", "Fullbright"})));

        add(new ActionModule("Качество+", "Пресеты", "Чисто и красиво", () -> applyPreset(new String[]{"Clouds OFF", "Render Distance 8", "Simulation Distance 8", "Fullbright", "Graphics Fancy"})));

    }

        add(new FlagModule("Render Distance 14", "Оптимизация", "Прорисовка 14 чанков", on -> { if (on) { prevRender5[0] = o.getViewDistance().getValue(); o.getViewDistance().setValue(14); } else if (prevRender5[0] != null) o.getViewDistance().setValue(prevRender5[0]); }));
        add(new FlagModule("Simulation Distance 16", "Оптимизация", "Симуляция 16 чанков", on -> { if (on) { prevSim4[0] = o.getSimulationDistance().getValue(); o.getSimulationDistance().setValue(16); } else if (prevSim4[0] != null) o.getSimulationDistance().setValue(prevSim4[0]); }));
        add(new FlagModule("Gamma 4.0", "Утилиты", "Средняя повышенная яркость", on -> { if (on) { prevGamma4[0] = o.getGamma().getValue(); o.getGamma().setValue(4.0); } else if (prevGamma4[0] != null) o.getGamma().setValue(prevGamma4[0]); }));
        add(new HudModule("XYZ Short", "Короткие координаты", () -> { return String.format("%d, %d, %d", (int)mc.player.getX(), (int)mc.player.getY(), (int)mc.player.getZ()); }, 0, 0xFFFFFFFF));
        add(new HudModule("Session Sec", "Сессия в секундах", () -> { return "Uptime: " + ((System.currentTimeMillis() - start[0]) / 1000) + "s"; }, 2, 0xFFB388FF));
        add(new HudModule("Face Arrow", "Сторона света стрелкой", () -> { var f = mc.player.getHorizontalFacing(); String a = f == net.minecraft.util.math.Direction.NORTH ? "^" : f == net.minecraft.util.math.Direction.SOUTH ? "v" : f == net.minecraft.util.math.Direction.EAST ? ">" : "<"; return "Dir: " + a; }, 0, 0xFF00E5FF));

    private void applyPreset(String[] names) {
        for (String n : names) {
            Module m = byName(n);
            if (m != null) m.setEnabled(true);
        }
    }

    private void add(Module m) { modules.add(m); }

    public void loadConfig() { config.load(modules); }
    public void saveConfig() { config.save(modules); }
    public Config getConfig() { return config; }
}