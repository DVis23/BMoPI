package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class KeyHoldingTime {
    private long time;

    @JsonCreator
    public KeyHoldingTime(@JsonProperty("time") long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }
}
