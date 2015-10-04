package de.mknblch.nml.model.impl.traktor_2_9_1;

import de.mknblch.nml.entities.traktor_2_9_1.*;
import de.mknblch.nml.mediator.NMLHelper;
import de.mknblch.nml.model.Playlist;
import de.mknblch.nml.model.Playlists;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static de.mknblch.nml.mediator.NMLHelper.getPrimaryContent;

/**
 * Created by mknblch on 04.10.2015.
 */
public class TraktorPlaylists implements Playlists<Traktor> {

    private final PLAYLISTS playlists;

    public TraktorPlaylists(PLAYLISTS playlists) {
        this.playlists = playlists;
    }

    @Override
    public Playlist<Traktor> create(String playlistName) {
        final Playlist<Traktor> playlist = get(playlistName);
        if (null != playlist) {
            return playlist;
        }
        return createNewPlaylist(playlistName);
    }

    @Override
    public void remove(String playlistName) {
        final SUBNODES subnodes = playlists.getNODE().getSUBNODES();
        subnodes.getNODE().removeIf(node -> playlistName.equals(node.getNAME()));
        subnodes.setCOUNT(subnodes.getNODE().size());
    }

    @Override
    public void clear() {
        final SUBNODES subnodes = playlists.getNODE().getSUBNODES();
        subnodes.getNODE().clear();
        subnodes.setCOUNT(0);
    }

    @Override
    public Playlist<Traktor> get(String name) {
        final Optional<NODE> node = playlists.getNODE().getSUBNODES().getNODE().parallelStream()
                .filter(n -> name.equals(n.getNAME()))
                .findFirst();
        return node.isPresent() ? new TraktorPlaylist(node.get()) : null;
    }

    @Override
    public List<Playlist<Traktor>> list() {
        return playlists.getNODE().getSUBNODES().getNODE().stream()
                .map(TraktorPlaylist::new)
                .collect(Collectors.toList());
    }

    private Playlist<Traktor> createNewPlaylist(String playlistName) {
        final NODE root = playlists.getNODE();

        final PLAYLIST tPlaylist = new PLAYLIST();
        tPlaylist.setTYPE("LIST");
        tPlaylist.setUUID(NMLHelper.generateUUID());

        final NODE node = new NODE();
        node.setNAME(playlistName);
        node.setTYPE("PLAYLIST");
        node.setPLAYLIST(tPlaylist);

        final SUBNODES subnodes = root.getSUBNODES();
        subnodes.getNODE().add(node);
        subnodes.setCOUNT(subnodes.getNODE().size());

        return new TraktorPlaylist(node);
    }
}
