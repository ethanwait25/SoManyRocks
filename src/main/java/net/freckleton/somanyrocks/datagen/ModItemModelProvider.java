package net.freckleton.somanyrocks.datagen;

import net.freckleton.somanyrocks.SoManyRocks;
import net.freckleton.somanyrocks.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SoManyRocks.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ROCK);
        simpleItem(ModItems.ROCK_YOGURT);
        simpleItem(ModItems.ROCK_BLOOD_BLUE_SPECKS);
        simpleItem(ModItems.ROCK_OXIDIZED_GREEN);
        simpleItem(ModItems.ROCK_OXIDIZED_RED);
        simpleItem(ModItems.ROCK_SANDY);
        simpleItem(ModItems.ROCK_BROWN_SPECKLED);
        simpleItem(ModItems.GEOMORPHITE);

        simpleItem(ModItems.MUSIC_DISC_CHILL_ROCK_SUMMERTIME);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SoManyRocks.MOD_ID, "item/" + item.getId().getPath()));
    }

}
