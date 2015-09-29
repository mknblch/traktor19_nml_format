package de.mknblch.nml.model;

/**
 * Created by mknblch on 29.09.2015.
 */
public interface Context {

    /**
     * @return mother program name e.g. Traktor / Scratch Live
     */
    String getName();

    /**
     * @return program version e.g. 2.10.0
     */
    String getVersion();
}
