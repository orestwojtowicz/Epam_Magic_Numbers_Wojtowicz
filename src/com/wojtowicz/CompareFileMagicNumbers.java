package com.wojtowicz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Damian Wójtowicz
 * @project Epam_Magic_Numbers_Wójtowicz
 * @date 26.01.20
 */

public class CompareFileMagicNumbers extends ReadHexFromFile {





    public String readDefaultHexValuesFromEnum(String defaultHexValueFromEnum) {

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
