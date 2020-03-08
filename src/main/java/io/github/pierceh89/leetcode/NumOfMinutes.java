package io.github.pierceh89.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1376. Time Needed to Inform All Employees
 * Time Complexity is O(n)
 * To Create Children Map -> O(n)
 * To traverse child nodes -> O(n)
 */
public class NumOfMinutes {
    public static class TreeNode {
        int id;
        int t;
        TreeNode[] children;
        TreeNode(int id, int t) {
            this.id=id;
            this.t =t;
        }
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if(n==0) {
            return 0;
        }
        if(n==1) {
            return informTime[0];
        }
        // make tree
        TreeNode root = new TreeNode(manager[headID], informTime[headID]);
        Map<Integer, List<TreeNode>> childrenListMap = new HashMap<>();
        for(int i=0; i<n; i++) {
            if (i==headID) {
                continue;
            }
            List<TreeNode> nodes = childrenListMap.computeIfAbsent(manager[i], k -> new ArrayList<>());
            nodes.add(new TreeNode(i, informTime[i]));
        }
        return computeTime(headID, informTime[headID], childrenListMap);
    }

    public int computeTime(int id, int time, Map<Integer, List<TreeNode>> map) {
        if(!map.containsKey(id)) {
            return time;
        }
        List<TreeNode> children = map.get(id);
        int maxChildTime=0;
        for(TreeNode node : children) {
            int childTime = computeTime(node.id, node.t, map);
            if (maxChildTime < childTime) {
                maxChildTime = childTime;
            }
        }
        return time+maxChildTime;
    }
}
