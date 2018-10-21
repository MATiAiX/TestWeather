package com.mtxsoftware.model;

public enum Condition {
    /*
    condition	Код расшифровки погодного описания. Возможные значения:
clear — ясно.
partly-cloudy — малооблачно.
cloudy — облачно с прояснениями.
overcast — пасмурно.
partly-cloudy-and-light-rain — небольшой дождь.
partly-cloudy-and-rain — дождь.
overcast-and-rain — сильный дождь.
overcast-thunderstorms-with-rain — сильный дождь, гроза.
cloudy-and-light-rain — небольшой дождь.
overcast-and-light-rain — небольшой дождь.
cloudy-and-rain — дождь.
overcast-and-wet-snow — дождь со снегом.
partly-cloudy-and-light-snow — небольшой снег.
partly-cloudy-and-snow — снег.
overcast-and-snow — снегопад.
cloudy-and-light-snow — небольшой снег.
overcast-and-light-snow — небольшой снег.
cloudy-and-snow — снег.
    * */
    CLEAR("clear"),
    PARTLY_CLOUDY("partly-cloudy"),
    CLOUDY("cloudy"),
    OVERCAST("overcast"),
    PARTLY_CLOUDY_AND_LIGHT_RAIN("partly-cloudy-and-light-rain"),
    PARTLY_CLOUDY_AND_RAIN("partly-cloudy-and-rain"),
    OVERCAST_AND_RAIN("overcast-and-rain"),
    OVERCAST_THUNDERSTORMS_WITH_RAIN("overcast-thunderstorms-with-rain"),
    CLOUDY_AND_LIGHT_RAIN("cloudy-and-light-rain"),
    OVERCAST_AND_LIGHT_RAIN("overcast-and-light-rain"),
    CLOUDY_AND_RAIN("cloudy-and-rain"),
    OVERCAST_AND_WET_SNOW("overcast-and-wet-snow"),
    PARTLY_CLOUDY_AND_LIGHT_SNOW("partly-cloudy-and-light-snow"),
    PARTLY_CLOUDY_AND_SNOW("partly-cloudy-and-snow"),
    OVERCAST_AND_SNOW("overcast-and-snow"),
    CLOUDY_AND_LIGHT_SNOW("cloudy-and-light-snow"),
    OVERCAST_AND_LIGHT_SNOW("overcast-and-light-snow"),
    CLOUDY_AND_SNOW("cloudy-and-snow");



    private final String name;

    //конструктор для создания пар именование-значение
    Condition(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }


    //из-за именования в ответе на GET пришлось добавлять отдельный метод для поиска значения в перечислении
    public static boolean findValue(String value){
        for(Condition current: Condition.values()){
            if(current.getName().equalsIgnoreCase(value)){
                return true;
            }
        }
        return false;
    }
}
