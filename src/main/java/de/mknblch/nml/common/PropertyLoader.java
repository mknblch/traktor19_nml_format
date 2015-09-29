package de.mknblch.nml.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by mknblch on 20.09.2015.
 */
public class PropertyLoader {

    private final Properties properties;

    public PropertyLoader(Properties properties) {
        this.properties = properties;
    }

    public String get(String name) {
        return properties.getProperty(name);
    }

    public String get(String name, String def) {
        return properties.getProperty(name, def);
    }

    public static PropertyLoader init(String path) {
        final Properties properties = new Properties();
        final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        try(InputStream resourceStream = contextClassLoader.getResourceAsStream(path)) {
            properties.load(resourceStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new PropertyLoader(properties);
    }
}
