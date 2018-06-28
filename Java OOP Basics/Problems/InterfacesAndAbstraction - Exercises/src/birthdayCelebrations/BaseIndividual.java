package birthdayCelebrations;

public abstract class BaseIndividual implements Individual {
    protected String name;
    protected String id;
    protected String birthDate;

    protected BaseIndividual() {
    }

    protected BaseIndividual(String name, String id, String birthDate) {
        this.name = name;
        this.id = id;
        this.birthDate = birthDate;
    }

    protected BaseIndividual(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

    @Override
    public String getBirthYear() {
        return this.getBirthDate().substring(this.getBirthDate()
                .lastIndexOf("/") + 1, this.getBirthDate().length());
    }
}
