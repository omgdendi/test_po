package model;

import model.type.SilenceType;

public class Silence extends Entity {
    private SilenceType type;

    public Silence(SilenceType type) {
        this.type = type;
    }

    public SilenceType getType() {
        return type;
    }

    public void setType(SilenceType type) {
        this.type = type;
    }

}
