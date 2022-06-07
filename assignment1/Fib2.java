// Jaza Khan UCID 30119100
// CPSC 331 Assignment 1
// Tutorial 03

import java.math.BigInteger;

/**
 * Fib2.java class, contains iterative algorithm for 
 * computing the nth Fibonacci term
 * @author Jaza K.
 *
 */
public class Fib2 {
    /** 
     * Fib2() method for calculating the nth Fibonacci term
     * 
     * Precondition:  n is a non-negative integer
     * Postcondition: nth Fibonacci term is returned after which program terminates
     * 
     * @param n the nth term of the Fibonacci sequence to be calculated
     * @return a BigInteger which is the nth term of the Fibonacci sequence
     */
    public static BigInteger Fib2(int n) {
        BigInteger i = BigInteger.ONE;
        BigInteger j = BigInteger.ZERO;

        for (int k = 1; k <= n; k++) {
            j = i.add(j);
            i = j.subtract(i);
        }
        return j;
    }
}