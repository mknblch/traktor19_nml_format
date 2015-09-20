package de.mknblch.nml;

import de.mknblch.nml.commands.*;
import de.mknblch.params.Params;

import javax.xml.bind.JAXBException;

/**
 * Created by mknblch on 01.09.2015.
 */
public class Launcher {

    public static void main(String[] args) throws JAXBException {

        new Params()
                .setDescription("Traktor Collection Editor")
                .add(BackupCreate.class)
                .add(BackupList.class)
                .add(BackupRevert.class)
                .add(Clear.class)
                .add(CollectionImport.class)
                .add(CollectionList.class)
                .add(Debug.class)
                .add(PlaylistImport.class)
                .add(PlaylistList.class)
                .add(PlaylistDiff.class)
                .add(PlaylistDiffAll.class)
                .add(PlaylistSync.class)
                .add(PlaylistSyncAll.class)
                .runOrDie(args);
    }
}
