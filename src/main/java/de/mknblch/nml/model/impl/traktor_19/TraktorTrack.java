package de.mknblch.nml.model.impl.traktor_19;

import de.mknblch.nml.entities.traktor_19.ENTRY;
import de.mknblch.nml.entities.traktor_19.LOCATION;
import de.mknblch.nml.model.Track;

import java.nio.file.Path;
import java.util.Objects;

/**
 * Created by mknblch on 02.10.2015.
 */
public class TraktorTrack implements Track<Traktor19> {

    private final ENTRY entry;

    TraktorTrack(ENTRY entry) {
        this.entry = entry;
    }

    @Override
    public Path getPath() {
        return NMLHelper.locationToPath((LOCATION) entry.getCONTENT().get(0));
    }

    @Override
    public String getFileName() {
        return ((LOCATION) entry.getCONTENT().get(0)).getFILE();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TraktorTrack that = (TraktorTrack) o;

        return null != that.entry && this.entry == that.entry;

    }

    @Override
    public int hashCode() {
        return Objects.hash(getPath());
    }
}
