import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ServiceJsonTest {

    ServiceJson serviceJson = new ServiceJson();


    @Test
    public void read() throws IOException {
        ArrayList<Schedule> schedulesActual = (ArrayList<Schedule>)
                serviceJson.read("src/test/resources/schedule.json");

        ArrayList<Schedule> schedulesExpected = new ArrayList<>();
        schedulesExpected.add((new Schedule(NumberLesson.six,new Group(223),
                Day.Monday,new Room(123),
                new Teacher("Ivan","Kovlov"),new Subject("Math") )));

        schedulesExpected.add((new Schedule(NumberLesson.three,new Group(224),
                Day.Monday,new Room(113),
                new Teacher("Ivani78o","Kovlov"),new Subject("Math") )));

        assertArrayEquals(schedulesExpected.toArray(),schedulesActual.toArray());
    }

    @Test
    public void write() throws IOException {
        try( PrintWriter printWriter = new PrintWriter("src/test/resources/schedule1.json")) {
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Schedule> schedulesExpected= new ArrayList<>();
        schedulesExpected.add(new Schedule(NumberLesson.seven,new Group(111),
                Day.Friday,new Room(111),
                new Teacher("Vlad","Banar"),new Subject("Programing") ));
        serviceJson.write(schedulesExpected,"src/test/resources/schedule1.json");
        ArrayList<Schedule> schedulessActual;

        schedulessActual = (ArrayList<Schedule>)
                serviceJson.read("src/test/resources/schedule1.json");
        schedulessActual.get(0).setNumberLesson(NumberLesson.seven);
        assertArrayEquals(schedulesExpected.toArray(),schedulessActual.toArray());
    }

}