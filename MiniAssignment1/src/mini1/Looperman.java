package mini1;

import java.util.Scanner;

/**
 * Utility class with a bunch of static methods for loop practice.
 * @author Hoang Phuong Nguyen
 */
public class Looperman
{

  // disable instantiation
  private Looperman() {}
  
  /**
   * Returns a string obtained from the given string by doubling all the vowels.
   * For example, given the string "Aardvark", the method returns "AAaardvaark".
   * @param s
   *   given string
   * @return
   *   a new string with all vowels doubled
   */
  public static String doubleAllVowels(String s)
  {
	  String result = "";
	  for (int i = 0; i < s.length(); ++i) {
		  
		  char ch = s.charAt(i);	  
		  result = result + ch;
		  
		  if ("aeiouAEIOU".indexOf(ch) >= 0) {	//check if "ch" is vowel 
			  
	    		result = result + ch;
		  }
	  }
    return result;
  }

  
  /**
   * Returns the number of iterations required until <code>n</code>
   * is equal to 1, where each iteration updates <code>n</code> in the following
   * way:
   * <pre>
   *     if n is even
   *         divide it in half
   *     else
   *         multiply n by three and add 1
   * </pre>
   * For example, given <code>n == 6</code>, the successive values
   * of <code>n</code> would be 3, 10, 5, 16, 8, 4, 2, 1, so the method returns 8.
   * If <code>n</code> is less than 1, the method returns -1.
   * <p>
   * <em>(Remark:</em> How do we know this won't be an infinite loop for some values of
   * <code>n</code>?  In general, we don't: in fact this is a well-known open problem in 
   * mathematics.  However, it has
   * been checked for numbers up to 10 billion, which covers the range of possible values 
   * of the Java <code>int</code> type.)  
   * @param n
   *     given starting number
   * @return
   *     number of iterations required to reach <code>n == 1</code>, or
   *     -1 if <code>n</code> is not positive
   */
  public static int collatzCounter(int n)
  {
	  int count = 0;
	  
	  while (n > 1) { 
		  if (n % 2 == 0) {
			  
			  n = n / 2;
			  count += 1;
		  }
		  else {
			  
			  n = n*3 + 1;			  
			  count += 1;
			  
		  }
		  if (n == 1) {
			  break;
		  }
	  }
	  if (n < 1) {
		  
		  return -1;
	  }  
	  return count;
  }
  
  
  /**
   * Given a string consisting of a name followed by numbers, returns a 
   * string consisting of the name, followed by a colon and space,
   * followed by the average of the numbers.  For example, given the string
   * <pre>
   * "Edna von Humboldt van der Scooch 10 20 30 40", 
   * </pre>
   * returns the string
   * <pre>
   * "Edna von Humboldt van der Scooch: 25.0"
   * </pre>
   * There is always at least one token for the name and at least one number.
   * The resulting string should have exactly one space between the parts of the name,
   * and should not have any leading or trailing spaces.
   * @param text
   *   string to be parsed
   * @return
   *   name followed by colon, space, and the average of the numbers
   */
  public static String parseNameNumbers(String text)
  {
	  Scanner sc = new Scanner(text);
	  
	  double total = 0.0;
	  int count = 0;
	  String name = sc.next();
	  
	  while (sc.hasNext()) {
		  
		  if (sc.hasNextInt()) {	//if next is number
			  
			  int num = sc.nextInt();
			  total += num;
			  count += 1;
		  }
		  else {					//if next is string
			  name = name + " " + sc.next();
		  }
	  }
	  return name + ": " + total/count;
  }
  
  /**
   * Returns true if string t can be obtained from string s by inserting
   * exactly two characters.  For example, given "banana" and "bannanaa", 
   * the method returns true.
   * @param s
   *   shorter string
   * @param t
   *   longer string
   * @return
   *   true if you can insert two characters into s to make it equal t
   */
  public static boolean differByTwoInsertions(String s, String t)
  {
	  boolean result = false;
	  String a = "";
	  String b = "";
	  int count = 0;
	  
	  if (t.length() - s.length() == 2) {		//length(t) must bigger than length(s) 2
		  for (int i = 0; i < s.length() ; ++i) {
			  
			  char first = s.charAt(i);			//check every single char
			  char second = t.charAt(i);
			  
			  if (first != second) {
				  
				  a = s.substring(i, s.length());
				  b = t.substring(i + 1, t.length());
				  
				  count += 1;  
				  s = a;
				  t = b;
				  i = -1;
			  }
			  if (count == 2) {
				  break;
			  }
		  }
		  if (a.equals(b) || count == 1) {
			  result = true;
		  }
	  }
	  else {
		  result = false;
	  }
	  return result;  
  }
  
