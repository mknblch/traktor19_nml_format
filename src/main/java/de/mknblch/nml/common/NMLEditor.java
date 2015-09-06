package de.mknblch.nml.common;

import de.mknblch.nml.entities.NML;
import de.mknblch.nml.entities.NODE;
import de.mknblch.nml.entities.PLAYLIST;
import de.mknblch.nml.entities.PRIMARYKEY;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.Pointer;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mknblch on 05.09.2015.
 */
public class NMLEditor {

    public static final String ROOT = "$ROOT";

    private final NML nml;
    private final JXPathContext context;

    public NMLEditor(NML nml) {
        this.nml = nml;
        context = JXPathContext.newContext(nml);
    }

    public NML getNml() {
        return nml;
    }

    public void addPlaylistNode(NODE node) {
        getPlaylistNode(ROOT).getSUBNODES().getNODE().add(node);
    }

    public NODE getPlaylistNode(String name) {
        context.getVariables().declareVariable("PLNAME", name);
        return (NODE) context.selectSingleNode("/PLAYLISTS//NODE[@NAME=$PLNAME]");
    }

    public void removePlayListNode(String name) {
        context.getVariables().declareVariable("PLNAME", name);
        context.removePath("/PLAYLISTS//NODE[@NAME=$PLNAME]");
    }

    public List<Path> getPlaylistFiles(String name) {

        context.getVariables().declareVariable("PLNAME", name);
        return selectMany("/PLAYLISTS//NODE[@NAME=$PLNAME]//content/PRIMARYKEY", PRIMARYKEY.class)
                .stream()
                .map(PRIMARYKEY::getKEY)
                .map(NMLHelper::getFilePath)
                .collect(Collectors.toList());
    }

    private <T> List<T> selectMany(String xpath, Class<T> clazz) {
        final ArrayList<T> list = new ArrayList<>();
        for (Iterator<Pointer> i = context.iteratePointers(xpath); i.hasNext(); ) {
            list.add((T) i.next().getNode());
        }
        return list;
    }
}
