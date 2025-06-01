package net.tropicbliss.options;

import com.mojang.serialization.Codec;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;

public class OptionsManager {
    public static SimpleOption<Double> sensitivityScalingOption = new SimpleOption<>("options.mouse.sensitivity.multiplier", SimpleOption.emptyTooltip(),
            GameOptions::getPercentValueText, (new SimpleOption.ValidatingIntSliderCallbacks(0, 8)).withModifier((sliderProgressValue) -> (double)sliderProgressValue / (double)4.0F, (value) -> (int)(value * (double)4.0F)), Codec.doubleRange(
            0.0F, 2.0F), (double)1.0F, (value) -> {
    });
}
