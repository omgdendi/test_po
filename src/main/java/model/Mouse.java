package model;


import model.exception.AlreadyAddedException;
import model.exception.EntityNotEmptyException;
import model.exception.EntityNotFoundException;
import model.feature.Containerable;
import model.feature.Fittable;
import model.type.Color;

public class Mouse extends LiveBeing implements Fittable<Glass> {
    private Color color;
    private Containerable<Mouse> container;

    public Mouse(Color color) {
        this.color = color;
    }

    public Mouse() {
    }

    public String getColor() {
        return color.getTitle();
    }

    @Override
    public void getInto(Glass glass) throws AlreadyAddedException {
        if (!glass.isEmpty()) throw new EntityNotEmptyException("Стакан уже заполнен");
        glass.putIn(this);
    }

    @Override
    public void getOutFrom(Glass glass) throws EntityNotFoundException {
        if (!glass.contains(this)) throw new EntityNotFoundException("Этой мышки нет в стакане");
        glass.clear();
    }

    @Override
    public Containerable<?> getContainer() {
        return container;
    }

    @Override
    public void setContainer(Containerable container) {
        this.setLocation(container.getLocation());
        this.container = container;
    }
}
