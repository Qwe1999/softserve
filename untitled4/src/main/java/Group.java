public class Group {
    public int numberGroup;


    public Group(int numberGroup) {
        this.numberGroup = numberGroup;
    }

    @Override
    public String toString() {
        return "Group{" +
                "numberGroup=" + numberGroup +
                '}';
    }

    public Group() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return numberGroup == group.numberGroup;
    }



    public int getNumberGroup() {
        return numberGroup;
    }

    public void setNumberGroup(int numberGroup) throws Exception {
        this.numberGroup = numberGroup;
        if(numberGroup >=0) {
            this.numberGroup = numberGroup;
        }
        else {
            throw new Exception();
        }
    }
}
