package de.mknblch.nml.common;

import de.mknblch.nml.entities.*;
import de.mknblch.objectdump.ObjectDumpBuilder;

/**
 * Created by mknblch on 02.09.2015.
 */
public class NMLDump {

    private static final ObjectDumpBuilder BUILDER = new ObjectDumpBuilder();

    static {
        BUILDER
                .addRecursive(NML.class)
                .addRecursive(HEAD.class)
                .addRecursive(COLLECTION.class)
                .addRecursive(SETS.class)
                .addRecursive(PLAYLISTS.class)
                .addRecursive(NODE.class)
                .addRecursive(SUBNODES.class)
                .addRecursive(PLAYLIST.class)
                .addRecursive(PRIMARYKEY.class)
                .addRecursive(LOCATION.class)
                .addRecursive(ALBUM.class)
                .addRecursive(CELL.class)
                .addRecursive(CUEV2.class)
                .addRecursive(ENTRY.class)
                .addRecursive(INFO.class)
                .addRecursive(LOOPINFO.class)
                .addRecursive(LOUDNESS.class)
                .addRecursive(MODIFICATIONINFO.class)
                .addRecursive(MUSICALKEY.class)
                .addRecursive(SET.class)
                .addRecursive(SLOT.class)
                .addRecursive(SORTINGDATA.class)
                .addRecursive(SORTINGORDER.class)
                .addRecursive(TEMPO.class);
    }

    public static void dump(Object nml) {
        assert null != nml;
        BUILDER.reset();
        BUILDER.dump(nml);
        System.out.println(BUILDER.toString());
    }

    public static String dump(NML nml, String xpath) {
        assert null != nml;
        BUILDER.reset();
        BUILDER.dump(nml);
        return BUILDER.toString();
    }
}
