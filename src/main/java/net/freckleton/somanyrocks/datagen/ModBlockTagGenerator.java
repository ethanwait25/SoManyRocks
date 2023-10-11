package net.freckleton.somanyrocks.datagen;

import net.freckleton.somanyrocks.SoManyRocks;
import net.freckleton.somanyrocks.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SoManyRocks.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
//        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
//                .add(ModBlocks.SAPPHIRE_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GEOMORPHITE_ORE.get()

                );

//        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
//                .add(SOMETHING)

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BLOCK_OF_ROCK.get(),
                        ModBlocks.BLOCK_OF_ROCK_OXIDIZED_GREEN.get(),
                        ModBlocks.GEOMORPHITE_ORE.get()
                );
    }

}