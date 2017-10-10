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

import com.cardlytics.interfaces.IPrimeFactor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PrimeFactorTest {

    private IPrimeFactor primeFactor = new PrimeFactor();
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public  void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public   void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testValidNumber() {
        List<Integer> listOfPrimeFactor = primeFactor.calculatePrimeFactors(5);
        assertEquals(true, listOfPrimeFactor.contains(5));
    }

    @Test
    public void testPrimeFactorDisplay() {
        List<Integer> primeFactors = new ArrayList<>();
        primeFactors.add(5);
        primeFactor.displayCommaSeparatedPrimeFactors(primeFactors, 5);
        String s = outContent.toString();
        assertEquals("5: 5\n", outContent.toString());
    }

    @Test
    public void testInValidNumber() {
        List<Integer> listOfPrimeFactor = primeFactor.calculatePrimeFactors(1);
        assertEquals(false, listOfPrimeFactor.contains(1));
    }

}