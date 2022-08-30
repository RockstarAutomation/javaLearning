package algoritms;

import java.util.Arrays;

public class CanSum {

    public boolean canSum(int target, int[] nums){
        if(Arrays.stream(nums).anyMatch(x -> x == target)) return true;
        return false;
    }
}
