package model;

import model.exception.EntityNotEmptyException;
import model.feature.Containerable;
import model.feature.Locationable;
import model.feature.Transparent;

public class Glass extends Entity implements Containerable<Mouse>, Transparent {
    private Mouse mouse;

    @Override
    public void putIn(Mouse mouse) throws EntityNotEmptyException {
        if (!this.isEmpty()) throw new EntityNotEmptyException("Стакан заполнен");
        mouse.setContainer(this);
        this.mouse = mouse;

    }

    @Override
    public void clear() {
        this.mouse = null;
    }

    @Override
    public boolean contains(Mouse mouse) {
        return this.mouse != null && this.mouse.equals(mouse);
    }

    @Override
    public boolean isEmpty() {
        return mouse == null;
    }

    @Override
    public Mouse getInner() {
        return this.mouse;
    }

    @Override
    public void setLocation(Locationable locationable) {
        if (!isEmpty()) this.mouse.setLocation(locationable);
        super.setLocation(locationable);
    }
}
