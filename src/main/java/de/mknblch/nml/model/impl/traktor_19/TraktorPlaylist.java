package de.mknblch.nml.model.impl.traktor_19;

import de.mknblch.nml.entities.traktor_19.*;
import de.mknblch.nml.model.Playlist;
import de.mknblch.nml.model.Track;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mknblch on 04.10.2015.
 */
public class TraktorPlaylist implements Playlist<Traktor19> {

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
    public List<Track<Traktor19>> getTracks() {
        return node.getPLAYLIST().getENTRY().stream()
                .map(TraktorTrack::new)
                .collect(Collectors.toList());
    }

    @Override
    public void addTrack(Track<Traktor19> track) {
        final ENTRY entry = new ENTRY();
        entry.getCONTENT().add(0, toPrimaryKey(track.getPath()));
        node.getPLAYLIST().getENTRY().add(entry);
        node.getPLAYLIST().setENTRIES(node.getPLAYLIST().getENTRY().size());
    }

    @Override
    public void removeTrack(Track<Traktor19> track) {
        node.getPLAYLIST().getENTRY().removeIf(entry ->
                track.getPath().equals(NMLHelper19.primaryKeyToPath(((PRIMARYKEY) entry.getCONTENT().get(0)).getKEY())));
    }

    @Override
    public void clear() {
        node.getPLAYLIST().getENTRY().clear();
        node.getPLAYLIST().setENTRIES(0);
    }

    @Override
    public void addTracks(List<Track<Traktor19>> tracks) {
        tracks.stream().forEach(this::addTrack);
    }

    private PRIMARYKEY toPrimaryKey(Path path) {
        final PRIMARYKEY primarykey = new PRIMARYKEY();
        primarykey.setTYPE("TRACK");
        primarykey.setKEY(NMLHelper19.pathToPrimaryKey(path));
        return primarykey;
    }
}
