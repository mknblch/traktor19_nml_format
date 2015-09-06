package de.mknblch.nml.commands;

import de.mknblch.objectdump.ObjectDump;
import de.mknblch.params.annotations.Command;
import de.mknblch.params.annotations.Parameter;

import javax.xml.bind.JAXBException;

/**
 * Created by mknblch on 05.09.2015.
 */
@Command(trigger = "dump", description = "Dump NML")
public class Dump extends ANMLCommand implements Runnable {

    @Parameter(trigger = "1")
    private String a;

    @Override
    public void run() {

        try {
            ObjectDump.dump(getNML());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
