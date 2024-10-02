package toni.ftbquestsfreezefix;

import com.mojang.logging.LogUtils;
import dev.ftb.mods.ftbquests.client.ClientQuestFile;
import org.slf4j.Logger;

import java.time.Duration;
import java.time.Instant;

#if FABRIC
    import net.fabricmc.api.ClientModInitializer;
    import net.fabricmc.api.ModInitializer;
    import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
    import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
#endif

#if FORGE
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
#endif


#if NEO
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
#endif


#if FORGELIKE
@Mod("ftbquestsfreezefix")
#endif
public class FTBQuestsFreezeFix #if FABRIC implements ClientModInitializer #endif
{
    public static final String MODNAME = "FTB Quests Freeze Fix";
    public static final String ID = "ftbquestsfreezefix";
    public static boolean hasInitialized = false;
    public static final Logger LOGGER = LogUtils.getLogger();

    public FTBQuestsFreezeFix() { }


    #if FABRIC
    @Override
    public void onInitializeClient() {
        ClientPlayConnectionEvents.DISCONNECT.register((handler, client) -> {
            hasInitialized = false;
        });
    }
    #endif
}