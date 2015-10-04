package de.mknblch.nml.common;

import de.mknblch.nml.model.Context;
import de.mknblch.nml.model.impl.traktor_2_9_1.Traktor291;

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
        put("2.9.1", Traktor291.class);
    }};

    private final TraktorPathFinder pathFinder;

    public ContextBuilder() {
        pathFinder = new TraktorPathFinder();
    }


    public Context build() throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        final String version = pathFinder.getHighestVersion();
        verifyVersion(version);
        final Class<?> contextClass = registry.get(version);
        final Path collectionPath = pathFinder.getCollectionPath(version);
        final Constructor<?> constructor = contextClass.getDeclaredConstructor(Path.class);
        final Object instance = constructor.newInstance(collectionPath);

        return null;
    }

    private void verifyVersion(String version) {
        if (!registry.containsKey(version)) {
            throw new IllegalArgumentException("Actual Traktor version [" + version + "] is not supported!");
        }
    }
}
