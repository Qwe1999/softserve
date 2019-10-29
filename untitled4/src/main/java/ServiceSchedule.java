import java.util.ArrayList;
import java.util.List;

public class ServiceSchedule {
    private List<Schedule> schedules = new ArrayList<>();

    public ServiceSchedule() {
    }

    private boolean isTeacherBusy(Schedule scheduleLesson) {
        for (Schedule i : schedules) {
            if (scheduleLesson.getDay().equals(i.getDay()) &&
                    scheduleLesson.getTeacher().equals(i.getTeacher()) &&
                    scheduleLesson.getNumberLesson().equals(i.getNumberLesson())) {
                return false;
            }
        }
        return true;
    }

    private boolean isBusyGroup(Schedule scheduleLesson1) {
        for (Schedule i : schedules) {
            if (scheduleLesson1.getDay().equals(i.getDay()) &&
                    scheduleLesson1.getGroup().equals(i.getGroup()) &&
                    scheduleLesson1.getNumberLesson().equals(i.getNumberLesson())) {
                return false;
            }
        }
        return true;
    }

    private boolean isBusyRoom(Schedule scheduleLesson1) {
        for (Schedule i : schedules) {
            if (scheduleLesson1.getDay().equals(i.getDay()) &&
                    scheduleLesson1.getRoom().equals( i.getRoom()) &&
                    scheduleLesson1.getNumberLesson().equals(i.getNumberLesson())) {
                return false;
            }
        }
        return true;
    }

    public void addLesson(Schedule scheduleLesson) throws ScheduleException {

        if (!isTeacherBusy(scheduleLesson))
            throw new ScheduleException("Teacher is busy");
        if (!isBusyGroup(scheduleLesson))
            throw new ScheduleException("Group is busy");
        if (!isBusyRoom(scheduleLesson))
            throw new ScheduleException("Room is busy");

        schedules.add(scheduleLesson);
    }

    public List<Schedule> getByGroup(Group group) {
        List<Schedule> array = new ArrayList<>();

        for (Schedule i : schedules) {
            if (i.getGroup().equals(group)) {
                array.add(i);
            }
        }
        return array;
    }

    public List<Schedule> getByDay(Day day) {
        List<Schedule> array = new ArrayList<>();

        for (Schedule i : schedules) {
            if (i.getDay().equals(day)) {
                array.add(i);
            }
        }
        return array;
    }

    public List<Schedule> getByTeacher(Teacher teacher) {
        List<Schedule> array = new ArrayList<>();

        for (Schedule i : schedules) {
            if (i.getTeacher().equals(teacher)) {
                array.add(i);
            }
        }
        return array;
    }

    public List<Schedule> getByDayGroup(Day day, Group group) {
        List<Schedule> array = new ArrayList<>();

        for (Schedule i : schedules) {
            if (i.getDay().equals(day) && i.getGroup().equals(group)) {
                array.add(i);
            }
        }
        return array;
    }

    public List<Schedule> getSchedule() {
        return schedules;
    }

    public boolean setSchedules(List<Schedule> schedules) {
        this.schedules.clear();
        for (Schedule i : schedules){
            try {
                addLesson(i);
            } catch (ScheduleException e) {
                this.schedules.clear();
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

}
