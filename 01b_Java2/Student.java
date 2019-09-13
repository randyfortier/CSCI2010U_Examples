public class Student {
    //Professor favouriteProf; // not public, not same file

    public int sid;
    public String name;
    private long startDate;

    public Student(int sid, String newName) {
        this.sid = sid;
        name = newName;
    }

    // accessor
    public long getStartDate() { 
        return startDate;
    }

    // mutator
    public void setStartDate(String date) {
        // convert date to a long
    }

    public String toString() {
        return "Student(" + sid + "," + name + ")";
    }
}