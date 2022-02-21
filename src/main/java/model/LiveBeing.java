package model;

import model.feature.*;
import model.type.Feeling;

import java.util.ArrayList;

public abstract class LiveBeing extends Entity implements Feelable, Lookable {
    private ArrayList<Entity> visibileEntities = new ArrayList<>();
    private Feeling feeling;
    private String name;

    public LiveBeing(String name) {
        this.name = name;
    }

    public LiveBeing() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public Feeling getFeeling() {
        return feeling;
    }

    @Override
    public void setFeeling(Feeling feeling) {
        this.feeling = feeling;
    }

    @Override
    public void lookAt(Entity... entities) {
        this.visibileEntities.clear();
        for (Entity entity : entities) {
            this.visibileEntities.add(entity);
            if (entity instanceof Fittable) {
                Containerable container = ((Fittable) entity).getContainer();
                if (container instanceof Transparent) this.visibileEntities.add((Entity) container);
            }
        }
    }

    @Override
    public ArrayList<Entity> getVisibleEntities() {
        return this.visibileEntities;
    }

}
