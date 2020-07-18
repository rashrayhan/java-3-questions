import java.util.ArrayList;
import java.util.List;

public class LekeExam {

    public static void main(String[] args) {
        System.out.println(closestFibonacci(12));

    }

    static int closestFibonacci(int n){
        if(n < 1) return 0;
        else {
            int closestFibonacci = 0;
            if (n > 0) {
                int a = 0, b = 1, c = a + b;

                do {
                    a = b;
                    b = c;
                    c = a + b;
                    if (c >= n) {
                        closestFibonacci = b;
                    }
                } while (c <= n);
            }
            return closestFibonacci;
        }
    }

    static int sameNumberOfFactors(int n1, int n2){
        if(n1 < 0 || n2 < 0) return -1;
        else if(factorCounter(n1) == factorCounter(n2)){
            return 1;
        }
        return 0;
    }

    static int factorCounter(int number){
        int counter=0;
        for(int i = 1; i <= number; ++i) {
            if (number % i == 0) {
                counter++;
            }
        }
        return counter;
    }

    static int isRapidlyIncreasing(int[ ] a) {
        int sumPrevious= a[0];
        int sumMultiplePrevious = sumPrevious*2;
        for(int i=1; i<a.length; i++) {
            if(a[i] > sumMultiplePrevious){
                sumPrevious += a[i];
                sumMultiplePrevious = sumPrevious*2;
            }else{
                return 0;
            }
        }
        return 1;
    }
}
