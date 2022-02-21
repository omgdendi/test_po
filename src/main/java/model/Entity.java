package model;

import model.feature.Locationable;
import model.feature.Moveable;

public abstract class Entity implements Moveable {
    private Locationable location;

    @Override
    public void setLocation(Locationable locationable) {
        this.location = locationable;
    }

    @Override
    public Locationable getLocation() {
        return this.location;
    }
}
