
package com.mtxsoftware.model.forecast.parts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "night",
    "morning",
    "day",
    "evening",
    "day_short",
    "night_short"
})
public class Parts {

    @JsonProperty("night")
    private Night night;
    @JsonProperty("morning")
    private Morning morning;
    @JsonProperty("day")
    private Day day;
    @JsonProperty("evening")
    private Evening evening;
    @JsonProperty("day_short")
    private DayShort dayShort;
    @JsonProperty("night_short")
    private NightShort nightShort;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("night")
    public Night getNight() {
        return night;
    }

    @JsonProperty("night")
    public void setNight(Night night) {
        this.night = night;
    }

    @JsonProperty("morning")
    public Morning getMorning() {
        return morning;
    }

    @JsonProperty("morning")
    public void setMorning(Morning morning) {
        this.morning = morning;
    }

    @JsonProperty("day")
    public Day getDay() {
        return day;
    }

    @JsonProperty("day")
    public void setDay(Day day) {
        this.day = day;
    }

    @JsonProperty("evening")
    public Evening getEvening() {
        return evening;
    }

    @JsonProperty("evening")
    public void setEvening(Evening evening) {
        this.evening = evening;
    }

    @JsonProperty("day_short")
    public DayShort getDayShort() {
        return dayShort;
    }

    @JsonProperty("day_short")
    public void setDayShort(DayShort dayShort) {
        this.dayShort = dayShort;
    }

    @JsonProperty("night_short")
    public NightShort getNightShort() {
        return nightShort;
    }

    @JsonProperty("night_short")
    public void setNightShort(NightShort nightShort) {
        this.nightShort = nightShort;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public List<Part> getAllParts6Hours(){
        return new ArrayList<Part>() {
            {
                add(morning);
                add(day);
                add(evening);
                add(night);
            }
        };
    }

    public List<PartShort> getAllParts12Hours(){
        return new ArrayList<PartShort>() {
            {
                add(dayShort);
                add(nightShort);
            }
        };
    }

    public List<PartShort> getAllPartsLikeShort(){
        return new ArrayList<PartShort>() {
            {
                add(morning);
                add(day);
                add(evening);
                add(night);
                add(dayShort);
                add(nightShort);
            }
        };
    }

}
