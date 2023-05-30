package net.averyworks.capybaramod.world;

import net.averyworks.capybaramod.CapybaraMod;
import net.averyworks.capybaramod.world.gen.ModEntityGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CapybaraMod.MOD_ID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {

        ModEntityGeneration.onEntitySpawn(event);
    }
}
