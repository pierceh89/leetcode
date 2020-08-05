package io.github.pierceh89.leetcode;

import java.util.*;

/**
 * 1418. Display Table of Food Orders in a Restaurant
 */
public class DisplayTable {
    class TableOrder {
        Map<String, Integer> order = new HashMap<>();
        int size=0;
        String table;
        TableOrder(String tablenum) {
            table = tablenum;
        }
    }
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, TableOrder> table = new HashMap<>();
        List<String> menus = new ArrayList<>();
        for(List<String> o : orders) {
            String t = o.get(1);
            String menu = o.get(2);
            TableOrder to = table.computeIfAbsent(t, key -> new TableOrder(key));
            Integer orderCount = to.order.computeIfAbsent(menu, key -> 0);
            to.order.put(menu, orderCount + 1);
            to.size++;
            if(!menus.contains(menu)) {
                menus.add(menu);
            }
        }
        Collections.sort(menus);
        List<List<String>> ret = new ArrayList<>();
        List<TableOrder> tos = new ArrayList<>(table.values());
        Collections.sort(tos, (to1, to2) -> Integer.parseInt(to1.table)-Integer.parseInt(to2.table));
        List<String> outmenu = new ArrayList<>(menus);
        outmenu.add(0, "Table");
        ret.add(outmenu);
        for(TableOrder to : tos) {
            List<String> outto = new ArrayList<>();
            outto.add(to.table);
            for(String m : menus) {
                if(to.order.containsKey(m)) {
                    outto.add(to.order.get(m).toString());
                } else {
                    outto.add("0");
                }
            }
            ret.add(outto);
        }
        return ret;

    }
}
