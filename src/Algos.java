import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Algos {
	public static void main(String[] args) {
		ArrayList<Integer> ele = new ArrayList<>(Arrays.asList(1, 10, 1, 2, 2, 3, 10, 3, 3, 4, 5, 5));
//		ArrayList<String> eleString = new ArrayList<>(Arrays.asList("four", "two", "three", "one", "two"));
		
//		String s = "hello world";
//		reverseSentence(s);
		
		System.out.println(isArmstrong(12));
	}
	
	static boolean isArmstrong(int n) {
		int temp = n;
		int sum = 0; 
		  
        while (temp != 0) { 
            sum = (int) (sum + Math.pow((temp % 10), 3)); 
            temp = temp / 10; 
        } 
	    
        return sum == n; 
	}
	
	static int fibonacci(int n) {
//		int[] dp = new int[n+2];
//		dp[0] = 0; dp[1] = 1;
//		for(int i=2; i<=n; i++) {
//			dp[i] = dp[i-1] + dp[i-2];
//		}
//		return dp[n];
		
		if(n==0 || n==1) return n;
		
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	static void reverseSentence(String s) {
		String[] s2 = s.split(" ");
		StringBuilder sNew = new StringBuilder();
		
		for(int i= s2.length-1; i>=0; i--) {
			sNew.append(s2[i] + " ");
		}
		System.out.println(sNew.substring(0, sNew.length()-1));
	}
	
	static String reverse(String s) {
		if(s == "") return "null";
		
		StringBuilder newS = new StringBuilder();
		newS.append(s);
		newS.reverse();
		
		s = newS.toString();
		
		return s;
	}
	
	static boolean isPalindrome(String s) {
		
		for(int i=0; i<s.length()/2; i++) {
			if(s.charAt(i) != s.charAt(s.length()-i-1)) {
				return false;
			}
		}
		return true;
	}
	
	
	static <T> ArrayList<T> removeDuplicate(ArrayList<T> arr){
//		Set<T> elements = new LinkedHashSet<>();
//		elements.addAll(arr);
//		arr.clear();
//		arr.addAll(elements);

		return (ArrayList<T>) arr.stream().distinct().collect(Collectors.toList());
		
//		return arr;
	}
	
	static boolean split53(int[] nums) {
        return split53Helper(0, nums, 0, 0);
	}
	 
	static boolean split53Helper(int start, int[] nums, int mult5, int mult3) {
	    if(start >= nums.length)
	        return mult5 == mult3;
	
	    if(nums[start] % 5 == 0)
	        return split53Helper(start+1, nums, mult5 + nums[start], mult3);
	
	    if(nums[start] % 3 == 0)
	        return split53Helper(start+1, nums, mult5, mult3 + nums[start]);
	
	    if(split53Helper(start+1, nums, mult5 + nums[start], mult3))
	        return true;
	
	    if(split53Helper(start+1, nums, mult5, mult3 + nums[start]))
	        return true;
	
	    return false;
	}
	
	public static int sumDigits(String str) {
		int sum=0;
		
		for(int i=0; i<str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) {
				sum += Integer.parseInt(String.valueOf(str.charAt(i)));
				System.out.println(str.charAt(i));
			}
		}
		
		return sum;
	}
	static String parenBit(String str) {
		if(str.length() ==0) return str;
		if(str.charAt(0) == '(') {
			if(str.charAt(str.length()-1) == ')') {
				return str;
			}else {
				return parenBit(str.substring(0, str.length()-1));
			}
		}
		return parenBit(str.substring(1));
	}
}
