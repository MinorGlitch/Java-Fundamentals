package mankind;

import mankind.validation.StudentValidation;

public class Student extends Human {
    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    private void setFacultyNumber(String facultyNumber) {
        if (!StudentValidation.isValidFacultyNumber(facultyNumber)) {
            throw new IllegalArgumentException(StudentValidation.INVALID_FACULTY_NUMBER_LENGTH_MESSAGE);
        }
        this.facultyNumber = facultyNumber;
    }

    private String getFacultyNumber() {
        return facultyNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Faculty number: ").append(this.getFacultyNumber()).append("\n");

        return sb.toString();
    }
}
