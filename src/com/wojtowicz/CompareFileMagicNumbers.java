package com.wojtowicz;

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

public class CompareFileMagicNumbers extends ReadHexFromFile implements CheckFileExtensionValues{



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


    private String convertRequestedFileToFileExtension(String filePath) throws FileNotFoundException {

        String hexValueFromFile = readHexValuesFromFile(filePath); //example output [89, 50, 4e, 47]
        String removedString = hexValueFromFile.substring(1, hexValueFromFile.length()-1); //example output 89, 50, 4e, 47
        String getEnumName = HexValues.getEnumByName(removedString.toUpperCase());

        return getEnumName;
    }


    private String convertHexValueToFileExtension(String hexValue) {

        String returnFileExtension = "";

        for (HexValues hex : HexValues.values()) {
            if (hex.getHexValue().equals(hexValue)) {
                returnFileExtension = hex.toString();
            }
        }
        return HexValues.getEnumByName(returnFileExtension);
    }


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
