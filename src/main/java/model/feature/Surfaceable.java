package model.feature;

import model.exception.AlreadyAddedException;
import model.exception.EntityNotFoundException;

import java.util.ArrayList;

// surface в переводе с украинского - поверхность
public interface Surfaceable<T> extends Locationable {
    public void put(T... t);

    public void remove(T t) throws EntityNotFoundException;

    public void clear();

    public boolean contains(T t);

    public ArrayList<T> getAll();
}
