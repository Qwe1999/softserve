import java.util.Objects;

public class Subject {
    private String  nameSubject;

    public Subject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public Subject() {
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) throws Exception {
        if(nameSubject != null & !nameSubject.isEmpty()) {
            this.nameSubject = nameSubject;
        }
        else {
            throw new Exception();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(nameSubject, subject.nameSubject);
    }



    @Override
    public String toString() {
        return "Subject{" +
                "nameSubject='" + nameSubject + '\'' +
                '}';
    }
}
