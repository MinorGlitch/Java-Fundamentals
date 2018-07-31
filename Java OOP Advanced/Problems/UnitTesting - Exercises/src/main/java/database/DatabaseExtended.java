package database;

import javax.naming.OperationNotSupportedException;

public class DatabaseExtended {
    private Person[] people;

    private DatabaseExtended() {
        this.people = new Person[16];
    }

    public DatabaseExtended(Person... people) {
        this();
        for (int i = 0; i < people.length; i++) {
            this.people[i] = people[i];
        }
    }

    private boolean containsById(Person person) {
        for (Person p : people) {
            if (p.getId() == person.getId()) {
                return true;
            }
        }

        return false;
    }

    public void add(Person person) throws OperationNotSupportedException {
        if (person == null) {
            throw new OperationNotSupportedException();
        } else if (person.getId() < 0) {
            throw new OperationNotSupportedException();
        } else if (this.containsById(person)) {
            throw new OperationNotSupportedException();
        }

        for (int i = 0; i < this.people.length; i++) {
            if (this.people[i] == null) {

                this.people[i] = person;
                return;
            }
        }

        throw new OperationNotSupportedException();
    }

    public Person findByUsername(String username) throws OperationNotSupportedException {
        if (username == null) {
            throw new OperationNotSupportedException();
        }
        for (Person person : people) {
            if (person == null) {
                continue;
            }
            if (person.getUsername().equals(username)) {
                return person;
            }
        }

        throw new OperationNotSupportedException();
    }

    public Person findById(long id) throws OperationNotSupportedException {
        for (Person person : people) {
            if (person == null) {
                continue;
            }
            if (person.getId() == id) {
                return person;
            }
        }

        throw new OperationNotSupportedException();
    }

    public void remove() throws OperationNotSupportedException {
        for (int i = this.people.length - 1; i >= 0; i--) {
            if (this.people[i] != null) {
                this.people[i] = null;
                return;
            }
        }

        throw new OperationNotSupportedException();
    }

}
