package com.mtxsoftware.model;

public enum Season {
    SUMMER,
    AUTUMN,
    WINTER,
    SPRING;

    public static boolean findValue(String season){
        String seasonUpperCase = season.toUpperCase();
        for (int i = 0; i < Season.values().length; i++) {
            if(Season.values()[i].toString().equals(seasonUpperCase))
                return true;
        }
        return false;
    }
}


