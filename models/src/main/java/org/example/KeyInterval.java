package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class KeyInterval {

    private long time;

    @JsonCreator
    public KeyInterval(@JsonProperty("time") long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }
}
