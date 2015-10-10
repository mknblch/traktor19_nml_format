package de.mknblch.nml.common;

import de.mknblch.nml.model.Context;
import de.mknblch.nml.model.impl.traktor_19.Traktor19;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mknblch on 04.10.2015.
 */
public class ContextBuilder {

    private final Map<String, Class<?>> registry = new HashMap<String, Class<?>>() {{
        put("19", Traktor19.class);
    }};

    private final TraktorPathFinder pathFinder;

    public ContextBuilder() {
        pathFinder = new TraktorPathFinder();
    }

    public Context build() throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, VersionExtractor.NoCollectionException {
        final String version = pathFinder.getHighestVersion();
        final Path collectionPath = pathFinder.getCollectionPath(version);
        final String collectionVersion = VersionExtractor.getCollectionVersion(collectionPath);
        if (!registry.containsKey(version)) {
            throw new IllegalArgumentException("Actual Traktor version [" + version + "] is not supported!");
        }
        final Class<?> contextClass = registry.get(collectionVersion);
        final Constructor<?> constructor = contextClass.getDeclaredConstructor(Path.class);
        return (Context) constructor.newInstance(collectionPath);
    }
}
