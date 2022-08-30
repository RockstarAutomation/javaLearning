package algoritms;

import java.util.*;

public class GridTraveler {
    public long waysToTravel(int x, int y) {
        if(x == 1 && y == 1) return 1;
        if(x == 0 || y == 0) return 0;
        return waysToTravel(x - 1, y) + waysToTravel(x, y - 1);
    }

    public long waysToTravelOptimized(int x, int y, Map<List<Integer>, Long> memo) {
        List<Integer> current = Arrays.asList(x, y);
        Optional<List<Integer>> exact = memo.keySet().stream().filter(list -> list.containsAll(current)).findFirst();
        if(exact.isPresent()) return memo.get(exact.get());
        if(x == 1 && y == 1) return 1;
        if(x == 0 || y == 0) return 0;
        Long res = waysToTravel(x - 1, y) + waysToTravel(x, y - 1);
        memo.put(current, res);
        return memo.get(current);
    }

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        System.out.println(new GridTraveler().waysToTravelOptimized(18,18, new HashMap<>()));
        Long finish = System.currentTimeMillis();
        System.out.println((start - finish) / 60 / 60 );

    }
}
