public class ClockNode {
    int id;
    int time; // in seconds
    boolean isMaster;

    public ClockNode(int id, int time, boolean isMaster) {
        this.id = id;
        this.time = time;
        this.isMaster = isMaster;
    }

    public void adjustTime(int offset) {
        time += offset;
    }

    @Override
    public String toString() {
        return "Node " + id + " time: " + time;
    }
}

