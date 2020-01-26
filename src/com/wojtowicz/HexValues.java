package com.wojtowicz;

/**
 * @author Damian Wójtowicz
 * @project Epam_Magic_Numbers_Wójtowicz
 * @date 26.01.20
 */

public enum HexValues {


    PDF("25, 50, 44, 46"),
    JPEG("FF, D8, FF, D8"),
    PNG("89, 50, 4E, 47"),
    GIF("47, 49, 46, 38"),
    DOC("D0, CF, 11, E0"),
    XLSX("50, 4B, 07, 08"),
    ISO("43, 44, 30, 30");


    public final String hexValue;

    HexValues(String hexValue) {
        this.hexValue = hexValue;
    }

    public String getHexValue() {
        return hexValue;
    }


    public String toString() {
        return hexValue;
    }


    public static String getEnumByName(String code) {
        for(HexValues e : HexValues.values()){
            if(e.hexValue.equals(code)) return e.name();
        }
        return null;
    }


}
