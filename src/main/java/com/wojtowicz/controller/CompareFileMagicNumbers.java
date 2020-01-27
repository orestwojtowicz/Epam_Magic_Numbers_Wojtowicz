package com.wojtowicz.controller;

import com.wojtowicz.controller.check_file_extension.CheckFileExtensionValues;
import com.wojtowicz.hex_values.HexValues;
import com.wojtowicz.shared.exception.IncorrectFormatException;
import com.wojtowicz.controller.read_hex_values.ReadHexFromFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Damian Wójtowicz
 * @project Epam_Magic_Numbers_Wójtowicz
 * @date 26.01.20
 */

public class CompareFileMagicNumbers extends ReadHexFromFile implements CheckFileExtensionValues {

    /**
     * Comparing two Strings from file and returning user friendly message
     *
     * @param hexValue         represents requested file hex values
     * @param defaultHexString hex values are read from enum
     * @throws IncorrectFormatException
     * @throws FileNotFoundException
     */

    @Override
    public void checkIfGivenFileExtensionIsCorrect(
            String hexValue, String defaultHexString) throws IncorrectFormatException, FileNotFoundException {

        boolean compareBothFilesDefaultHexValues =
                readHexValuesFromFile(hexValue).equals(readDefaultHexValuesFromEnum(defaultHexString));

        if (!compareBothFilesDefaultHexValues) {
            throw new IncorrectFormatException(
                    "\nFile has format " + convertRequestedFileToFileExtension(hexValue) + "\n" +
                            "Your requested file format is " + convertHexValueToFileExtension(defaultHexString));
        } else {
            System.out.println("Your file real extension is " +
                    convertRequestedFileToFileExtension(hexValue));
        }
    }

    /**
     * Helper method to make nice final message to user with file extensions
     * Removing [] from string, and comparing this value, based on method in enum class getEnumByName
     *
     * @param filePath for example it [89, 50, 4e, 47]
     * @return returning for example 89, 50, 4e, 47
     */
    private String convertRequestedFileToFileExtension(String filePath) throws FileNotFoundException {

        String hexValueFromFile = readHexValuesFromFile(filePath); //
        String removedString = hexValueFromFile.substring(1, hexValueFromFile.length() - 1);
        String getEnumName = HexValues.getEnumByName(removedString.toUpperCase());

        return getEnumName;
    }

    /**
     * Helper method for converting hex value to file extension.
     * When exception is thrown, method will be triggered
     *
     * @param hexValue takes hex value from file, this value is later for comparision
     * @return only file extension, read from enum
     */
    private String convertHexValueToFileExtension(String hexValue) {

        String returnFileExtension = "";

        for (HexValues hex : HexValues.values()) {
            if (hex.getHexValue().equals(hexValue)) {
                returnFileExtension = hex.toString();
            }
        }
        return HexValues.getEnumByName(returnFileExtension);
    }

    /**
     * method for reading hex values from file
     * assign first 4 values to String variable
     *
     * @param filePath
     * @return String hexValue
     * @throws FileNotFoundException
     */
    private String readHexValuesFromFile(String filePath) throws FileNotFoundException {

        File file = new File(filePath);
        List<String> hexValuesFromFile = new ArrayList<>();

        hexValuesFromFile.add(readHexValues(file).toString());
        String hexValue = "";
        if (file.exists() && hexValuesFromFile != null) {
            for (String hex : hexValuesFromFile) {
                hexValue = hex;
            }
        } else {
            throw new FileNotFoundException(
                    "Please check if file " + filePath + " is correct");
        }
        return hexValue.toLowerCase();
    }

    /**
     * method for reading default hex values from enum and put them into HashMap
     *
     * @param defaultHexValueFromEnum
     * @return defaultHexString
     */
    private String readDefaultHexValuesFromEnum(String defaultHexValueFromEnum) {

        Map<String, List<String>> defaultHexValues = new HashMap<>();
        List<String> hexDefaultListValues = new ArrayList<>();
        hexDefaultListValues.add(defaultHexValueFromEnum);
        defaultHexValues.putIfAbsent(defaultHexValueFromEnum, hexDefaultListValues);

        if (defaultHexValues == null && hexDefaultListValues == null) {
            throw new NullPointerException("Could not add enum values");
        }
        String defaultHexString = "";

        for (List<String> value : defaultHexValues.values()) {
            defaultHexString = String.valueOf(value);
        }
        return defaultHexString.toLowerCase();
    }

}
