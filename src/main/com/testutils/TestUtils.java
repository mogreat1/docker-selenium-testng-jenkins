package com.testutils;

import org.testng.Assert;

import java.io.File;

public class TestUtils {

    public void deleteOutputFile(String file) {
        File output = new File(file);
        Assert.assertTrue(output.delete());
        System.out.println(file + " deleted successfully");
    }
}
