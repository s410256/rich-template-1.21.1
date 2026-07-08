package com.example.client;

import com.example.cat59487;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class cat59487_client {

    public static class Model extends GeoModel<cat59487> {
        @Override
        public ResourceLocation getModelResource(cat59487 animatable) {
            return ResourceLocation.fromNamespaceAndPath(cat59487.MOD_ID, "geo/cat59487.geo.json");
        }

        @Override
        public ResourceLocation getTextureResource(cat59487 animatable) {
            return ResourceLocation.fromNamespaceAndPath(cat59487.MOD_ID, "textures/entity/cat59487.png");
        }

        @Override
        public ResourceLocation getAnimationResource(cat59487 animatable) {
            return ResourceLocation.fromNamespaceAndPath(cat59487.MOD_ID, "animations/cat59487.animation.json");
        }
    }

    public static class Renderer extends GeoEntityRenderer<cat59487> {
        public Renderer(EntityRendererProvider.Context renderManager) {
            super(renderManager, new Model());
        }
    }
}