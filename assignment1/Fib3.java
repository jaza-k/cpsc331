// Jaza Khan UCID 30119100
// CPSC 331 Assignment 1
// Tutorial 03

import java.math.BigInteger;

/**
 * Fib3.java class, contains iterative algorithm for 
 * computing the nth Fibonacci term
 * @author Jaza K.
 *
 */
public class Fib3 {
    /**
     * Fib3() method for calculating the nth Fibonacci term
     * 
     * Precondition:  n is a non-negative integer
     * Postcondition: nth Fibonacci term is returned after which program terminates
     * 
     * @param n the nth term of the Fibonacci sequence to be calculated
     * @return a BigInteger which is the nth term of the Fibonacci sequence
     */
    public static BigInteger Fib3(int n) {
        BigInteger i = BigInteger.ONE;
        BigInteger h = BigInteger.ONE;
        BigInteger k = BigInteger.ZERO;
        BigInteger j = BigInteger.ZERO;
        BigInteger t;

        while (n > 0) {
            if (n % 2 != 0) {
                t = j.multiply(h);
                j = (i.multiply(h)).add((j.multiply(k))).add(t);
                i = (i.multiply(k)).add(t);
                n--;
            }
            else {
                t = h.multiply(h);
                h = (BigInteger.TWO.multiply(k).multiply(h)).add(t);
                k = k.multiply(k).add(t);
                n = n/2;
            }
        }
        return j;
    }   
}