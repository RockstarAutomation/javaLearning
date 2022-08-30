package algoritms;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public static void main(String[] args) {
        long res = new Fibonacci().optimaizedFib(50, new HashMap<>());
        System.out.println(res);
    }

    public int classicFib(int x){
        if(x <= 2) return 1;
        return classicFib(x - 2) + classicFib(x - 1);
    }

    public long optimaizedFib(int x, Map<Integer,Long> memo){
        if(memo.containsKey(x)) return memo.get(x);
        if(x <= 2) return 1;
        long res = optimaizedFib(x - 1, memo) + optimaizedFib(x - 2, memo);
        memo.put(x, res);
        return memo.get(x);
    }
}
