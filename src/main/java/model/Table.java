package model;

import model.exception.AlreadyAddedException;
import model.exception.EntityNotFoundException;
import model.feature.Surfaceable;

import java.util.ArrayList;

public class Table extends Entity implements Surfaceable<Entity> {
    private ArrayList<Entity> staff;

    public Table() {
        this.staff = new ArrayList<Entity>();
    }

    public Table(ArrayList<Entity> staff) {
        this.staff = staff;
    }

    @Override
    public void put(Entity... entities) {
        for (Entity entity : entities)
            if (!this.staff.contains(entity)) {
                entity.setLocation(this);
                this.staff.add(entity);
            }
    }

    @Override
    public void remove(Entity entity) throws EntityNotFoundException {
        if (!this.staff.contains(entity)) throw new EntityNotFoundException(entity + " нет на столе");

        entity.setLocation(null);
        this.staff.remove(entity);
    }

    @Override
    public void clear() {
        this.staff.clear();
    }

    @Override
    public boolean contains(Entity entity) {
        return this.staff.contains(entity);
    }

    @Override
    public ArrayList<Entity> getAll() {
        return this.staff;
    }
}
