package com.example;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.ResourceLocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rich implements ModInitializer {
	public static final String MOD_ID = "rich";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("反正模組是啟動了啦");
		ServerPlayConnectionEvents.JOIN.register((handler,sender,server) ->{
			var player=handler.getPlayer();
			player.sendSystemMessage(Component.literal("你說李竣翔到底啥時候才去告白阿"));
		});
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}
}
