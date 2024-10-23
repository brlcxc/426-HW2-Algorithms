public class Main {
    public static void main(String[] args) {
        System.out.println("phi(8000) = " + phi(8000));
        System.out.println("phi(98803519) = " + phi(98803519));
        System.out.println("GCD(10012012,2314213) = " + extendedEuclid(10012012,2314213));
        System.out.println("GCD(28176412,29108188) = " + extendedEuclid(28176412,29108188));
        System.out.println("GCD(38172,23812188) = " + extendedEuclid(38172,23812188));
        System.out.println("The multiplicative inverse of 12091 mod 24123123 = " + inverseOutput(multiplicativeInverse(12091, 24123123)));
        System.out.println("The multiplicative inverse of 28173928 mod 129182771 = " + inverseOutput(multiplicativeInverse(28173928, 129182771)));
    }
    public static int euclid(int x, int y){
        //base case where the greatest common denominator is found
        if (x % y == 0){
            return y;
        }
        //recursive statement
        return euclid(y, x % y);
    }

    public static int multiplicativeInverse(int m, int n) {
        // Use the extended Euclidean algorithm to calculate gcd and the coefficients
        int[] result = extendedEuclid(m, n);
        int gcd = result[0];
        int x = result[1]; // x is the multiplicative inverse

        // The multiplicative inverse only exists if gcd(m, n) == 1
        if (gcd != 1) {
            return -1;
        }

        return (x % n + n) % n;
    }

    private static int[] extendedEuclid(int a, int b) {
        if (b == 0) {
            return new int[]{a, 1, 0}; // gcd(a, 0) = a; coefficients are (1, 0)
        }
        int[] result = extendedEuclid(b, a % b);
        int gcd = result[0];
        int x1 = result[1];
        int y1 = result[2];

        // Update x and y using the results of the recursive call
        int x = y1;
        int y = x1 - (a / b) * y1;

        return new int[]{gcd, x, y};
    }
    public static String inverseOutput(int inverse){
        //a way to better output if an inverse does not exist
        if (inverse != -1){
            return Integer.toString(inverse);
        }
        return "does not exist \"gcd(m,n) = 1\"";
    }
    public static int phi(int n) {
        int result = 1;
        for (int i = 2; i < n; i++)
            if (euclid(i, n) == 1){
                result++;
            }
        return result;
    }
}