  /**
   * Given a string, returns a new string in which text between 
   * the character '+' and the next '-' is converted to uppercase.
   * Any '+' characters encountered while converting to uppercase
   * are ignored, and likewise, any '-' characters encountered
   * without a corresponding preceding '+' are also ignored.
   * If a '+' is encountered that would ordinarily not be ignored, but
   * there is no matching '-' anywhere in the rest of the string, that 
   * '+' is ignored.
   * <p>
   * For example, 
   * <ul>
   * <li> given string "aa+rdv-ark" returns "aaRDVark"
   * <li> given string "aa+r++++dv-a+---+-+r-+k" returns "aaRDVaRk"
   * </ul>
   * @param s
   *   any string
   * @return
   *   new string in which text between matching '+' and '-' characters
   *   has been converted to uppercase
   */
  public static String plusMode(String s)
  {
	  
	  String upperfied = "";
	  int j = 0;
	  
	  for (int i = 0; i < s.length(); ++i) {
		  
		  char ch = s.charAt(i);
		  
		  if (ch == '+') {
			  String sub = s.substring(i + 1, s.length());
			  if (sub.indexOf('-') > 0) {
				  
				  for (j = i + 1; j < s.length(); ++j) {
					  ch = s.charAt(j);
					  
					  if (ch == '+') {
						  continue;
					  }
					  
					  if (ch == '-') {
						  break;
					  }
					  upperfied = upperfied + ("" + ch).toUpperCase();
				  }
				  i = j;
				  continue;
			  }
			  else {
				  continue;
			  }
		  }
		  else if (ch == '-') {
			  continue;
		  }
		  upperfied = upperfied + ch;
	  }
	  return upperfied;
  }
  
  /**
   * Returns a new string in which any vowel appearing by itself
   * is doubled, but groups of adjacent vowels are left alone.
   * For example, given the string "beautiful", returns "beautiifuul".
   * @param s
   *   any string
   * @return
   *   new string in which vowels are doubled, unless already part of a group
   *   of multiple vowels
   */
  public static String doubleVowelsMaybe(String s)
  {
	  String result = "";
	  String temp = "";
	  int i = 0;
	  int count = 0;
	  	  
	  for (i = 0; i < s.length() ; i += 1) {
		  
		  char c = s.charAt(i);
		  
	      if ("aeiouAEIOU".indexOf(c) >= 0) {
	    	  
	    	  count += 1;
	    	  temp = temp + c;
	      }
	      else {
	    	  
	    	  if (count == 1) {
	    		  result = result + s.charAt(i-1) + s.charAt(i-1);
	    		  count = 0;
	    		  temp = "";
	    	  }
	    	  else if (count > 1) {
	    		  result = result + temp;
	    		  count = 0;
	    		  temp = "";
	    	  }    	  
	      }
	      
	      if (count == 0) {
    		  result = result + c;
    	  }
	  }
	  if (count == 1) {
		  result = result + s.charAt(i-1) + s.charAt(i-1);
		  count = 0;
		  temp = "";
	  }
	  else if (count > 1) {
		  result = result + temp;
		  count = 0;
		  temp = "";
	  }    	  
    return result;
  }
  
  
  /**
   * Prints a pattern of n rows containing slashes, backslashes, 
   * underscores and stars, as illustrated below for n = 6.  
   * Note that the bottom row starts and ends with exactly n underscores.
   * 
   * <pre>    
   *            /\
   *           /**\
   *          /****\
   *         /******\
   *        /********\
   * ______/**********\______
   * </pre>
   * 
   * @param n
   *   number of rows in the output
   */
  public static void witchHat(int n)
  {
	  int i = 0;
	  int j = 0;
	  for (i=0 ; i < n; ++i) {
		  
		  for (j = 2*n - i; j > 1 ; --j) {
			  
			  if (i == n - 1) {
				  
				  System.out.print("_"); 
			  }
			  else {
				  
				  System.out.print(" ");
			  }
		  }
		  System.out.print('/');
		  
		  for (int k = 1 ; k <= i ; ++k) {
			  
			  System.out.print("**");
		  }
		  
		  System.out.print('\\');
		 
		  if (i == n - 1) {
			  
			  for (int m = i + j; m < 2*n + j - 1; ++m) {
				  
				  System.out.print("_");
			  }
		  }
		  System.out.println();
	  }
	  if (n == 0) {
		  System.out.print("/\\");
	  }
  }
  public static void main(String[] args) {
	  int n = 2;
	  witchHat(n);
  }
}
