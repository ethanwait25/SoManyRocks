package net.freckleton.somanyrocks.sound;

import net.freckleton.somanyrocks.SoManyRocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SoManyRocks.MOD_ID);

    public static final RegistryObject<SoundEvent> CHILL_ROCK_SUMMERTIME = registerSoundEvents("chill_rock_summertime");

//    Adding custom sounds (after making RegistryObject<SoundEvent> objects):
//    public static final ForgeSoundType SOME_BLOCK_OF_SOMETHING_SOUNDS = new ForgeSoundType(1f, 1f,
//            ModSounds.SOME_BLOCK_BREAK, ModSounds.SOME_BLOCK_STEP, etc.);

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name,
                () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SoManyRocks.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }

}
