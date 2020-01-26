package com.wojtowicz;

import java.io.FileNotFoundException;

/**
 * @author Damian Wójtowicz
 * @project Epam_Magic_Numbers_Wójtowicz
 * @date 26.01.20
 */

public interface CheckFileExtensionValues {


    default void checkIfGivenFileExtensionIsCorrect(
            String hexValue, String defaultHexString) throws IncorrrectFormatException, FileNotFoundException {
    }
}
