package com.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.commands.Commands;
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
		CommandRegistrationCallback.EVENT.register((dispatcher,registryAccess,environment) ->dispatcher.register(
			Commands.literal("nv")
			.requires(source -> true)
			.executes(context ->{
				ServerPlayer player=context.getSource().getPlayer();
				if(player!=null){
					MobEffectInstance nv=new MobEffectInstance(MobEffects.NIGHT_VISION,12000,0,false,false);
					MobEffectInstance glow=new MobEffectInstance(MobEffects.GLOWING,12000,0,false,false);
					player.addEffect(nv);
					player.addEffect(glow);
					player.sendSystemMessage(Component.literal("你現在有夜視和發光效果了哦"));
				}
				return 1;
			})
		));

	}


	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}
}
