/******************************************************************************
 * Copyright (c) 2017 Cardlytics. All rights reserved.                        *
 *                                                                            *
 * The computer software herein is the property of Cardlytics. The            *
 * software may be used and/or copied only with the written permission of     *
 * Cardlytics or in accordance with the terms and conditions                  *
 * stipulated in the agreement/contract under which the software has been     *
 * supplied.                                                                  *
 ******************************************************************************/

package com.cardlytics.implementation;

import com.cardlytics.util.Constants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class FileProcessorTest {


    private FileProcessor fileProcessor = new FileProcessor();
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public  void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testLargeNumber() {
        String testFileName = "BigInt.txt";

        String[] arrayToAdd = {"2222222222222222222222222222222"};
        createFile(testFileName, arrayToAdd);

        fileProcessor.processInputFile(testFileName);
        String value = outContent.toString();

        assertEquals(": It is not an integer, please provide a valid integer" , Constants.InvalidFormat);

        deleteFile(testFileName);
    }

    @Test
    public void testNonNumber() {
        String testFileName = "NotInteger.txt";

        String[] arrayToAdd = {"45g567"};
        createFile(testFileName, arrayToAdd);

        fileProcessor.processInputFile(testFileName);
        String value = outContent.toString();

        assertEquals(": It is not an integer, please provide a valid integer" , Constants.InvalidFormat);

        deleteFile(testFileName);
    }

    @Test
    public void testNotPrimeNumber() {
        String testFileName = "NonPrimeNumber.txt";

        String[] arrayToAdd = {"0"};
        createFile(testFileName, arrayToAdd);

        fileProcessor.processInputFile(testFileName);

        assertEquals(": It is not an integer, please provide a valid integer" , Constants.InvalidFormat);

        deleteFile(testFileName);
    }

    @Test
    public void testFloatingNumber() {
        String testFileName = "FloatingNumber.txt";

        String[] arrayToAdd = {"45.67"};
        createFile(testFileName, arrayToAdd);

        fileProcessor.processInputFile(testFileName);
        String value = outContent.toString();

        assertEquals(": It is not an integer, please provide a valid integer"  , Constants.InvalidFormat);

        deleteFile(testFileName);
    }

    @Test
    public void testMultipleNumbers() {
        String testFileName =  "MultipleNumbers.txt";

        String[] arrayToAdd = {"65 123 76"};
        createFile(testFileName, arrayToAdd);

        fileProcessor.processInputFile(testFileName);
        String value = outContent.toString();

        assertEquals(": It is not an integer, please provide a valid integer" , Constants.InvalidFormat);

        deleteFile(testFileName);
    }

    @Test
    public void testValidFile() {
        String testFileName = "ValidFile.txt";

        String[] arrayToAdd = {"17", "24"};
        createFile(testFileName, arrayToAdd);

        fileProcessor.processInputFile(testFileName);
        String value = outContent.toString();

        assertEquals("17: 17\n24: 2,2,2,3\n",  value);

        deleteFile(testFileName);
    }

    @Test
    public void testWithSignValueInFile() {
        String testFileName = "SignValue.txt";

        String[] arrayToAdd = {"-32", "+34"};
        createFile(testFileName, arrayToAdd);

        fileProcessor.processInputFile(testFileName);

        assertEquals("-32: 2,2,2,2,2\n34: 2,17\n", "-32: 2,2,2,2,2\n34: 2,17\n");

        deleteFile(testFileName);
    }

    private void deleteFile(String fileName) {
        File file = new File(fileName);
        file.delete();
    }

    private void createFile(String testFileName, String[] arrayOfString) {
        try {
            PrintWriter writer = new PrintWriter(testFileName);
            for (String s: arrayOfString) {
                writer.println(s);
            }
            writer.close();
        } catch (Exception ex) {
            System.out.println("Error while creating a file: " + ex);
            return;
        }
    }

}