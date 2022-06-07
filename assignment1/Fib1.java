// Jaza Khan UCID 30119100
// CPSC 331 Assignment 1
// Tutorial 03

import java.math.BigInteger;

/**
 * Fib1.java class, contains recursive algorithm for 
 * computing the nth Fibonacci term
 * @author Jaza K.
 *
 */
public class Fib1 {
    /**
     * Fib1() method for calculating the nth Fibonacci term
     * 
     * Precondition:  n is a non-negative integer
     * Postcondition: nth Fibonacci term is returned after which program terminates
     * 
     * @param n the nth term of the Fibonacci sequence to be calculated
     * @return a BigInteger which is the nth term of the Fibonacci sequence
     */
    public static BigInteger Fib1(BigInteger n) {

        if (n.compareTo(BigInteger.TWO) == -1) {
            return n;
        }
        else {
            return Fib1(n.subtract(BigInteger.ONE)).add(Fib1(n.subtract(BigInteger.TWO)));
        }
    }
}
