package mankind.validation;

public final class HumanValidation {
    public static final String INVALID_FIRST_LETTER_MESSAGE = "Expected upper case letter!Argument: firstName";
    public static final String INVALID_FIRST_NAME_LENGTH_MESSAGE =
            "Expected length at least 4 symbols!Argument: firstName";

    public static final String INVALID_LAST_LETTER_MESSAGE = "Expected upper case letter!Argument: lastName";
    public static final String INVALID_LAST_NAME_LENGTH_MESSAGE =
            "Expected length at least 3 symbols!Argument: lastName";
    private static final int FIRST_NAME_MIN_LENGTH = 4;
    private static final int LAST_NAME_MIN_LENGTH = 3;


    public static boolean isFirstNameCapital(String firstName) throws IllegalArgumentException {
        return Character.isUpperCase(firstName.charAt(0));
    }

    public static boolean isLastNameCapital(String lastName) throws IllegalArgumentException {
        if (Character.isUpperCase(lastName.charAt(0))) {
            return true;
        }

        throw new IllegalArgumentException(INVALID_LAST_LETTER_MESSAGE);
    }

    public static boolean isValidFirstNameLength(String firstName) throws IllegalArgumentException {
        return firstName.length() >= FIRST_NAME_MIN_LENGTH;
    }

    public static boolean isValidLastNameLength(String lastName) throws IllegalArgumentException {
        return lastName.length() >= LAST_NAME_MIN_LENGTH;

    }
}
