package com.shrikant.problems.strings;

//Integer is signed hence the value MIN_VALUE = -2^31 (2147483648) & MAX_VALUE = 2^31-1 (i.e. 2147483647), ONE BIT IS USED FOR SIGN
//Return zero if reversed value is less than or more than MAX_INT OR MIN_INT values.
//Note , not to use parseInt methods or convert to string et.
public class ReverseAnInteger {
    
    public int reverseInteger(int x) {

        int xRev = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;

            if (xRev > 0 && xRev > Integer.MAX_VALUE / 10 || xRev > 0 && xRev == Integer.MAX_VALUE/10 && pop > 7) return 0;
            if (xRev < 0 && xRev < Integer.MIN_VALUE / 10 || xRev > 0 && xRev == Integer.MIN_VALUE/10 && pop < -8) return 0; 
            
            xRev = xRev * 10 + pop;     
        }

        return xRev;
    }
}
