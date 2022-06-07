// Jaza Khan UCID 30119100
// CPSC 331 Assignment 1
// Tutorial 03

import java.math.BigInteger;

/**
 * fibAlgorithms.java class, contains three algorithms for computing the nth Fibonacci term
 * @author Jaza K.
 * 
 */
public class fibAlgorithms {
    /**
     * Fib1() method for calculating the nth Fibonacci term
     * 
     * Precondition:  n is a non-negative integer
     * Postcondition: nth Fibonacci term is returned after which program terminates
     * 
     * @param n the nth term of the Fibonacci sequence to be calculated
     * @return a BigInteger which is the nth term of the Fibonacci sequence
     */
    public static BigInteger Fib1(int n) {
        if (n < 2) {
            return BigInteger.valueOf(n);
        }
        else {
            return Fib1(n-1).add(Fib1(n-2));
        }
    }

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