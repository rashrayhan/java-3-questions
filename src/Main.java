import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Stream;

public class Main {
	
	public static void main(String[] args) {
//		int[] n = {20, 21, 30, 40, 50, 51};
//		
//		 int result = findElementBinarySearch(n, 0, 5, 510);  
//	        if (result == 0)  
//	            System.out.println("Element is not found!");  
//	        else  
//	            System.out.println("Element is found at index: "+result);  
//	        
		
//		System.out.println(isAnagram("hello/..,,", "/ll..,,ohe"));
		System.out.println();
		
	}
	static boolean solution(String s) {  
        for (int i = 1; i < s.length(); i++) { 
            if (s.charAt(i) < s.charAt(i - 1)) { 
                return false; 
            } 
        } 
        return true;
	}
	
	public boolean solution(String[] A) {
		
		List<String> listOfStrings = new ArrayList<String>(A.length);
        Collections.addAll(listOfStrings, A);
        
        if (listOfStrings.size() <= 1) {
	        return true;
	    }
	 
	    Iterator<String> iter = listOfStrings.iterator();
	    String current, previous = iter.next();
	    while (iter.hasNext()) {
	        current = iter.next();
	        if (previous.compareTo(current) > 0) {
	            return false;
	        }
	        previous = current;
	    }
	    return true;
	}
	
