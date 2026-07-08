package com.example;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;


public class cat59487 extends Animal implements GeoEntity{
    public static final String MOD_ID="rich";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final EntityType<cat59487> CAT59487_ENTITY=Registry.register(
        BuiltInRegistries.ENTITY_TYPE,
        ResourceLocation.fromNamespaceAndPath(MOD_ID,"cat59487"),
        EntityType.Builder.of(cat59487::new,MobCategory.CREATURE)
        .sized(0.6f,0.7f)
        .build("cat59487")
    );

    public static AttributeSupplier.Builder createAttributes(){
        return Animal.createMobAttributes()
            .add(Attributes.MAX_HEALTH,20.0D)
            .add(Attributes.MOVEMENT_SPEED,0.25D);
    }

    public static void registerModEntities(){
        LOGGER.info("註冊生物中 "+MOD_ID);
        FabricDefaultAttributeRegistry.register(CAT59487_ENTITY, createAttributes());
    }
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public cat59487(EntityType<? extends Animal> entityType,Level level){
        super(entityType,level);
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.25D, itemStack -> this.isFood(itemStack), false));
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return CAT59487_ENTITY.create(serverLevel);
    }
     @Override
    public boolean isFood(ItemStack itemStack) {
        return itemStack.is(Items.ROTTEN_FLESH)
            || itemStack.is(Items.BONE_MEAL)
            || itemStack.is(Items.NETHERRACK)
            || itemStack.is(Items.CROSSBOW);
    }
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers){
        controllers.add(new AnimationController<>(this,"controller",5,event ->{
            if(event.isMoving()){
                return event.setAndContinue(RawAnimation.begin().thenLoop("walk"));
            }
                return event.setAndContinue(RawAnimation.begin().thenLoop("idle"));

        }));
    }
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache(){
        return this.cache;
    }
}