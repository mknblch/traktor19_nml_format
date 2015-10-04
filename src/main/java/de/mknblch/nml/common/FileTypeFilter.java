package de.mknblch.nml.common;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mknblch on 13.09.2015.
 */
public class FileTypeFilter {

    public static final FileTypeFilter INSTANCE = new FileTypeFilter();

    private final List<String> supported = new ArrayList<String>() {{
        add(".mp3");
        add(".aif");
        add(".wav");
        add(".aiff");
        add(".m4a") ;
        add(".stem") ;
    }};

    public boolean isSupported(Path path) {
        final String p = path.getFileName().toString().toLowerCase();
        return supported.stream().anyMatch(p::endsWith);
    }
}
