package gg.lark.devenv.feature;

import gg.lark.devenv.feature.impl.*;

import java.util.Arrays;
import java.util.List;

public abstract class Feature {

    public static final List<Feature> features = Arrays.asList(new NoHungerFeature(), new NoDamageFeature(), new NoBreakFarmFeature(), new NoCreaturesFeature(), new NoRainFeature());

    public boolean enabled = true;

    /**
     * Enables the feature
     */
    abstract public void enable();

    /**
     * Disables the feature
     */
    abstract public void disable();

    /**
     * Gets the name of the feature
     *
     * @return the name
     */
    abstract public String getName();

}
