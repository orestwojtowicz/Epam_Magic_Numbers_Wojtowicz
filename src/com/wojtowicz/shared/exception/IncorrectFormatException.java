package com.wojtowicz.shared.exception;

/**
 * @author Damian Wójtowicz
 * @project Epam_Magic_Numbers_Wójtowicz
 * @date 26.01.20
 */

public class IncorrectFormatException extends Exception {


    /**
     * This exception is thrown, when file has wrong format.
     * It is pretending to be A, but it is B
     * */

    public IncorrectFormatException(String message) {
        super(message);
    }

}
