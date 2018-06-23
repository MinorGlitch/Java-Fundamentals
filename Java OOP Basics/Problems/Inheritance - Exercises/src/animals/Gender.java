package animals;

public class Gender {
    private String gender;

    public Gender(String gender) {
        this.setGender(gender);
    }

    private void setGender(String gender) {
        if (gender.isEmpty()){
            throw new IllegalArgumentException();
        }

        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
