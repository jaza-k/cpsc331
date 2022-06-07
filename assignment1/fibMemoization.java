// Jaza Khan UCID 30119100
// CPSC 331 Assignment 1
// Tutorial 03

import java.math.BigInteger;
import java.util.*; 

/**
 * fibMemoization.java class, contains recursive algorithm to compute nth Fibonacci term using memoization
 * @author Jaza K.
 *
 */
public class fibMemoization {
	/**
	 * fibMemoization() recursive method which returns the nth fibonacci number
     * 
	 * Precondition: input is a non-negative integer, n >= 0
     * Postcondition: returns the nth fibonacci number
     * 
	 * @param n the nth term of the Fibonacci sequence to be calculated
	 * @return answer a BigInteger value which is the nth Fibonacci number
	 */
	public static BigInteger fibMemoization(int n, Map <Integer, BigInteger> calculatedVals) {
	
		// tests for base cases n = 0 and n = 1
        if (n == 0) return BigInteger.ZERO;
		if (n == 1) return BigInteger.ONE;
	
        // if value exists in map, return it
		if (calculatedVals.get(n) != null) {
			return calculatedVals.get(n);
		}
        // otherwise calculate it by recursion
		else {
			// recursive function call, result of which gets stored in answer
			BigInteger answer = (fibMemoization(n-2, calculatedVals).add(fibMemoization(n-1, calculatedVals)));
            // store the calculated value in the map
			calculatedVals.put(n, answer);
            // return the calculated value
			return answer;
		}
	}
}