	static String firstLastOdd(String s) {
		String first = "", last="";
		
		for (int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i)) && s.charAt(i) % 2 != 0) {
				if(first == "") {
					first = "" +s.charAt(i);
				}else {
					last = "" +s.charAt(i);
				}
				
				
			}
		}
		s = first + " and " + last;
		
		
		
		return s;
		
	}
	
	
	static boolean isAnagram(String word1, String word2) {
		if(word1.length() != word2.length()) return false;
		
		char[] w1 = word1.toCharArray();
		char[] w2 = word2.toCharArray();
		
		Arrays.sort(w1); Arrays.sort(w2);
		
		return Arrays.equals(w1, w2);
	}
	
	
	static int findElementBinarySearch(int[] number, int start, int end, int search) {
		
		if(end >= start) {
			int center = start + (end - start) /2;
			
			if(number[center] == search) {
				System.out.print("search found at index: ");
				return center;
			}
			
			if(number[center] > search) {
				System.out.println("search left ");
				return findElementBinarySearch(number, start, center-1, search);
			}else if(number[center] < search){
				System.out.println("search right ");
				return findElementBinarySearch(number, center+1, end, search);
			}
		}
		
		
		
		return 0;
	}
	
	static String deleteDuplicate(String word){
		Set<Character> charac = new HashSet<>();
		String stringBuilder = "";
		
		for(int i=0; i<word.length(); i++) {
			charac.add(word.charAt(i));
		}
		
		for (Character character : charac) {
			stringBuilder += character;
		}
		
		System.out.println(charac);
		
		
		return stringBuilder;
	}
	
	
	static Map<Character, Integer> charCounters(String word){
		Map<Character, Integer> counter = new HashMap<>();
		Map<Character, Integer> repeated = new HashMap<>();
		
		for(int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			if(counter.containsKey(c)) {
				counter.put(c, counter.get(c)+1);
				repeated.put(c, counter.get(c)+1);
			}else {
				counter.put(c, 1);
			}
		}
		
		
		
//		for (char c : word.toCharArray()) {
//			if(counter.containsKey(c)) {
//				counter.put(c, counter.get(c)+1);
//				repeated.put(c, counter.get(c)+1);
//			}else {
//				counter.put(c, 1);
//			}
//		}
//		
//		
		
		return repeated;
	}

	
	
	 public static long playlist(List<Integer> songs) {
		    // Write your code here
		 long counter =0;
		 int first = songs.get(0);
		 int second = songs.get(1);
		 
//		 System.out.println(first);
		 
		 for(int i = 0; i<songs.size(); i++) {
			 if(first + second == 60) {
				 counter ++;
				 first = songs.get(i++);
				 second = songs.get(i+2);
			 }
		 }
		return counter;

    }
	 
	 
	
	public static long numPairsDivisibleBy60(List<Integer> songs) {
        Map<Integer, Integer> count = new HashMap<>();
        long ans = 0;
        for (Integer t : songs) {
            int d = (60 - t % 60) % 60;
            if (count.containsKey(d)) { ans += count.get(d); } // in current HashMap, get the number of songs that if adding t equals to a multiple of 60.
            count.put(t % 60, 1 + count.getOrDefault(t % 60, 0)); // update the number of t % 60.
        }
     
        return ans;
    }

	
	public static int findAllPalindromesUsingBruteForceApproach(String s) {
		int counter =s.length();
		
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				if (isPalindromeChecker(s.substring(i, j))
						&& s.substring(i, j).length() >1
						) {
					counter++;
				}
			}
		}
		
		return counter;
	}
	
	private static boolean isPalindromeChecker(String input) {
	    StringBuilder text = new StringBuilder(input);
	    StringBuilder reverseText = text.reverse();
	    return (reverseText.toString()).equals(input);
	}
	
	
	
	
	public static int closedPaths(int number) {
	    // Write your code here
		int closedPaths = 0;
		
		String newNumber = "" + number;
		
		
		for(int i=0; i<newNumber.length(); i++) {
			int digit = Integer.parseInt(Character.toString(newNumber.charAt(i)));
			
			if(digit== 0 || digit== 4 || digit== 6 || digit== 9) {
				closedPaths++;
			}else if(digit== 8){
				closedPaths+=2;
			}
		
		}
		
		return closedPaths;

    }
	
	
	public static int addNumbers(float a, float b) {
	    // Write your code here
		return (int) Math.floor(a+b);
	}
	
	
	
	
	
	static int makeAnagram1(String a, String b) {
		
        char[] stringAArray = a.toCharArray();
        char[] stringBArray = b.toCharArray();
        
        int deletionCounter =0;
         
        Map<Character, Integer> storer = new HashMap<>();
        
        for(char c : stringAArray) {
            
            if(storer.containsKey(c)) {
                storer.put(c, storer.get(c)+1);
            }else {
                storer.put(c, 1);
            }
        }
        
        
        for(char c : stringBArray) {
            
            if(storer.containsKey(c)) {
                storer.put(c, storer.get(c)+1);
                deletionCounter++;
            }else {
                storer.put(c, 1);
                deletionCounter++;
            }
        }

         
        System.out.println(storer);
         
         return deletionCounter;

    }
	
	
	static int alternatingCharacters(String s) {
		
		int deletionCounter =0;
		
		
		for(int i=0; i< s.length()-1; i++) {
			if(s.charAt(i) == s.charAt(i+1)) {
				deletionCounter++;
			}
		}
		
		return deletionCounter;

    }
	
	
	static double squareRoot(double v) {
		if(v >= 0) {return Math.sqrt(v);}
		return v;
	}
	
	static double func(int x) {
		double y = (double) x;
		y*= -9.0;
		
		try {
			y = squareRoot(y);
		} catch (ArithmeticException e) {
			// TODO: handle exception
			y /= 3;
			
			
		}finally {
			y+=10;
		}
		return y;
	}
	
	
	static int[] integerSum(int[] n) {
		int[] summedN= new int[4];
		summedN[0] = n[0];
		summedN[1] = n[1] + n[2];
		summedN[2] = summedN[1] + n[3];
		summedN[3] = summedN[2] + n[4];
		
		
		return summedN;
	}
	
	static String addKbeforeFs(String text) {
		
		String newText="";
		
		for(int i =0; i<text.length(); i++) {
			if(text.charAt(i) == 'f' || text.charAt(i) == 'F') {
				newText += "K";
				newText += text.charAt(i);
			}
			else{
				newText += text.charAt(i);
			}
		}
		
		return newText;

	}

	
	
	static int makeAnagram(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
	 
		// len1+1, len2+1, because finally return dp[len1][len2]
		int[][] dp = new int[len1 + 1][len2 + 1];
	 
		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}
	 
		for (int j = 0; j <= len2; j++) {
			dp[0][j] = j;
		}
	 
		//iterate though, and check last char
		for (int i = 0; i < len1; i++) {
			char c1 = word1.charAt(i);
			for (int j = 0; j < len2; j++) {
				char c2 = word2.charAt(j);
	 
				//if last two chars equal
				if (c1 == c2) {
					//update dp value for +1 length
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					int replace = dp[i][j] + 1;
					int insert = dp[i][j + 1] + 1;
					int delete = dp[i + 1][j] + 1;
	 
					int min = replace > insert ? insert : replace;
					min = delete > min ? min : delete;
					dp[i + 1][j + 1] = min;
				}
			}
		}
	 
		return dp[len1][len2];
    }
	
	
	
	
