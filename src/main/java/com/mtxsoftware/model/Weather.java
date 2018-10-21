
package com.mtxsoftware.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mtxsoftware.model.forecast.Forecast;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "now",
        "now_dt",
        "info",
        "fact",
        "forecasts"
})

//Получаемый в результате запроса объект
public class Weather {

    @JsonProperty("now")
    private long now;//Время сервера в формате Unixtime
    @JsonProperty("now_dt")
    private String nowDt;//Время сервера в UTC.
    @JsonProperty("info")
    private Info info;//Объект информации о населенном пункте.
    @JsonProperty("fact")
    private Fact fact;//Объект фактической информации о погоде.
    @JsonProperty("forecasts")
    private List<Forecast> forecasts = null;//Объект прогнозной информации о погоде.

    @JsonProperty("now")
    public long getNow() {
        return now;
    }

    @JsonProperty("now")
    public void setNow(long now) {
        this.now = now;
    }

    @JsonProperty("now_dt")
    public String getNowDt() {
        return nowDt;
    }

    @JsonProperty("now_dt")
    public void setNowDt(String nowDt) {
        this.nowDt = nowDt;
    }

    @JsonProperty("info")
    public Info getInfo() {
        return info;
    }

    @JsonProperty("info")
    public void setInfo(Info info) {
        this.info = info;
    }

    @JsonProperty("fact")
    public Fact getFact() {
        return fact;
    }

    @JsonProperty("fact")
    public void setFact(Fact fact) {
        this.fact = fact;
    }

    @JsonProperty("forecasts")
    public List<Forecast> getForecasts() {
        return forecasts;
    }

    @JsonProperty("forecasts")
    public void setForecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }
}
