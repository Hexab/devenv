package gg.lark.devenv.feature;

import gg.lark.devenv.feature.impl.NoDamageFeature;
import gg.lark.devenv.feature.impl.NoHungerFeature;

import java.util.Arrays;
import java.util.List;

public abstract class Feature {

    public static List<Feature> features = Arrays.asList(new NoHungerFeature(), new NoDamageFeature());

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
