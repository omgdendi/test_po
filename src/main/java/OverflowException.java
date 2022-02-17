public class OverflowException extends RuntimeException {
    public OverflowException() {
        super("При вычислении факториала произошло переполнение буфера. Попробуйте указать меньшую погрешность или уменьшить вычисляемое число по модулю");
    }
}
