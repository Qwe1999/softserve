import java.util.Objects;

public class Schedule {
    private NumberLesson numberLesson;
    private Group group;
    private Day day;
    private Room room;
    private Teacher teacher;
    private Subject subject;

    public Schedule(NumberLesson numberLesson, Group group, Day day, Room room, Teacher teacher, Subject subject) {
        this.numberLesson = numberLesson;
        this.group = group;
        this.day = day;
        this.room = room;
        this.teacher = teacher;
        this.subject = subject;
    }

    public Schedule() {
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public NumberLesson getNumberLesson() {
        return numberLesson;
    }

    public void setNumberLesson(NumberLesson numberLesson) {
            this.numberLesson = numberLesson;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
            this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return numberLesson == schedule.numberLesson &&
                Objects.equals(group, schedule.group) &&
                day == schedule.day &&
                Objects.equals(room, schedule.room) &&
                Objects.equals(teacher, schedule.teacher) &&
                Objects.equals(subject, schedule.subject);
    }


    @Override
    public String toString() {
        return "Schedule{" +
                "numberLesson=" + numberLesson +
                ", group=" + group +
                ", day='" + day + '\'' +
                ", room=" + room +
                ", teacher=" + teacher +
                ", subject=" + subject +
                '}';
    }
}
