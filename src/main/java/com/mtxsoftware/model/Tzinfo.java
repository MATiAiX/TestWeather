
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
    "offset",
    "name",
    "abbr",
    "dst"
})

//Информация о часовом поясе.
public class Tzinfo {

    @JsonProperty("offset")
    private int offset;//Часовой пояс в секундах от UTC.
    @JsonProperty("name")
    private String name;//Название часового пояса.
    @JsonProperty("abbr")
    private String abbr;//Сокращенное название часового пояса.
    @JsonProperty("dst")
    private boolean dst;//Признак летнего времени.

    @JsonProperty("offset")
    public int getOffset() {
        return offset;
    }

    @JsonProperty("offset")
    public void setOffset(int offset) {
        this.offset = offset;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("abbr")
    public String getAbbr() {
        return abbr;
    }

    @JsonProperty("abbr")
    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    @JsonProperty("dst")
    public boolean isDst() {
        return dst;
    }

    @JsonProperty("dst")
    public void setDst(boolean dst) {
        this.dst = dst;
    }

}
