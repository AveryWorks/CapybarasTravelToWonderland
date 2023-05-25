package net.averyworks.capybaramod.entity.client;

import net.averyworks.capybaramod.CapybaraMod;
import net.averyworks.capybaramod.entity.custom.CapybaraEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CapybaraModel extends AnimatedGeoModel<CapybaraEntity> {

    @Override
    public ResourceLocation getModelLocation(CapybaraEntity object) {
        return new ResourceLocation(CapybaraMod.MOD_ID, "geo/capybara.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(CapybaraEntity object) {
        return new ResourceLocation(CapybaraMod.MOD_ID, "textures/entity/capybara/capybara.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(CapybaraEntity animatable) {
        return new ResourceLocation(CapybaraMod.MOD_ID, "animations/capybara.animation.json");
    }
}
