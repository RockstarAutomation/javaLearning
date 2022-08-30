package collections;

import generics.PhoneTask;
import generics.Task;

import java.util.*;

public class CLmain {
    // Right way to dump data from list while iterating
    public static void main(String[] args) {
        CLmain cl = new CLmain();
    }

    public void binaryMovements(CLmain cl) {
        String a = "true";
        char[] chars = a.toCharArray();
        byte[] bytes = new byte[100];
        StringBuilder binaryString = new StringBuilder();
        int i = 0;
        for (char c : chars) {
            binaryString.append(Integer.toBinaryString(c));
        }
        System.out.println(binaryString.toString());
        int represent = Integer.parseUnsignedInt(binaryString.toString(), 2);
        System.out.println(cl.extractValueAtPosition(represent, 3));
    }

    private int extractValueAtPosition(int intRepresentation, int position) {
        return ((intRepresentation) & (1 << (position - 1)));
    }

    public static void emptyCollection() {
        Collection<PhoneTask> tuesdayTasks = new ArrayList<>();
        PhoneTask paulPhone = new PhoneTask("Paul", "123 4567");
        tuesdayTasks.add(paulPhone);
        for (Iterator<PhoneTask> it = tuesdayTasks.iterator(); it.hasNext(); ) {
            Task next = it.next();
            it.remove();
        }
        System.out.println(tuesdayTasks);
    }

    public static void clearMap() {
        Map<Integer, String> test = new HashMap<>();
        for (int i = 0; i <= 5; i++){
            test.put(i, "sdad" + i);
        }

        System.out.println("Before: " + test.size());
        Iterator<String> iterator = test.values().iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        System.out.println("After: " + test.size());
    }

    public static void printCircleArray() {

        char[] a = new char[]{'A', 'B', 'C',
                'D', 'E', 'F'};
        int n = 6;

        // print from ind-th index to
        // (n+i)th index.
        for (int i = 3; i < n + 3; i++) {
            System.out.print(n + "%" + i + "=" + i % n);
            System.out.println(a[(i % n)] + " ");
        }
    }
}
