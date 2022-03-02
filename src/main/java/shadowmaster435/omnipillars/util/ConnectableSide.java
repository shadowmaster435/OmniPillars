package shadowmaster435.omnipillars.util;

import net.minecraft.util.StringIdentifiable;

public enum ConnectableSide implements StringIdentifiable {
    NONE("none"),
    CONNECTED("connected"),
    CAP("cap"),
    CORNER("corner");

    private final String name;

    ConnectableSide(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String asString() {
        return this.name;
    }
}