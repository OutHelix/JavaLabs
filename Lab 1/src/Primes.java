public class Primes {
    public static void main(String[] args) {
        for (int n = 2; n <= 100; n++) {
            System.out.println(isPrime(n));
        }
    }
    public static boolean isPrime(int n) {
        for (int i = 3; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}