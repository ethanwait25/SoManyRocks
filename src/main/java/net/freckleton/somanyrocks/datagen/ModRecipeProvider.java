package net.freckleton.somanyrocks.datagen;

import net.freckleton.somanyrocks.SoManyRocks;
import net.freckleton.somanyrocks.block.ModBlocks;
import net.freckleton.somanyrocks.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        rockBlockFromRock(ModBlocks.BLOCK_OF_ROCK, ModItems.ROCK, pWriter);
        rockBlockFromRock(ModBlocks.BLOCK_OF_ROCK_OXIDIZED_GREEN, ModItems.ROCK_OXIDIZED_GREEN, pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MUSIC_DISC_CHILL_ROCK_SUMMERTIME.get())
                .pattern("###")
                .pattern("#D#")
                .pattern("###")
                .define('#', ModItems.ROCK.get())
                .define('D', ItemTags.MUSIC_DISCS)
                .unlockedBy(getHasName(ModItems.ROCK.get()), has(ModItems.ROCK.get()))
                .save(pWriter);

//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SoManyRocks.SOME_ITEM.get(), 9)
//                .requires(ModBlocks.SOME_BLOCK.get())
//                .unlockedBy(getHasName(ModBlocks.SOME_BLOCK.get()), has(ModBlocks.ROCK.get()))
//                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, SoManyRocks.MOD_ID + ":" +
                            getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }

    private static void rockBlockFromRock(RegistryObject<Block> block, RegistryObject<Item> item, Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, block.get())
                .pattern("##")
                .pattern("##")
                .define('#', item.get())
                .unlockedBy(getHasName(item.get()), has(item.get()))
                .save(pWriter);
    }

}
