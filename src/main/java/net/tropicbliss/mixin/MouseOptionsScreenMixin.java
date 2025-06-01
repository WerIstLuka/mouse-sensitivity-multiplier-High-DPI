package net.tropicbliss.mixin;

import net.minecraft.client.gui.screen.option.MouseOptionsScreen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import net.tropicbliss.options.OptionsManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mixin(MouseOptionsScreen.class)
public class MouseOptionsScreenMixin {
    @Inject(method = "getOptions", at = @At(value = "RETURN"), cancellable = true)
    private static void modifyOptions(GameOptions gameOptions, CallbackInfoReturnable<SimpleOption<?>[]> cir) {
        List<SimpleOption<?>> options = new ArrayList<>(Arrays.stream(cir.getReturnValue()).toList());
        options.add(1, OptionsManager.sensitivityScalingOption);
        cir.setReturnValue(options.toArray(new SimpleOption[0]));
    }
}
