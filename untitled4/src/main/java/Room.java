public class Room {
    private int numberRoom;

    public Room(int numberRoom) {
        this.numberRoom = numberRoom;
    }

    public Room() {
    }

    @Override
    public String toString() {
        return "Room{" +
                "numberRoom=" + numberRoom +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return numberRoom == room.numberRoom;
    }



    public int getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(int numberRoom) throws Exception {
        if(numberRoom >=0) {
            this.numberRoom = numberRoom;
        }
        else {
            throw new Exception();
        }
    }
}
