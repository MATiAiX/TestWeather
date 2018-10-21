
package com.mtxsoftware.model.forecast.parts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "_source",
        "temp_min",
        "temp_max",
        "temp_avg",
        "feels_like",
        "icon",
        "condition",
        "daytime",
        "polar",
        "wind_speed",
        "wind_gust",
        "wind_dir",
        "pressure_mm",
        "pressure_pa",
        "humidity",
        "uv_index",
        "soil_temp",
        "soil_moisture",
        "prec_mm",
        "prec_period",
        "prec_prob",
        "prec_type",
        "prec_strength",
        "cloudness"
})
public abstract class Part extends PartShort {

    @JsonProperty("temp_max")
    private Integer tempMax;//Максимальная температура для времени суток (°C).
    @JsonProperty("temp_avg")
    private Integer tempAvg;//Средняя температура для времени суток (°C).
    @JsonProperty("daytime")
    private String daytime;//Светлое или темное время суток
    @JsonProperty("polar")
    private Boolean polar;//Признак полярного дня или ночи.
    @JsonProperty("prec_period")
    private Integer precPeriod;//Прогнозируемый период осадков (в минутах).

    @JsonProperty("temp_max")
    public Integer getTempMax() {
        return tempMax;
    }

    @JsonProperty("temp_max")
    public void setTempMax(Integer tempMax) {
        this.tempMax = tempMax;
    }

    @JsonProperty("temp_avg")
    public Integer getTempAvg() {
        return tempAvg;
    }

    @JsonProperty("temp_avg")
    public void setTempAvg(Integer tempAvg) {
        this.tempAvg = tempAvg;
    }


    @JsonProperty("daytime")
    public String getDaytime() {
        return daytime;
    }

    @JsonProperty("daytime")
    public void setDaytime(String daytime) {
        this.daytime = daytime;
    }

    @JsonProperty("polar")
    public Boolean isPolar() {
        return polar;
    }

    @JsonProperty("polar")
    public void setPolar(Boolean polar) {
        this.polar = polar;
    }

    @JsonProperty("prec_period")
    public Integer getPrecPeriod() {
        return precPeriod;
    }

    @JsonProperty("prec_period")
    public void setPrecPeriod(Integer precPeriod) {
        this.precPeriod = precPeriod;
    }

}
