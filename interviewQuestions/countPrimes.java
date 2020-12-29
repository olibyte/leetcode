public class countPrimes {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        int result = 0;
        // populate array with numbers up to n. all nums are potentially prime until
        // proven otherwise
        for (int i = 0; i < n; i++) {
            primes[i] = true;
        }
        // use sieve of eratosthenes to check for primality - start at 2 and all
        // multiples less than n to false
        for (int i = 2; i * i < primes.length; i++) {
            // check the candidates (trues) for primality - we can skip those already proven
            // to be non-prime
            if (primes[i] == true) {
                // set all multiples up to n to be false
                for (int j = 2; j * i < primes.length; j++) {
                    primes[i * j] = false;
                }
            }
        }
        // iterate through primes counting remaining 'trues'
        for (int i = 2; i < primes.length; i++) {
            if (primes[i] == true) {
                result++;
            }
        }
        return result;
    }
}
