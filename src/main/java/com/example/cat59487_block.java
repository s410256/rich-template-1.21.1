package com.example;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class cat59487_block {
    public static final String MOD_ID="rich";
    public static final Logger LOGGER= LoggerFactory.getLogger(MOD_ID);
    
    public static final Block CAT59487_BLOCK=Registry.register(
        BuiltInRegistries.BLOCK,
        ResourceLocation.fromNamespaceAndPath(MOD_ID,"cat59487_block"),
        new Block(BlockBehaviour.Properties.of().strength(1.0f).requiresCorrectToolForDrops())
    );

    public static final Item CAT59487_BLOCK_ITEM=Registry.register(
    BuiltInRegistries.ITEM,
    ResourceLocation.fromNamespaceAndPath(MOD_ID,"cat59487_block"),
    new BlockItem(CAT59487_BLOCK,new Item.Properties())
    );

    public static void registerBlocks(){
        LOGGER.info("註冊中 "+MOD_ID);
    };
};