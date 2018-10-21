
package com.mtxsoftware.model.forecast.parts;

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
    "hour",
    "hour_ts",
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
    "prec_mm",
    "prec_period",
    "prec_prob",
    "prec_type",
    "prec_strength",
    "cloudness",
    "_nowcast"
})
public class Hour {

    @JsonProperty("hour")
    private String hour;//Значение часа, для которого дается прогноз (0-23), локальное время.
    @JsonProperty("hour_ts")
    private Integer hourTs;//Время прогноза в Unixtime
    @JsonProperty("temp")
    private Integer temp;//Температура (°C)
    @JsonProperty("feels_like")
    private Integer feelsLike;//Ощущаемая температура (°C).
    @JsonProperty("icon")
    private String icon;//Код иконки погоды. Иконка доступна по адресу https://yastatic.net/weather/i/icons/blueye/color/svg/<значение из поля icon>.svg.
    @JsonProperty("condition")
    private String condition;//Код расшифровки погодного описания
    @JsonProperty("wind_speed")
    private Double windSpeed;//Скорость ветра (в м/с).
    @JsonProperty("wind_gust")
    private Double windGust;//Скорость порывов ветра (в м/с).
    @JsonProperty("wind_dir")
    private String windDir;//Направление ветра.
    @JsonProperty("pressure_mm")
    private Integer pressureMm;//Давление (в мм рт. ст.).
    @JsonProperty("pressure_pa")
    private Integer pressurePa;//Давление (в гектопаскалях).
    @JsonProperty("humidity")
    private Integer humidity;//Влажность воздуха (в процентах).
    @JsonProperty("uv_index")
    private Integer uvIndex;
    @JsonProperty("soil_temp")
    private Integer soilTemp;
    @JsonProperty("soil_moisture")
    private Double soilMoisture;
    @JsonProperty("prec_mm")
    private Double precMm;//	Прогнозируемое количество осадков (в мм).
    @JsonProperty("prec_period")
    private Integer precPeriod;//Прогнозируемый период осадков (в минутах).
    @JsonProperty("prec_prob")
    private Integer precProb;
    @JsonProperty("prec_type")
    private Integer precType;//Тип осадков
    @JsonProperty("prec_strength")
    private Double precStrength;//Сила осадков.
    @JsonProperty("cloudness")
    private Double cloudness;//Облачность
    @JsonProperty("_nowcast")
    private Boolean nowcast;

    @JsonProperty("hour")
    public String getHour() {
        return hour;
    }

    @JsonProperty("hour")
    public void setHour(String hour) {
        this.hour = hour;
    }

    @JsonProperty("hour_ts")
    public Integer getHourTs() {
        return hourTs;
    }

    @JsonProperty("hour_ts")
    public void setHourTs(Integer hourTs) {
        this.hourTs = hourTs;
    }

    @JsonProperty("temp")
    public Integer getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    @JsonProperty("feels_like")
    public Integer getFeelsLike() {
        return feelsLike;
    }

    @JsonProperty("feels_like")
    public void setFeelsLike(Integer feelsLike) {
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
    public Double getWindSpeed() {
        return windSpeed;
    }

    @JsonProperty("wind_speed")
    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    @JsonProperty("wind_gust")
    public Double getWindGust() {
        return windGust;
    }

    @JsonProperty("wind_gust")
    public void setWindGust(Double windGust) {
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
    public Integer getPressureMm() {
        return pressureMm;
    }

    @JsonProperty("pressure_mm")
    public void setPressureMm(Integer pressureMm) {
        this.pressureMm = pressureMm;
    }

    @JsonProperty("pressure_pa")
    public Integer getPressurePa() {
        return pressurePa;
    }

    @JsonProperty("pressure_pa")
    public void setPressurePa(Integer pressurePa) {
        this.pressurePa = pressurePa;
    }

    @JsonProperty("humidity")
    public Integer getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    @JsonProperty("uv_index")
    public Integer getUvIndex() {
        return uvIndex;
    }

    @JsonProperty("uv_index")
    public void setUvIndex(Integer uvIndex) {
        this.uvIndex = uvIndex;
    }

    @JsonProperty("soil_temp")
    public Integer getSoilTemp() {
        return soilTemp;
    }

    @JsonProperty("soil_temp")
    public void setSoilTemp(Integer soilTemp) {
        this.soilTemp = soilTemp;
    }

    @JsonProperty("soil_moisture")
    public Double getSoilMoisture() {
        return soilMoisture;
    }

    @JsonProperty("soil_moisture")
    public void setSoilMoisture(Double soilMoisture) {
        this.soilMoisture = soilMoisture;
    }

    @JsonProperty("prec_mm")
    public Double getPrecMm() {
        return precMm;
    }

    @JsonProperty("prec_mm")
    public void setPrecMm(Double precMm) {
        this.precMm = precMm;
    }

    @JsonProperty("prec_period")
    public Integer getPrecPeriod() {
        return precPeriod;
    }

    @JsonProperty("prec_period")
    public void setPrecPeriod(Integer precPeriod) {
        this.precPeriod = precPeriod;
    }

    @JsonProperty("prec_prob")
    public Integer getPrecProb() {
        return precProb;
    }

    @JsonProperty("prec_prob")
    public void setPrecProb(Integer precProb) {
        this.precProb = precProb;
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
    public Double getPrecStrength() {
        return precStrength;
    }

    @JsonProperty("prec_strength")
    public void setPrecStrength(Double precStrength) {
        this.precStrength = precStrength;
    }

    @JsonProperty("cloudness")
    public Double getCloudness() {
        return cloudness;
    }

    @JsonProperty("cloudness")
    public void setCloudness(Double cloudness) {
        this.cloudness = cloudness;
    }

    @JsonProperty("_nowcast")
    public Boolean isNowcast() {
        return nowcast;
    }

    @JsonProperty("_nowcast")
    public void setNowcast(Boolean nowcast) {
        this.nowcast = nowcast;
    }

}
