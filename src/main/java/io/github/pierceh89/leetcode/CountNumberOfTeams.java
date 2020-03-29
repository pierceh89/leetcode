package io.github.pierceh89.leetcode;

/**
 * 1395. Count Number of Teams
 */
public class CountNumberOfTeams {
    public int numTeams(int[] rating) {
        int count=0;
        int sz = rating.length;
        for(int i=0; i<sz-2; i++) {
            for(int j=i+1; j<sz-1; j++) {
                for(int k=j+1; k<sz; k++) {
                    if((rating[i]<rating[j] && rating[i]<rating[k] && rating[j]<rating[k]) ||
                            (rating[i]>rating[j] && rating[i]>rating[k]) && rating[j]>rating[k]){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
