package net.freckleton.somanyrocks.item;

import net.freckleton.somanyrocks.SoManyRocks;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SoManyRocks.MOD_ID);

    public static final RegistryObject<Item> ROCK = ITEMS.register("rock",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ROCK_YOGURT = ITEMS.register("rock_yogurt",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ROCK_BLOOD_BLUE_SPECKS = ITEMS.register("rock_blood_blue_specks",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ROCK_OXIDIZED_GREEN = ITEMS.register("rock_oxidized_green",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ROCK_OXIDIZED_RED = ITEMS.register("rock_oxidized_red",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
