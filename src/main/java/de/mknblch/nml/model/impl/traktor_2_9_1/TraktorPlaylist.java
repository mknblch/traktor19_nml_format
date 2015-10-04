package de.mknblch.nml.model.impl.traktor_2_9_1;

import de.mknblch.nml.entities.traktor_2_9_1.*;
import de.mknblch.nml.mediator.NMLHelper;
import de.mknblch.nml.model.Playlist;
import de.mknblch.nml.model.Track;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mknblch on 04.10.2015.
 */
public class TraktorPlaylist implements Playlist<Traktor> {

    private final NODE node;

    TraktorPlaylist(NODE node) {
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
    public List<Track<Traktor>> getTracks() {
        return node.getPLAYLIST().getENTRY().stream()
                .map(TraktorTrack::new)
                .collect(Collectors.toList());
    }

    @Override
    public void addTrack(Track<Traktor> track) {
        final ENTRY entry = new ENTRY();
        entry.getCONTENT().add(0, toPrimaryKey(track.getPath()));
        node.getPLAYLIST().getENTRY().add(entry);
        node.getPLAYLIST().setENTRIES(node.getPLAYLIST().getENTRY().size());
    }

    @Override
    public void removeTrack(Track<Traktor> track) {
        node.getPLAYLIST().getENTRY().removeIf(entry ->
                track.getPath().equals(NMLHelper.primaryKeyToPath(((PRIMARYKEY) entry.getCONTENT().get(0)).getKEY())));
    }

    @Override
    public void clear() {
        node.getPLAYLIST().getENTRY().clear();
        node.getPLAYLIST().setENTRIES(0);
    }

    @Override
    public void addAll(List<Track<Traktor>> tracks) {
        tracks.stream().forEach(this::addTrack);
    }

    private PRIMARYKEY toPrimaryKey(Path path) {
        final PRIMARYKEY primarykey = new PRIMARYKEY();
        primarykey.setTYPE("TRACK");
        primarykey.setKEY(NMLHelper.pathToPrimaryKey(path));
        return primarykey;
    }
}
