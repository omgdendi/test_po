package model.feature;

import model.exception.EntityNotEmptyException;
import model.exception.EntityNotFoundException;

public interface Fittable<T extends Containerable<?>> {

    public void getInto(T t) throws EntityNotEmptyException;

    public void getOutFrom(T t) throws EntityNotFoundException;

    public Containerable<?> getContainer();

    public void setContainer(Containerable container);
}
