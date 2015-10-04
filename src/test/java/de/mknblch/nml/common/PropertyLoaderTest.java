package de.mknblch.nml.common;

import org.junit.Test;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Created by mknblch on 04.10.2015.
 */
public class PropertyLoaderTest {

    @Test
    public void test1() throws Exception {

        dump(test("a sfd sdf;; 2"));
    }

    private void dump(List<String> test) {
        for (String s : test) {
            System.out.println("'" + s + "'");
        }
    }

    private List<String> test(String in) {
        if (null == in) {
            return null;
        }
        return Stream.of(in.split("(;\\s*)"))
                .filter(Objects::nonNull)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }
    
}