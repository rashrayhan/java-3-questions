import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

class Fab {
	
    static Solution solution(int amount){
    	
        int[] counts = {0,0,0};
        int[] denominations= {10,5,2};
        int sum =0;
        for (int i = 0; i < 3; i++) {
            counts[i] = (int) Math.floor(amount / denominations[i]);
            amount -= counts[i] * denominations[i];
            sum +=counts[i] * denominations[i];
        }
    
        Solution c = new Solution();
        c.coin2 = counts[2];
        c.bill5 = counts[1];
        c.bill10 = counts[0];
    
        return sum == amount ? c: null;
    }

    
    
    public static void main(String[] args){
        System.out.println(solution(12));
        System.out.println("hello");
    }
 }

class Solution{
	long coin2 = 0;
    long bill5 = 0;
    long bill10 = 0;

}



