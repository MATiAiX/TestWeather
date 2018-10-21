
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
        "_source",
        "temp",
        "temp_min",
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
        "prec_prob",
        "prec_type",
        "prec_strength",
        "cloudness"
})
public class PartShort {

    @JsonProperty("_source")
    protected String source;
    @JsonProperty("temp")
    private Integer temp;//Максимальная дневная или минимальная ночная температура
    @JsonProperty("temp_min")
    protected Integer tempMin;//Минимальная температура для времени суток (°C).
    @JsonProperty("feels_like")
    protected Integer feelsLike;//Ощущаемая температура (°C).
    @JsonProperty("icon")
    protected String icon;//Код иконки погоды. Иконка доступна по адресу https://yastatic.net/weather/i/icons/blueye/color/svg/<значение из поля icon>.svg.
    @JsonProperty("condition")
    protected String condition;//Код расшифровки погодного описания.
    @JsonProperty("wind_speed")
    protected Double windSpeed;//Скорость ветра (в м/с).
    @JsonProperty("wind_gust")
    protected Double windGust;//Скорость порывов ветра (в м/с).
    @JsonProperty("wind_dir")
    protected String windDir;//Направление ветра.
    @JsonProperty("pressure_mm")
    protected Integer pressureMm;//Давление (в мм рт. ст.).
    @JsonProperty("pressure_pa")
    protected Integer pressurePa;//Давление (в гектопаскалях).
    @JsonProperty("humidity")
    protected Integer humidity;//Влажность воздуха (в процентах).
    @JsonProperty("uv_index")
    protected Integer uvIndex;
    @JsonProperty("soil_temp")
    protected Integer soilTemp;
    @JsonProperty("soil_moisture")
    protected Double soilMoisture;
    @JsonProperty("prec_mm")
    protected Double precMm;//Прогнозируемое количество осадков (в мм).
    @JsonProperty("prec_prob")
    protected Integer precProb;
    @JsonProperty("prec_type")
    protected Integer precType;//Тип осадков.
    @JsonProperty("prec_strength")
    protected Integer precStrength;//Сила осадков
    @JsonProperty("cloudness")
    protected Integer cloudness;//Облачность
    @JsonIgnore
    protected Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("_source")
    public String getSource() {
        return source;
    }

    @JsonProperty("_source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("temp")
    public Integer getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    @JsonProperty("temp_min")
    public Integer getTempMin() {
        return tempMin;
    }

    @JsonProperty("temp_min")
    public void setTempMin(Integer tempMin) {
        this.tempMin = tempMin;
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
    public Integer getPrecStrength() {
        return precStrength;
    }

    @JsonProperty("prec_strength")
    public void setPrecStrength(Integer precStrength) {
        this.precStrength = precStrength;
    }

    @JsonProperty("cloudness")
    public Integer getCloudness() {
        return cloudness;
    }

    @JsonProperty("cloudness")
    public void setCloudness(Integer cloudness) {
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
