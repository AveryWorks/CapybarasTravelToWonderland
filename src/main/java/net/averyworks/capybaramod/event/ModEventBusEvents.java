package net.averyworks.capybaramod.event;

import net.averyworks.capybaramod.CapybaraMod;
import net.averyworks.capybaramod.entity.ModEntityTypes;
import net.averyworks.capybaramod.entity.custom.CapybaraEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CapybaraMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class ModEventBusEvents {

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.CAPYBARA.get(), CapybaraEntity.setAttributes());
    }
}
