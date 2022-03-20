package exception;

public enum ValidationExceptionMessages {
    VALIDATION_NULL("%s must not be null"),
    VALIDATION_EMPTY("%s must not be empty"),
    VALIDATION_NAN("%s must be a number"),
    VALIDATION_NUMBER_NEGATIVE("%s must not be negative");

    private final String message;

    ValidationExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
