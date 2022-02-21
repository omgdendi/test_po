package model.exception;

public class EntityNotEmptyException extends RuntimeException {
    public EntityNotEmptyException(String message){
        super(message);
    }
}
