package net.averyworks.capybaramod;

import com.mojang.logging.LogUtils;
import net.averyworks.capybaramod.entity.ModEntityTypes;
import net.averyworks.capybaramod.entity.client.CapybaraRenderer;
import net.averyworks.capybaramod.item.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

import java.util.stream.Collectors;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(CapybaraMod.MOD_ID)
public class CapybaraMod
{
    // Directly reference a slf4j logger
    public static final String MOD_ID = "capybaramod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public CapybaraMod()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the setup method for modloading
        // Register the enqueueIMC method for modloading
        eventBus.addListener(this::clientSetup);
        ModItems.register(eventBus);
        ModEntityTypes.register(eventBus);

        GeckoLib.initialize();
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLCommonSetupEvent event){

        EntityRenderers.register(ModEntityTypes.CAPYBARA.get(), CapybaraRenderer::new);

    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code

    }
}
