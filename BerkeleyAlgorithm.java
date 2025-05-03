import java.util.*;

public class BerkeleyAlgorithm {
    public static void main(String[] args) {
        // Step 1: Create nodes with different clock times
        List<ClockNode> nodes = new ArrayList<>();
        nodes.add(new ClockNode(0, 100, true));   // Master node
        nodes.add(new ClockNode(1, 98, false));
        nodes.add(new ClockNode(2, 105, false));
        nodes.add(new ClockNode(3, 102, false));
        nodes.add(new ClockNode(4, 95, false));

        System.out.println("Initial Times:");
        for (ClockNode node : nodes) {
            System.out.println(node);
        }

        // Step 2: Master collects time differences
        ClockNode master = nodes.get(0);
        int masterTime = master.time;
        int totalDiff = 0;
        int count = 0;

        System.out.println("\nCalculating time differences:");
        for (ClockNode node : nodes) {
            if (!node.isMaster) {
                int diff = node.time - masterTime;
                System.out.println("Node " + node.id + " reports difference: " + diff + "s");
                totalDiff += diff;
                count++;
            }
        }

        // Step 3: Calculate average adjustment (master doesn't count itself)
        int averageDiff = totalDiff / (count + 1); // Include master for fair average
        System.out.println("\nAverage time difference: " + averageDiff + "s");

        // Step 4: Master sends time adjustments to all
        for (ClockNode node : nodes) {
            int adjustment = averageDiff - (node.time - masterTime);
            node.adjustTime(adjustment);
            System.out.println("Node " + node.id + " adjusted by: " + adjustment + "s");
        }

        // Final times
        System.out.println("\nSynchronized Times:");
        for (ClockNode node : nodes) {
            System.out.println(node);
        }
    }
}
