package model.feature;

import model.Entity;

import java.util.ArrayList;

public interface Lookable {
    public void lookAt(Entity... entities);

    public ArrayList<Entity> getVisibleEntities();
}
