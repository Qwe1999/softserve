public class ScheduleException extends Exception {
    private String message;

    ScheduleException(String message){
        super();
        this.message = message;
    }


    @Override
    public String toString() {
        return "ScheduleException{" +
                "message='" + message + '\'' +
                '}';
    }
}
