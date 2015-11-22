package de.mknblch.nml.model.impl.traktor_19;

import de.mknblch.nml.entities.traktor_19.ENTRY;
import de.mknblch.nml.entities.traktor_19.INFO;
import de.mknblch.nml.model.Track;

import java.nio.file.Path;
import java.text.ParseException;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by mknblch on 02.10.2015.
 */
public class TraktorTrack implements Track {

    private final ENTRY entry;

    TraktorTrack(ENTRY entry) {
        this.entry = entry;
    }

    @Override
    public Path getPath() {
        return NMLHelper19.getPath(entry);
    }

    @Override
    public String getFileName() {
        return getPath().getFileName().toString();
    }

    @Override
    public String getTitle() {
        return entry.getTITLE();
    }

    private Optional<INFO> getInfo() {
        return entry
                    .getCONTENT()
                    .parallelStream()
                    .filter(o -> o instanceof INFO)
                    .map(o -> (INFO) o)
                    .findFirst();
    }

    @Override
    public String getArtist() {
        return entry.getARTIST();
    }

    @Override
    public Integer getBitrate() {
        final Optional<INFO> opt = getInfo();
        if (!opt.isPresent()) {
            return null;
        }
        return opt.get().getBITRATE();
    }

    @Override
    public String getComment() {
        final Optional<INFO> opt = getInfo();
        if (!opt.isPresent()) {
            return null;
        }
        return opt.get().getCOMMENT();
    }

    @Override
    public Date getImportDate() {
        final Optional<INFO> opt = getInfo();
        if (!opt.isPresent()) {
            return null;
        }
        try {
            return NMLHelper19.DATE_FORMAT.parse(opt.get().getIMPORTDATE());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Date getLastPlayed() {
        final Optional<INFO> opt = getInfo();
        if (!opt.isPresent()) {
            return null;
        }
        try {
            return NMLHelper19.DATE_FORMAT.parse(opt.get().getLASTPLAYED());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getKey() {
        final Optional<INFO> opt = getInfo();
        if (!opt.isPresent()) {
            return null;
        }
        return opt.get().getKEY();
    }

    @Override
    public boolean isAnalyzed() {
        return getAudioID() != null;
    }

    @Override
    public String getAudioID() {
        return entry.getAUDIOID();
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

    @Override
    public String toString() {

        final StringBuilder builder = new StringBuilder();
        builder.append(getFileName());
        if (!isAnalyzed()) {
            return builder.toString();
        }
        builder.append(" ")
                .append(getArtist()).append(" : ")
                .append(getTitle()).append(" ");

        final Integer bitrate = getBitrate();
        final String key = getKey();
        if (null == key && null == bitrate) {
            return builder.toString();
        }

        builder.append("[");
        if (null != bitrate) {
            builder.append(bitrate / 1000)
                    .append("kbs");
        }
        if (null != key) {
            if (null != bitrate) {
                builder.append(" ");
            }
            builder.append("Key: ")
                    .append(key);
        }
        builder.append("]");
        return builder.toString();
    }
}
