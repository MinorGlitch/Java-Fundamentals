package mankind.validation;

public final class StudentValidation {
    public static final String INVALID_FACULTY_NUMBER_LENGTH_MESSAGE = "Invalid faculty number!";

    public static boolean isValidFacultyNumber(String facultyNumber) {
        return facultyNumber.length() > 4 && facultyNumber.length() < 11;
    }
}
