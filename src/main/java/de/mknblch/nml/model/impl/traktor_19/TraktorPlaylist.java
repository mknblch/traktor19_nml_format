package de.mknblch.nml.model.impl.traktor_19;

import de.mknblch.nml.entities.traktor_19.*;
import de.mknblch.nml.model.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by mknblch on 04.10.2015.
 */
public class TraktorPlaylist implements Playlist {

    private final NODE node;

    private final Context context;

    TraktorPlaylist(Context context, NODE node) {
        this.context = context;
        this.node = node;
    }

    @Override
    public String getName() {
        return node.getNAME();
    }

    @Override
    public void setName(String name) {
        node.setNAME(name);
    }

    @Override
    public List<Track> getTracks() {

        final Library library = context.getLibrary();

        return node.getPLAYLIST().getENTRY().stream()
                .map(NMLHelper19::getTraktorKey)
                .map(library::getTrackById)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public void addTrack(Track track) {
        if (null == track) {
            return;
        }
        final ENTRY entry = new ENTRY();
        entry.getCONTENT().add(0, toPrimaryKey(track.getPath()));
        node.getPLAYLIST().getENTRY().add(entry);
        node.getPLAYLIST().setENTRIES(node.getPLAYLIST().getENTRY().size());
    }

    @Override
    public void removeTrack(Track track) {
        if (null == track) {
            return;
        }
        node.getPLAYLIST()
                .getENTRY()
                .removeIf(entry -> track.getTrackId().equals(NMLHelper19.getTraktorKey(entry)));
    }

    @Override
    public void clear() {
        node.getPLAYLIST().getENTRY().clear();
        node.getPLAYLIST().setENTRIES(0);
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public void addTracks(List<Track> tracks) {
        tracks.stream().forEach(this::addTrack);
    }

    private PRIMARYKEY toPrimaryKey(Path path) {
        final PRIMARYKEY primarykey = new PRIMARYKEY();
        primarykey.setTYPE("TRACK");
        primarykey.setKEY(NMLHelper19.pathToTraktorKey(path));
        return primarykey;
    }
}
