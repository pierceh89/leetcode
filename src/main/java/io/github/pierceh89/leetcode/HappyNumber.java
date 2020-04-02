package io.github.pierceh89.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 202. Happy Number
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        if(n == 1) {
            return true;
        }
        List<Integer> numbers = new ArrayList<>();
        while(n != 1) {
            int next = getNext(n);
            if(numbers.contains(next)) {
                return false;
            }
            numbers.add(next);
            n = next;
        }
        return true;
    }

    public int getNext(int n) {
        int sum = 0;
        while(n > 0) {
            int mod = n%10;
            sum += mod*mod;
            n = n/10;
        }
        return sum;
    }
}
