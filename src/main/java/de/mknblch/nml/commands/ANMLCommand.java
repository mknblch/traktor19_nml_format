package de.mknblch.nml.commands;

import de.mknblch.nml.common.XMLSerializer;
import de.mknblch.nml.entities.NML;
import de.mknblch.params.annotations.Argument;

import javax.xml.bind.JAXBException;
import java.io.File;

public class ANMLCommand {

    @Argument(trigger = "-f", description = "File path")
    private String path;

    protected NML getNML() throws JAXBException {
        return new XMLSerializer<>(NML.class).unmarshal(new File(path));
    }
}