package net.freckleton.somanyrocks.block;

import net.freckleton.somanyrocks.SoManyRocks;
import net.freckleton.somanyrocks.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.rmi.registry.Registry;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SoManyRocks.MOD_ID);

    public static final RegistryObject<Block> BLOCK_OF_ROCK = registerBlock("block_of_rock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> BLOCK_OF_ROCK_OXIDIZED_GREEN = registerBlock("block_of_rock_oxidized_green",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> GEOMORPHITE_ORE = registerBlock("geomorphite_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COAL_ORE)));


    //Block without loot table:     (with .noLootTable() method)
//    public static final RegistryObject<Block> ffff = registerBlock("block_of_rock",
//                () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).noLootTable()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
