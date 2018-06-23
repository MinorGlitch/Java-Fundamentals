package mankind;

import mankind.validation.HumanValidation;

public class Human {
    private String firstName;
    protected String lastName;

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    protected String getFirstName() {
        return firstName;
    }

    protected String getLastName() {
        return lastName;
    }

    private void setFirstName(String firstName) {
        if (!HumanValidation.isFirstNameCapital(firstName)) {
            throw new IllegalArgumentException(HumanValidation.INVALID_FIRST_LETTER_MESSAGE);
        }
        if (!HumanValidation.isValidFirstNameLength(firstName))  {
            throw new IllegalArgumentException(HumanValidation.INVALID_FIRST_NAME_LENGTH_MESSAGE);
        }

        this.firstName = firstName;
    }

    protected void setLastName(String lastName) {
        if (!HumanValidation.isLastNameCapital(lastName)) {
            throw new IllegalArgumentException(HumanValidation.INVALID_LAST_LETTER_MESSAGE);
        }
        if (!HumanValidation.isValidLastNameLength(lastName))  {
            throw new IllegalArgumentException(HumanValidation.INVALID_LAST_NAME_LENGTH_MESSAGE);
        }

        this.lastName = lastName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("First Name: ").append(this.getFirstName()).append("\n");
        sb.append("Last Name: ").append(this.getLastName()).append("\n");
        return sb.toString();
    }
}
