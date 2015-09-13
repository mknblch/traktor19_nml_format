package de.mknblch.nml.commands;

import de.mknblch.nml.common.NMLEditor;
import de.mknblch.nml.common.XMLSerializer;
import de.mknblch.nml.entities.NML;
import de.mknblch.params.annotations.Argument;
import de.mknblch.params.transformer.FileTransformer;
import org.apache.commons.jxpath.JXPathContext;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by mknblch on 13.09.2015.
 */
public class WithCollection {

    private NMLEditor editor = null;

    @Argument(trigger = {"-c", "--collection"}, transformer = FileTransformer.class, optional = true, description = "Path to collection.nml")
    protected Path collection = Paths.get("C:\\Users\\mk\\Documents\\Native Instruments\\Traktor 2.9.0\\collection.nml");

    public NML getNml() {
        return getEditor().getNml();
    }

    public NMLEditor getEditor() {
        if (null == editor) {
            init();
        }
        return editor;
    }

    public void init () {
        try {
            editor = new NMLEditor(collection);
        } catch (JAXBException e) {
            e.printStackTrace(); // TODO
            System.exit(1);
        }
    }
}
