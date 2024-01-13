package v0id.vsb.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import v0id.api.vsb.data.VSBRegistryNames;
import v0id.vsb.Tags;

@Config(modid = Tags.MOD_ID)
public class VSBCfg
{
    @Config.RangeInt(min = 0)
    @Config.RequiresMcRestart
    public static int energyUpgradeBasic = 10000;

    @Config.RangeInt(min = 0)
    @Config.RequiresMcRestart
    public static int energyUpgradeAdvanced = 100000;

    @Config.RangeInt(min = 0)
    @Config.RequiresMcRestart
    public static int energyUpgradeUltimate = 1000000;

    @Config.RangeInt(min = 0)
    @Config.RequiresMcRestart
    public static int energyUpgradeCreative = Integer.MAX_VALUE;

    @Config.RangeInt(min = 0)
    public static int furnaceUpgradeFEPerTick = 40;

    @Config.RangeInt(min = 0)
    public static int solarUpgradeFEPerTick = 16;

    @Config.RangeInt(min = 0)
    public static int windUpgradeFEPerTick = 32;

    @Config.RangeInt(min = 0)
    public static int kineticUpgradeFEPerMeter = 20;

    @Config.RangeInt(min = 0)
    public static int nuclearUpgradeFEPerTick = 10;

    @Config.RangeInt(min = 0)
    public static int emUpgradeFEPerPulse = 1;

    @Config.RangeInt(min = 0)
    public static int inductionCoilUpgradeEnergyPerFuel = 40;

    @Config.RequiresMcRestart
    public static boolean dragonDropsScales = true;

    public static boolean useLightUI = false;

    @Config.RangeInt(min = 0, max = 18)
    public static int basicBackpackInventorySize = 18;

    @Config.RangeInt(min = 0, max = 36)
    public static int reinforcedBackpackInventorySize = 36;

    @Config.RangeInt(min = 0, max = 54)
    public static int advancedBackpackInventorySize = 54;

    @Config.RangeInt(min = 0, max = 117)
    public static int ultimateBackpackInventorySize = 117;

    @Config.RangeInt(min = 0, max = 5)
    public static int basicBackpackUpgradesSize = 5;

    @Config.RangeInt(min = 0, max = 9)
    public static int reinforcedBackpackUpgradesSize = 9;

    @Config.RangeInt(min = 0, max = 14)
    public static int advancedBackpackUpgradesSize = 14;

    @Config.RangeInt(min = 0, max = 18)
    public static int ultimateBackpackUpgradesSize = 18;

    @Mod.EventBusSubscriber(modid = Tags.MOD_ID)
    public static class ConfigHandler
    {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
        {
            if (event.getModID().equalsIgnoreCase(Tags.MOD_ID))
            {
                ConfigManager.sync(Tags.MOD_ID, Config.Type.INSTANCE);
            }
        }
    }
}
