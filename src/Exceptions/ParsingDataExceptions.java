package Exceptions;

public class ParsingDataExceptions extends RuntimeException {
    public ParsingDataExceptions() {
        super("Персональные данные не распознаны или имеют неверный формат.");
    }

    public ParsingDataExceptions(String message) {
        super(message);
    }
}