//	static void staticBlock() {
//		private static boolean flag;
//		private static int B;
//		private static int H;
//
//		static {
//		    
//			Scanner sc = new Scanner(System.in);
//			B = sc.nextInt();
//			H = sc.nextInt();
//			
//			if(B <= 0 || H <= 0) {
//				flag = false;
//				System.out.println("java.lang.Exception: Breadth and height must be positive");
//			}else {		
//				flag = true;
//			}
//		}
//		
//		public static void main(String[] args) {
//			Scanner sc = new Scanner(System.in);
////	        String t=sc.nextInt();
//			
//			if(flag){
//				int area=B*H;
//				System.out.print(area);
//			}
//	        
//		
//	}
	
	static void eof() {
		Scanner sc = new Scanner(System.in);
		int counter = 1;
		while(sc.hasNext()) {
			System.out.println(counter + " " +  sc.nextLine());
			counter++;
		}
	}
	static void dataTypes() {
		Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        for(int i=0;i<t;i++){

            try
            {
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");
                if(x>=-128 && x<=127)System.out.println("* byte");
                //Complete the code
                if(x>=-32768 && x<=32767)System.out.println("* short");
                if(x>=Math.pow(-2, 31) && x<=Math.pow(2, 31)-1)System.out.println("* int");
                if(x>=Math.pow(-2, 63) && x<=Math.pow(2, 63)-1)System.out.println("* long");
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }

        }
	}
	
	static void polynomial() {
		int current =0;
        int k = 2;
        Scanner in = new Scanner(System.in);
        
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            
            current = a+ (1*b);
       
            System.out.print(current + " ");
            for(int j =1; j<n; j++) {
                
                current = current + b*k;
                
                k = k*2;
                System.out.print(current + " "); 
                  
        }
        System.out.println(); 
         k =2; current =0;
        }
        in.close();
	}
	
	static void printFormart() {
		Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++)
        {
            String s1=sc.next();
            int x=sc.nextInt();
            //Complete this line
            System.out.printf("%-15s" + "%03d %n", s1, x);
        }
        System.out.println("================================");
	}
	
	static boolean checkBlanagrams(String word1, String word2) {
		 int[] letters = new int[26];
		 int flag = 0;

	        for(int i = 0; i < word1.length(); i++){
	        	letters[word1.charAt(i)-'a']++;
	        	letters[word2.charAt(i)-'a']--;
	        }

	      for(int i : letters) {
	    	  flag += Math.abs(i);
	      }
	      
	      
	     return flag ==2;

	}
	
	
	static String[] addBorder(String[] picture) {
		String[] modifiedPicture = new String[picture.length + 2];
		int size;
		if(picture[0] != null) {
			size = picture[0].length();
			
			modifiedPicture[0] = starGenerator(size);
			
			modifiedPicture[modifiedPicture.length-1] = starGenerator(size);
		}
		
		
		for(int i =0; i<picture.length; i++) {
			modifiedPicture[i+1] = "*"+picture[i]+"*";
		}
		return modifiedPicture;
	}
	
	static String starGenerator(int size){
		String stars= "";
		for(int i=0; i<size+2; i++) {
			stars+="*";
		}
		return stars;
	}

	
	
	
	static String[] fizzBuzz(int n) {
		String[] modifiedArray;
		
		String[] values = new String[n+1];
		values[0] = null;
		
		for(int i=1; i<values.length; i++) {
			System.out.println(i);
			if((i%3 == 0) && (i%5 == 0)) {
				values[i] = "FizzBuzz";
				}else if(i % 3 ==0) {
				values[i] = "Fizz";
			}else if(i%5 == 0) {
				values[i] = "Buzz";
			}else {
				values[i] = ""+i;
			}		
		}
		
		modifiedArray = Arrays.copyOfRange(values, 1, values.length);
		
		return modifiedArray;

	}

	
	
	
	static String removeVowels(String s) {
		return s.replaceAll("[aeiouAEIOU]", "");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	hck1DataType();
//	hck2mealCost(meal_cost, tip_percent, tax_percent);
//	hck3Conditionals(4);
//	hck4Loop(2);
//	hck5Review("Rasheed");
//	hck6ArrayReverse();
//	hck7Map();
//	System.out.println(hck8FactorialRecursion(1));
//	hck9IntegerToBinary(13);
	
	static void hck12Inheritance() {}
	static void hck9IntegerToBinary(int n) {
		String binary = Integer.toBinaryString(n);
		String[] split = binary.split("0");
		int maxOnes = 0;
		
		for(int i=0; i<split.length; i++) {
			if(split[i].length() > maxOnes)
				maxOnes = split[i].length();
		}
		
		System.out.println(maxOnes);
	}
	static int hck8FactorialRecursion(int n) {
		if(n<=1) return 1;
		if(n==2) return n;
		return n * hck8FactorialRecursion(n-1);
	}
	static void hck7Map() {
		Map<String, String> myMap = new HashMap<>();
		
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            myMap.put(name, name+"="+phone);
        }
        
        while(in.hasNext()){
            String s = in.next();
            // Write code here
            if(myMap.containsKey(s)) {
               	System.out.println(myMap.get(s));
           }else {
               	System.out.println("Not found");
           }
        }
        in.close();
        
	}
	
	
	static void hck5Review(String s) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			hck5Review(sc.next());
		}
		
		
		StringBuilder sbEven = new StringBuilder();
		StringBuilder sbOdd = new StringBuilder();
		
		char[] ch = s.toCharArray();
		
		for(int i =0; i<s.length(); i++) {
			if(i%2==0) {
				sbEven.append(ch[i]);
			}else {
				 sbOdd.append(ch[i]);
			}
		}
		
		System.out.println(sbEven + " " + sbOdd);
	}
	
	static void hck4Loop(int n) {
		for(int i =1; i <= 10; i++) {
			System.out.println(n + " * " + i + " = " + n * i);
		}
	}
	
	static void hck3Conditionals(int n) {
		if(n%2 != 0) {
			System.out.println("Weird");
		}else if(n%2==0 && n>= 2 && n<=5){
			System.out.println("Not Weird");
		} else if(n%2 ==0 && n>=6 && n<=20) {
			System.out.println("Weird");
		}else if(n%2==0 &&n>20) {
			System.out.println("Not Weird");
		}
		
		
	}
	
	static void hck2mealCost(double meal_cost, int tip_percent, int tax_percent) {
		
		int totalCost = (int) Math.round((meal_cost + (meal_cost*((double)tip_percent/100)) + (meal_cost*((double)tax_percent/100))));
		
		System.out.println(totalCost);
		

    }
		
	static void hck1DataType() {
		int i = 4;
	    double d = 4.0;
	    String s = "HackerRank ";
		
	    Scanner scan = new Scanner(System.in);
	    
	    /* Declare second integer, double, and String variables. */
	
	    /* Read and save an integer, double, and String to your variables.*/
	    // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.
	    
	    /* Print the sum of both integer variables on a new line. */
	    /* Print the sum of the double variables on a new line. */
	    /* Concatenate and print the String variables on a new line; 
		the 's' variable above should be printed first. */
	   
	    int k = scan.nextInt();
	    double j = scan.nextDouble();
	    String m= scan.next();
	    m += scan.nextLine();
	    
	    
	    System.out.println(k+i);	
		System.out.println(j+d);
		System.out.println(s + "" +m);
		
	    scan.close();
	    }
	
	
	static int isRapidlyIncreasing(int[ ] a) {
		
		int sumPrevious= a[0];
		int sumMultiplePrevious = sumPrevious*2;
		
		for(int i=1; i<a.length; i++) {
			if(a[i] > sumMultiplePrevious)
				sumPrevious += a[i];
			
			sumMultiplePrevious = sumPrevious*2;
		}
		
		return 1;
	}
	
	static int  computeWeightedSum(int[ ] a) {
		
		int sumEven= 0;
		int sumOdd= 0;
		int sumTotal=0;
		
		for(int i=0; i<a.length; i++) {
			if(a[i] % 2 ==0) {
				sumEven += a[i];
			}else {
				sumOdd += a[i];
			}
		}
		
		sumTotal = (2 * sumEven)+ (3 * sumOdd);
		return sumTotal;
		
	}
	
	
	//Question 4: GCD
	public static int gcd(int m, int n) {
		if (n == 0)
			return m;
		return gcd(n, m % n);
	}
	
	//Qeustion 5: Second Smallest
	public static int secondSmallest(int[] arr) {
		int smallest = arr[0];
		int sec_small = arr[1];
		
		if (arr == null || arr.length < 2) {
			throw new IllegalArgumentException("Input array too small");
		}
		
		for(int i=1; i < arr.length; i++){
			if(arr[i] <=smallest){
				sec_small = smallest;
				smallest = arr[i];
			}
			else if(arr[i] < sec_small) {
				sec_small = arr[i];
			}
		}
		return sec_small;
	}
	
	//Question 1: ReverseWord
	public static String reverse(String str){
		
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		
		
		for (int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			stack.push(c);
			if (' ' == c || i == str.length()-1) {
				if (i == str.length() -1)
					stack.push(' ');
				while(!stack.isEmpty())
					sb.append(stack.pop());
			}
		}
		return sb.toString();
	}

	//dynamic programming fibonnaci
	public static int fib(int n) {
		int[] f = new int[n+3];
		
		f[0] = 0;
		f[1] = 1;
		
		for(int i=2; i<=n; i++) {
			f[i] = f[i-1] + f[i-2];
		}
		
		return f[n];
	}

}
