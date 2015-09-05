package de.mknblch.nml.commands;

import de.mknblch.nml.entities.ENTRY;
import de.mknblch.nml.entities.NML;
import de.mknblch.nml.entities.NODE;
import de.mknblch.nml.entities.PLAYLIST;
import de.mknblch.params.annotations.Command;

import javax.xml.bind.JAXBException;
import java.util.List;

/**
 * Created by mknblch on 05.09.2015.
 */
@Command(trigger = {"listp", "listplaylist"}, description = "List playlists")
public class ListPlaylists extends ANMLCommand implements Runnable {

    @Override
    public void run() {

        final NML nml;
        try {
            nml = getNML();
            final NODE node = nml.getPLAYLISTS().getNODE();

            System.out.println(node.getNAME());
            final List<ENTRY> entries = node.getPLAYLIST().getENTRY();
            for (ENTRY entry : entries) {
                System.out.println(entry.getLOCATION().getFILE());

            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
