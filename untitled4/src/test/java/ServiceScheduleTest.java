//import org.junit.jupiter.api.Test;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ServiceScheduleTest {

    ServiceSchedule serviceSchedule;

    @BeforeEach
    void setUp() {
        List<Schedule> schedule = new ArrayList<>();
        schedule.add(new Schedule(NumberLesson.seven, new Group(133), Day.Thursday, new Room(321),
                new Teacher("Vlad", "Peterson"), new Subject("Physics")));
        schedule.add(new Schedule(NumberLesson.five, new Group(453), Day.Thursday, new Room(432),
                new Teacher("Katya", "Panova"), new Subject("Programing")));
        schedule.add(new Schedule(NumberLesson.six, new Group(313), Day.Friday, new Room(234),
                new Teacher("Ivan", "Pavlov"), new Subject("Physics")));
        schedule.add(new Schedule(NumberLesson.one, new Group(111), Day.Monday, new Room(111),
                new Teacher("Vlad", "Banar"), new Subject("Math")));

        serviceSchedule = new ServiceSchedule();
        serviceSchedule.setSchedules(schedule);
    }

    @Test
    @ParameterizedTest
    @MethodSource
    void addLesson(Schedule schedule) throws ScheduleException {
        int size = serviceSchedule.getSchedule().size();
        serviceSchedule.addLesson(schedule);
        assertEquals(size+1,serviceSchedule.getSchedule().size());
    }

    static Stream<Schedule> addLesson() {
        return Stream.of(
               new Schedule(NumberLesson.three, new Group(231),
                        Day.Monday, new Room(311),
                        new Teacher("EEEE", "ZXC"), new Subject("Math"))
        );
    }

    @Test
    @ParameterizedTest
    @MethodSource
    void addLessonBusy(Schedule schedule) throws ScheduleException {
      assertThrows(ScheduleException.class,() -> {
          serviceSchedule.addLesson(schedule);
      });

    }

    static Stream<Schedule> addLessonBusy() {
        return Stream.of(
                new Schedule(NumberLesson.one, new Group(111), Day.Monday, new Room(111),
                        new Teacher("Vlad", "Banar"), new Subject("Math"))
        );
    }

    @Test
    @ParameterizedTest
    @MethodSource
    void getByGroup(List<Schedule> expected, Group group) {
        List<Schedule> actual = serviceSchedule.getByGroup(new Group(111));

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    static Stream<Arguments> getByGroup() {
        return Stream.of(
                arguments(Arrays.asList(new Schedule(NumberLesson.one, new Group(111), Day.Monday, new Room(111),
                        new Teacher("Vlad", "Banar"), new Subject("Math"))), new Group(222))
        );
    }

    @Test
    @ParameterizedTest
    @MethodSource
    void getByDay(List<Schedule> expected, Day day) {
        List<Schedule> actual = serviceSchedule.getByDay(day);


        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    static Stream<Arguments> getByDay() {
        return Stream.of(
                arguments(Arrays.asList(new Schedule(NumberLesson.one, new Group(111), Day.Monday, new Room(111),
                        new Teacher("Vlad", "Banar"), new Subject("Math"))), Day.Monday)
        );
    }

    @Test
    @ParameterizedTest
    @MethodSource
    void getByTeacher(List<Schedule> expected, Teacher teacher) {
        List<Schedule> actual = serviceSchedule.getByTeacher(teacher);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    static Stream<Arguments> getByTeacher() {
        return Stream.of(
                arguments(Arrays.asList(new Schedule(NumberLesson.one, new Group(111), Day.Monday, new Room(111),
                        new Teacher("Vlad", "Banar"), new Subject("Math"))), new Teacher("Vlad", "Banar"))
        );
    }

    @Test
    @ParameterizedTest
    @MethodSource
    void getByDayGroup(List<Schedule> expected, Day day, Group group) {
        List<Schedule> actual = serviceSchedule.getByDayGroup(day, group);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    static Stream<Arguments> getByDayGroup() {
        return Stream.of(
                arguments(Arrays.asList(new Schedule(NumberLesson.one,
                                new Group(111), Day.Monday, new Room(111),
                                new Teacher("Vlad", "Banar"), new Subject("Math"))),
                                Day.Monday, new Group(111))
        );
    }

}