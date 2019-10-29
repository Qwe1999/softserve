import java.io.*;
import java.util.ArrayList;

public class Main {

    static  class ServisJsonThread extends  Thread{
        @Override
        public void run() {
            ServiceJson serviceJson = new ServiceJson();
            try {
                ArrayList<Schedule> schedules =
                        (ArrayList<Schedule>) serviceJson.read("src/main/resources/schedule.json");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Read is done");
        }

    }

    public static void main(String[] args) {

        ServisJsonThread jsonThread = new ServisJsonThread();
        jsonThread.start();

        /*ServiceSchedule serviceSchedule = new ServiceSchedule();
        ServiceJson serviceJson = new ServiceJson();

        try {
            ArrayList<Schedule> schedules = (ArrayList<Schedule>) serviceJson.read("src/main/resources/schedule.json");
            serviceSchedule.setSchedules(schedules);
            serviceSchedule.addLesson(new Schedule(NumberLesson.one,new Group(233),Day.Thursday,new Room(123),
                    new Teacher("ASD","FVC"),new Subject("Math") ));
            System.out.println(serviceSchedule.getByTeacher(new Teacher("ASD","FVC")));
        } catch (IOException | ScheduleException e) {
            e.printStackTrace();
        }*/

    }

}
