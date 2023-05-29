package net.averyworks.capybaramod.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.averyworks.capybaramod.CapybaraMod;
import net.averyworks.capybaramod.entity.custom.CapybaraEntity;
import net.averyworks.capybaramod.entity.variant.CapybaraVariants;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;

public class CapybaraRenderer extends GeoEntityRenderer<CapybaraEntity> {

    public static final Map<CapybaraVariants, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(CapybaraVariants.class),(p_114874_) -> {
                p_114874_.put(CapybaraVariants.DEFAULT,
                        new ResourceLocation(CapybaraMod.MOD_ID, "textures/entity/capybara/capybara.png"));
                p_114874_.put(CapybaraVariants.DARKER,
                        new ResourceLocation(CapybaraMod.MOD_ID, "textures/entity/capybara/capybara_dark_coat.png"));
                p_114874_.put(CapybaraVariants.WHITE,
                        new ResourceLocation(CapybaraMod.MOD_ID, "textures/entity/capybara/capybara_whitish_coat.png"));
            });
    public CapybaraRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CapybaraModel());
        this.shadowRadius=0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(CapybaraEntity instance) {

        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }



    @Override
    public RenderType getRenderType(CapybaraEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        if (animatable.isBaby()){
            stack.scale(0.5f,0.5f,0.5f);
        }else{
            stack.scale(0.8F, 0.8F, 0.8F);
        }



        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
