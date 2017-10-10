/******************************************************************************
 * Copyright (c) 2017 Cardlytics. All rights reserved.                        *
 *                                                                            *
 * The computer software herein is the property of Cardlytics. The            *
 * software may be used and/or copied only with the written permission of     *
 * Cardlytics or in accordance with the terms and conditions                  *
 * stipulated in the agreement/contract under which the software has been     *
 * supplied.                                                                  *
 ******************************************************************************/

package com.cardlytics;

import com.cardlytics.implementation.FileProcessor;
import com.cardlytics.interfaces.IFileProcessor;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1)
        {
            System.out.println("Please provide a valid input file to proceed further");
            System.exit(1);
        }
        IFileProcessor helper = new FileProcessor();
        helper.processInputFile(args[0]);
    }
}

