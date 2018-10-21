package com.mtxsoftware.model;

public enum WindDir {
    NW,
    N,
    NE,
    E,
    SE,
    S,
    SW,
    W,
    C;

    public static boolean findValue(String dir){
        String dirUpperCase = dir.toUpperCase();
        for (int i = 0; i < WindDir.values().length; i++) {
            if(WindDir.values()[i].toString().equals(dirUpperCase))
                return true;
        }
        return false;
    }
}
