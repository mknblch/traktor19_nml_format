package de.mknblch.nml.model;

import de.mknblch.nml.common.TraktorPathFinder;
import de.mknblch.nml.common.VersionExtractor;
import de.mknblch.nml.entities.traktor_19.NML;
import de.mknblch.nml.model.impl.traktor_19.Traktor19;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mknblch on 04.10.2015.
 */
public class ModelBuilder {

    private final Map<String, Class<?>> registry = new HashMap<String, Class<?>>() {{
        put("19", Traktor19.class);
    }};

    private final TraktorPathFinder pathFinder;

    public ModelBuilder() {
        pathFinder = new TraktorPathFinder();
    }

    /**
     * build from highest traktor version found
     */
    public Context build() throws ModelException {
        try {
            return build(pathFinder.getHighestVersion());
        } catch (IOException e) {
            throw new ModelException(e);
        }
    }

    /**
     * build specific version
     */
    public Context build(String version) throws ModelException {
        return build(pathFinder.getCollectionPath(pathFinder.getTraktorPath(version)));
    }

    /**
     * build from specified path
     */
    public Context build(Path pathToCollection) throws ModelException {
        try {
            final String nmlVersion = VersionExtractor.getCollectionVersion(pathToCollection);
            final Class<?> contextClass = getImplementation(nmlVersion);
            final Constructor<?> constructor = contextClass.getDeclaredConstructor(Path.class);
            return (Context) constructor.newInstance(pathToCollection);
        } catch (VersionExtractor.NoCollectionException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
            throw new ModelException("Error building Context.", e);
        }
    }

    private Class<?> getImplementation(String collectionVersion) {
        if (!registry.containsKey(collectionVersion)) {
            throw new IllegalArgumentException("Collection version [" + collectionVersion + "] is not supported!");
        }
        return registry.get(collectionVersion);
    }
}
