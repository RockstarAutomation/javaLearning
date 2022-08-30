package generics;

import java.util.*;

public class GenericsLearning {

    public static void main(String[] args) {
        Collection bla = Collections.checkedCollection(new ArrayList<>(), List.class);
        bla.add(Arrays.asList(new Integer(5)));
        bla.add(Arrays.asList(new Double(7.8)));
        bla.add(Arrays.asList("asda"));
        System.out.println(bla.toString());
    }
}
