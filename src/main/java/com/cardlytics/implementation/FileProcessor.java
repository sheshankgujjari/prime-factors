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

import com.cardlytics.interfaces.IFileProcessor;
import com.cardlytics.interfaces.IPrimeFactor;
import com.cardlytics.util.Constants;

import java.io.*;

public class FileProcessor implements IFileProcessor {

    /**
     * Method to input file
     * @param inputFileName
     */
    public void processInputFile(String inputFileName) {
        FileReader fileReader = null;
        try {
            File file = new File(inputFileName);
            fileReader = new java.io.FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                int entry;
                try {
                    entry = Integer.parseInt(line);
                } catch (NumberFormatException ex) {
                    System.out.println(line + Constants.InvalidFormat);
                    continue;
                }
                IPrimeFactor calc = new PrimeFactor();
                calc.displayCommaSeparatedPrimeFactors(calc.calculatePrimeFactors(entry), entry);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(Constants.FileNotFound);
        } catch (IOException ex) {
            System.out.println(Constants.IoException);
        } finally {
            if (fileReader != null)
                try {
                    fileReader.close();
                } catch (IOException ex) {
                    System.out.println(Constants.IoException);
                }
        }
    }
}

