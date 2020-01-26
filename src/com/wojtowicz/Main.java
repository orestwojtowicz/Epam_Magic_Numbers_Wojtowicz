package com.wojtowicz;


import com.wojtowicz.controller.CompareFileMagicNumbers;
import com.wojtowicz.hex_values.HexValues;
import com.wojtowicz.shared.exception.IncorrectFormatException;

import java.io.FileNotFoundException;

import static com.wojtowicz.shared.constants.AppConst.RESUME_PDF;

/**
 * @author Damian Wójtowicz
 * @project Epam_Magic_Number_Wójtowicz
 * @date 26.01.20
 */

public class Main {

    public static void main(String[] args) throws IncorrectFormatException, FileNotFoundException {
	// write your code here

 // Comparing PDF to PDF
 CompareFileMagicNumbers COMPARE_PDF_TO_PDF = new CompareFileMagicNumbers();
        COMPARE_PDF_TO_PDF.checkIfGivenFileExtensionIsCorrect(RESUME_PDF, HexValues.PDF.hexValue);




    //  Comparing PDF to DOC
    CompareFileMagicNumbers COMPARE_PDF_TO_DOC = new CompareFileMagicNumbers();
        COMPARE_PDF_TO_DOC.checkIfGivenFileExtensionIsCorrect(RESUME_PDF, HexValues.DOC.hexValue);





    }

}
