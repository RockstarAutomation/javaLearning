package cuncurrency;

import lombok.Data;
import lombok.Getter;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

@Getter
public class StandardTask extends RecursiveTask<Long> {
    private final Problem problem;
    private final int l;
    private final int r;
    private final int THREASHOLD = 10;

    public StandardTask(Problem problem, int l, int r) {
        this.problem = problem;
        this.l = l;
        this.r = r;
    }

    @Override
    protected Long compute() {
        if(r - l <= THREASHOLD) {
            return problem.solve(l, r);
        }
        int mid = (l + r) >>> 1;
        ForkJoinTask<Long> t1 = new StandardTask(problem, l, mid);
        ForkJoinTask<Long> t2 = new StandardTask(problem, mid, r);

        ForkJoinTask.invokeAll(t1, t2);

        long res = 0;
        res += t2.join();
        res += t1.join();
        return res;
    }

    @Data
    public static class Problem {
        public Long solve(int l, int r) {
            System.out.println("Thread id: " + Thread.currentThread().getId() + " SOLVED");
            return Long.sum(l, r);
        }
    }
}
