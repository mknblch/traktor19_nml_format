package de.mknblch.nml.common;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by mknblch on 25.09.2015.
 */
public class BackupToolsTest {

    @Test
    public void test() throws Exception {

        DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy_MM_dd_HH_mm");

        System.out.printf(DATE_FORMAT.format(new Date()));



    }
    
}