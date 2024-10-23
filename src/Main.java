public class Main {
    public static void main(String[] args) {
        System.out.println("phi(8000) = " + phi(8000));
        System.out.println("phi(98803519) = " + phi(98803519));

        System.out.println("GCD(10012012,2314213) = " + euclid(10012012,2314213));
        System.out.println("GCD(28176412,29108188) = " + euclid(28176412,29108188));
        System.out.println("GCD(38172,23812188) = " + euclid(38172,23812188));
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

    public static int multiplicativeInverse(int m, int n){
        //a multiplicative inverse cannot exist if gcd(m, n) = 1
        if (euclid(m, n) != 1){
            return -1;
        }
        //range 0 to n-1
        for (int z = 0; z < n; z++){
            if (m * z % n == 1){
                return z;
            }
        }
        return -1;
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