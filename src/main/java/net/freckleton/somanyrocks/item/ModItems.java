package net.freckleton.somanyrocks.item;

import net.freckleton.somanyrocks.SoManyRocks;
import net.freckleton.somanyrocks.sound.ModSounds;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
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
    public static final RegistryObject<Item> ROCK_SANDY = ITEMS.register("rock_sandy",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ROCK_BROWN_SPECKLED = ITEMS.register("rock_brown_speckled",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MUSIC_DISC_CHILL_ROCK_SUMMERTIME =
            ITEMS.register("music_disc_chill_rock_summertime", () -> new RecordItem(6, ModSounds.CHILL_ROCK_SUMMERTIME,
                    new Item.Properties().stacksTo(1), 3880));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
