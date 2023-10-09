package net.freckleton.somanyrocks.item;

import net.freckleton.somanyrocks.SoManyRocks;
import net.freckleton.somanyrocks.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SoManyRocks.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ROCKS_TAB = CREATIVE_MODE_TABS.register("rocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ROCK.get()))
                    .title(Component.translatable("creativetab.rocks_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.ROCK.get());
                        pOutput.accept(ModItems.ROCK_YOGURT.get());
                        pOutput.accept(ModItems.ROCK_BLOOD_BLUE_SPECKS.get());
                        pOutput.accept(ModItems.ROCK_OXIDIZED_GREEN.get());
                        pOutput.accept(ModItems.ROCK_OXIDIZED_RED.get());
                        pOutput.accept(ModItems.ROCK_SANDY.get());
                        pOutput.accept(ModItems.ROCK_BROWN_SPECKLED.get());

                        pOutput.accept(ModBlocks.BLOCK_OF_ROCK.get());

                        pOutput.accept(ModItems.MUSIC_DISC_CHILL_ROCK_SUMMERTIME.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
