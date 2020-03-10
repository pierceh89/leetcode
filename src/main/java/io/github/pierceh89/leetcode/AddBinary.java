package io.github.pierceh89.leetcode;

/**
 * 67. Add Binary
 *
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int addr=0;
        StringBuilder sb = new StringBuilder();
        int sza = a.length();
        int szb = b.length();
        int i=0;
        while(i <  sza || i < szb) {
            int ca = sza-i-1 >= 0 ?
                    Integer.parseInt(a.substring(sza-i-1, sza-i)) : 0;
            int cb = szb-i-1 >= 0 ?
                    Integer.parseInt(b.substring(szb-i-1, szb-i)) : 0;
            int sum = ca+cb+addr;
            switch(sum) {
                case 0:
                case 1:
                    sb.append(sum);
                    addr=0;
                    break;
                case 2:
                    sb.append(0);
                    addr=1;
                    break;
                case 3:
                    sb.append(1);
                    addr=1;
                    break;
                default:
                    break;
            }
            i++;
        }
        if (addr != 0) {
            sb.append(addr);
        }
        return sb.reverse().toString();
    }
}
