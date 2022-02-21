package model.feature;

import model.exception.EntityNotEmptyException;

public interface Containerable<T extends Fittable<?>> extends Moveable{

    void putIn(T t) throws EntityNotEmptyException;

    public boolean contains(T t);


    public void clear();

    public boolean isEmpty();

    public T getInner();
}
