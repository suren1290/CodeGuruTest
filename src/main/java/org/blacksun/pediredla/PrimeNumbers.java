package org.blacksun.pediredla;

/**
 * Created by Pediredla on 11/24/16.
 */
public class PrimeNumbers {
    public PrimeNumbers() {
    }

    public int nthPrime(int n) {
        int count = 0;
        int[] prime = new int[n];
        if (n > 1) {
            for (int i = 2; i < 2147483647 && count != n; ++i) {
                if (this.isPrime(i)) {
                    ++count;
                    prime[count] = i;
                }
            }
        }

        return prime[count];
    }

    public boolean isPrime(int n) {
        if (n != 1 && n != 2 && n != 3) {
            if (n % 2 == 0) {
                return false;
            } else {
                for (int i = 3; i * i <= n; i += 2) {
                    if (n % i == 0) {
                        return false;
                    }
                }

                return true;
            }
        } else {
            return true;
        }
    }
}

