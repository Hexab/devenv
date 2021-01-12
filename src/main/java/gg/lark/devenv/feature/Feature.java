package gg.lark.devenv.feature;

public abstract class Feature {

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
