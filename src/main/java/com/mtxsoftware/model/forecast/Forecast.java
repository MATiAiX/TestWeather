
package com.mtxsoftware.model.forecast;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mtxsoftware.model.forecast.parts.Hour;
import com.mtxsoftware.model.forecast.parts.Parts;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "date",
    "date_ts",
    "week",
    "sunrise",
    "sunset",
    "rise_begin",
    "set_end",
    "moon_code",
    "moon_text",
    "parts",
    "hours"
})
public class Forecast {

    @JsonProperty("date")
    private String date;//Дата прогноза в формате ГГГГ-ММ-ДД.
    @JsonProperty("date_ts")
    private int dateTs;//Дата прогноза в формате Unixtime.
    @JsonProperty("week")
    private int week;//Порядковый номер недели.
    @JsonProperty("sunrise")
    private String sunrise;//	Время восхода Солнца, локальное время (может отсутствовать для полярных регионов).
    @JsonProperty("sunset")
    private String sunset;//	Время заката Солнца, локальное время (может отсутствовать для полярных регионов).
    @JsonProperty("rise_begin")
    private String riseBegin;
    @JsonProperty("set_end")
    private String setEnd;
    @JsonProperty("moon_code")
    private int moonCode;//Код фазы Луны.
    @JsonProperty("moon_text")
    private String moonText;//Текстовый код для фазы Луны
    @JsonProperty("parts")
    private Parts parts;//Прогнозы по времени суток и 12-часовые прогнозы.
    @JsonProperty("hours")
    private List<Hour> hours = null;//Объект почасового прогноза погоды. Содержит 24 части

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("date_ts")
    public int getDateTs() {
        return dateTs;
    }

    @JsonProperty("date_ts")
    public void setDateTs(int dateTs) {
        this.dateTs = dateTs;
    }

    @JsonProperty("week")
    public int getWeek() {
        return week;
    }

    @JsonProperty("week")
    public void setWeek(int week) {
        this.week = week;
    }

    @JsonProperty("sunrise")
    public String getSunrise() {
        return sunrise;
    }

    @JsonProperty("sunrise")
    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    @JsonProperty("sunset")
    public String getSunset() {
        return sunset;
    }

    @JsonProperty("sunset")
    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    @JsonProperty("rise_begin")
    public String getRiseBegin() {
        return riseBegin;
    }

    @JsonProperty("rise_begin")
    public void setRiseBegin(String riseBegin) {
        this.riseBegin = riseBegin;
    }

    @JsonProperty("set_end")
    public String getSetEnd() {
        return setEnd;
    }

    @JsonProperty("set_end")
    public void setSetEnd(String setEnd) {
        this.setEnd = setEnd;
    }

    @JsonProperty("moon_code")
    public int getMoonCode() {
        return moonCode;
    }

    @JsonProperty("moon_code")
    public void setMoonCode(int moonCode) {
        this.moonCode = moonCode;
    }

    @JsonProperty("moon_text")
    public String getMoonText() {
        return moonText;
    }

    @JsonProperty("moon_text")
    public void setMoonText(String moonText) {
        this.moonText = moonText;
    }

    @JsonProperty("parts")
    public Parts getParts() {
        return parts;
    }

    @JsonProperty("parts")
    public void setParts(Parts parts) {
        this.parts = parts;
    }

    @JsonProperty("hours")
    public List<Hour> getHours() {
        return hours;
    }

    @JsonProperty("hours")
    public void setHours(List<Hour> hours) {
        this.hours = hours;
    }

}
