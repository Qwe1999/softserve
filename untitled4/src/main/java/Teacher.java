import java.util.Objects;

public class Teacher {
    private String firstName;
    private String lastName;

    public Teacher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Teacher() {
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(firstName, teacher.firstName) &&
                Objects.equals(lastName, teacher.lastName);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws Exception {
        if(firstName != null & !firstName.isEmpty()) {
            this.firstName = firstName;
        }
        else {
            throw new Exception();
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws Exception {
        if(lastName != null & !lastName.isEmpty()) {
            this.lastName = lastName;
        }
        else {
            throw new Exception();
        }
    }

}