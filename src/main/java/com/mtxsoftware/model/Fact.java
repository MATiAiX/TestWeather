
package com.mtxsoftware.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "temp",
    "feels_like",
    "icon",
    "condition",
    "wind_speed",
    "wind_gust",
    "wind_dir",
    "pressure_mm",
    "pressure_pa",
    "humidity",
    "uv_index",
    "soil_temp",
    "soil_moisture",
    "daytime",
    "polar",
    "season",
    "obs_time",
    "source",
    "prec_type",
    "prec_strength",
    "cloudness"
})

//Объект фактической информации о погоде.
public class Fact {
    /*
    "accum_prec": {
    1: 0,
    3: 0,
    7: 47.8
    },
     */
    @JsonProperty("temp")
    private Integer temp;//Температура (°C).
    @JsonProperty("feels_like")
    private int feelsLike;//Ощущаемая температура (°C).
    @JsonProperty("icon")
    private String icon;//Код иконки погоды. Иконка доступна по адресу https://yastatic.net/weather/i/icons/blueye/color/svg/<значение из поля icon>.svg.
    @JsonProperty("condition")
    private String condition;//Код расшифровки погодного описания
    @JsonProperty("wind_speed")
    private double windSpeed;//Скорость ветра (в м/с).
    @JsonProperty("wind_gust")
    private double windGust;//	Скорость порывов ветра (в м/с).
    @JsonProperty("wind_dir")
    private String windDir;//Направление ветра.
    @JsonProperty("pressure_mm")
    private int pressureMm;//Давление (в мм рт. ст.).
    @JsonProperty("pressure_pa")
    private int pressurePa;//Давление (в гектопаскалях).
    @JsonProperty("humidity")
    private int humidity;//	Влажность воздуха (в процентах).
    @JsonProperty("uv_index")
    private int uvIndex;
    @JsonProperty("soil_temp")
    private int soilTemp;
    @JsonProperty("soil_moisture")
    private double soilMoisture;
    @JsonProperty("daytime")
    private String daytime;
    @JsonProperty("polar")
    private boolean polar;
    @JsonProperty("season")
    private String season;
    @JsonProperty("obs_time")
    private int obsTime;
    @JsonProperty("source")
    private String source;
    @JsonProperty("prec_type")
    private Integer precType;//Тип осадков.
    @JsonProperty("prec_strength")
    private Integer precStrength;//Сила осадков.
    @JsonProperty("cloudness")
    private int cloudness;//Облачность.
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("temp")
    public Integer getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    @JsonProperty("feels_like")
    public int getFeelsLike() {
        return feelsLike;
    }

    @JsonProperty("feels_like")
    public void setFeelsLike(int feelsLike) {
        this.feelsLike = feelsLike;
    }

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JsonProperty("condition")
    public String getCondition() {
        return condition;
    }

    @JsonProperty("condition")
    public void setCondition(String condition) {
        this.condition = condition;
    }

    @JsonProperty("wind_speed")
    public double getWindSpeed() {
        return windSpeed;
    }

    @JsonProperty("wind_speed")
    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    @JsonProperty("wind_gust")
    public double getWindGust() {
        return windGust;
    }

    @JsonProperty("wind_gust")
    public void setWindGust(double windGust) {
        this.windGust = windGust;
    }

    @JsonProperty("wind_dir")
    public String getWindDir() {
        return windDir;
    }

    @JsonProperty("wind_dir")
    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    @JsonProperty("pressure_mm")
    public int getPressureMm() {
        return pressureMm;
    }

    @JsonProperty("pressure_mm")
    public void setPressureMm(int pressureMm) {
        this.pressureMm = pressureMm;
    }

    @JsonProperty("pressure_pa")
    public int getPressurePa() {
        return pressurePa;
    }

    @JsonProperty("pressure_pa")
    public void setPressurePa(int pressurePa) {
        this.pressurePa = pressurePa;
    }

    @JsonProperty("humidity")
    public int getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    @JsonProperty("uv_index")
    public int getUvIndex() {
        return uvIndex;
    }

    @JsonProperty("uv_index")
    public void setUvIndex(int uvIndex) {
        this.uvIndex = uvIndex;
    }

    @JsonProperty("soil_temp")
    public int getSoilTemp() {
        return soilTemp;
    }

    @JsonProperty("soil_temp")
    public void setSoilTemp(int soilTemp) {
        this.soilTemp = soilTemp;
    }

    @JsonProperty("soil_moisture")
    public double getSoilMoisture() {
        return soilMoisture;
    }

    @JsonProperty("soil_moisture")
    public void setSoilMoisture(double soilMoisture) {
        this.soilMoisture = soilMoisture;
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
    public boolean isPolar() {
        return polar;
    }

    @JsonProperty("polar")
    public void setPolar(boolean polar) {
        this.polar = polar;
    }

    @JsonProperty("season")
    public String getSeason() {
        return season;
    }

    @JsonProperty("season")
    public void setSeason(String season) {
        this.season = season;
    }

    @JsonProperty("obs_time")
    public int getObsTime() {
        return obsTime;
    }

    @JsonProperty("obs_time")
    public void setObsTime(int obsTime) {
        this.obsTime = obsTime;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("prec_type")
    public Integer getPrecType() {
        return precType;
    }

    @JsonProperty("prec_type")
    public void setPrecType(Integer precType) {
        this.precType = precType;
    }

    @JsonProperty("prec_strength")
    public Integer getPrecStrength() {
        return precStrength;
    }

    @JsonProperty("prec_strength")
    public void setPrecStrength(Integer precStrength) {
        this.precStrength = precStrength;
    }

    @JsonProperty("cloudness")
    public int getCloudness() {
        return cloudness;
    }

    @JsonProperty("cloudness")
    public void setCloudness(int cloudness) {
        this.cloudness = cloudness;
    }


    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
