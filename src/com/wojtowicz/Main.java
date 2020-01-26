package com.wojtowicz;


import com.wojtowicz.controller.CompareFileMagicNumbers;
import com.wojtowicz.hex_values.HexValues;
import com.wojtowicz.shared.exception.IncorrectFormatException;

import java.io.FileNotFoundException;

import static com.wojtowicz.shared.constants.AppConst.*;

/**
 * @author Damian Wójtowicz
 * @project Epam_Magic_Number_Wójtowicz
 * @date 26.01.20
 */

/**
 * @class CompareFileMagicNumbers is responsible for final decision, if file format is correct
 *        If format is incorrect
 * @exception IncorrectFormatException is thrown
 *        If format is correct
 * @boolean true is returned
 * @firstParam please give your file name (location -> resources/files)
 * @secondParam please give according hex value of its file (what should be real file extension)
 *
 *
 * */
public class Main {

    public static void main(String[] args) throws IncorrectFormatException, FileNotFoundException {
	// write your code here

 // Comparing PDF to PDF - real pdf
/* CompareFileMagicNumbers COMPARE_PDF_TO_PDF = new CompareFileMagicNumbers();
        COMPARE_PDF_TO_PDF.checkIfGivenFileExtensionIsCorrect(RESUME_PDF, HexValues.DOC.hexValue);*/


    // Comparing PNG file, it is pretending to be GIF, check if it is maybe DOC
/*       CompareFileMagicNumbers COMPARE_NO_GIF_TO_GIF = new CompareFileMagicNumbers();
        COMPARE_NO_GIF_TO_GIF.checkIfGivenFileExtensionIsCorrect(NOT_GIF, HexValues.DOC.hexValue);*/


    // Comparing real PNG file to GIF file. I take assumption, that this file might be GIF file, but in fact it is PNG
            CompareFileMagicNumbers COMPARE_PNG_TO_PDF = new CompareFileMagicNumbers();
            COMPARE_PNG_TO_PDF.checkIfGivenFileExtensionIsCorrect(ANGULAR_PNG, HexValues.GIF.hexValue);



    }

}
