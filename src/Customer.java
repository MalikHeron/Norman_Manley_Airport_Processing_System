public class Customer {

    private final int id;
    private final String fName;
    private final String lName;
    private final String gender;
    private final int flightNo;
    private final int priorityNo;
    private final int time;

    // Primary Constructor
    public Customer(int Id, String fName, String lName, String gender, int flightNo, int priorityNo, int time) {
        this.id = Id;
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
        this.flightNo = flightNo;
        this.priorityNo = priorityNo;
        this.time = time;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getFName() {
        return fName;
    }

    public String getLName() {
        return lName;
    }

    public String getGender() {
        return gender;
    }

    public int getFlightNo() {
        return flightNo;
    }

    public int getPriorityNo() {
        return priorityNo;
    }

    public int getTime() {
        return time;
    }

    // Overriding toString
    public String toString() {
        return "[" + id +
                ", " + fName + " " + lName +
                ", " + gender +
                ", " + flightNo +
                ", " + priorityNo + "] Time: " + time;
    }
}
