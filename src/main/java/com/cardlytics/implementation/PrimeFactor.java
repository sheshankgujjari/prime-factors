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
import com.cardlytics.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor implements IPrimeFactor {

    /**
     * Calculate prime factor for the provided integer value
     * @param value
     * @return
     */
    public List<Integer> calculatePrimeFactors(int value) {
        int number = java.lang.Math.abs(value);
        List<Integer> primeFactors = new ArrayList<>();
        long copyOfInput = number;

        for (int i = 2; i <= copyOfInput; i++)
        {
            if (copyOfInput % i == 0)
            {
                primeFactors.add(i);
                copyOfInput /= i;
                i--;
            }
        }
        return primeFactors;
    }

    /**
     * Display the prime factors with comma separated
     * @param primeFactors
     * @param entry
     */
    public void displayCommaSeparatedPrimeFactors(List<Integer> primeFactors, int entry) {
        System.out.print(entry + ": ");
        if(primeFactors.size() == 0) {
            System.out.print(Constants.NoPrimeFactors);
        }
        String separator = "";
        for (Integer i:primeFactors) {
            System.out.print(separator + i);
            separator = ",";
        }
        System.out.println();
    }
}

