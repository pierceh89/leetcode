package io.github.pierceh89.leetcode;

/**
 * 5381. Queries on a Permutation With Key
 */
public class QueriesOnPermutation {
    public int[] processQueries(int[] queries, int m) {
        int[] perm = new int[m];
        int[] ret = new int[queries.length];
        for(int i=0; i<m; i++) {
            perm[i]=i+1;
        }
        for(int i=0; i<queries.length; i++) {
            int q = queries[i];
            int indexOf = indexOf(perm, q);
            move(perm, indexOf);
            ret[i] = indexOf;
        }
        return ret;
    }

    public int indexOf(int[] arr, int val) {
        int i=-1;
        for(int j=0; j < arr.length; j++) {
            if(arr[j]==val) {
                return j;
            }
        }
        return i;
    }

    public void move(int[] arr, int indexOf) {
        int val = arr[indexOf];
        for(int i=indexOf; i>0; i--) {
            arr[i]=arr[i-1];
        }
        arr[0]=val;
    }
}
