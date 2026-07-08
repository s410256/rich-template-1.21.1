package com.example.client;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import com.example.cat59487;

public class RichClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(
            cat59487.CAT59487_ENTITY, 
            cat59487_client.Renderer::new
        );
	}
}