package math;


/*
 * An algebra class which has implementation of algebric methods.
 * Its a generic clas taking in number of any type
 * */
public class Algebra<T extends Number> extends MathUtils {
    private final long INF = Long.MAX_VALUE;

    public T gcd(T a, T b){
        if (b.longValue() == 0L){
            return a;
        }
        return gcd(b , mod(a, b));
    }
    public T pow(T a, T b, T m){
       return null;
    }

    /**
     * Binary Exponentiation.
     */
    public long exp(long a, long n, boolean iterative) {
      return iterative ? expIterative(a, n) : expRecurssive(a, n);
    }

    private long expIterative(long a, long n){
        long res = 1;
        while(n > 0){
            if((n & 1) == 1){
                res = res * a;
            }
            a = a * a % INF;
            n >>= 1;
        }
        return res;
    }

    private long expRecurssive(long a, long n){
        if (n == 0)
            return 1;
        long res = expRecurssive(a, n / 2) % INF;
        if ((n & 1) == 0) {
            return (res * res) % INF;
        } else {
            return (res * res * a) % INF;
        }
    }


    public long multiplyTwoNumbers(long a, long b, boolean iterative){
        return iterative ? multiplyTwoNumbersItr(a, b) : multiplyTwoNumbersRec(a, b);
    }

    private long multiplyTwoNumbersRec(long a, long b){
        if(a == 0){
            return 0;
        }
        long res = 2 * multiplyTwoNumbersRec(a/2, b);
        if( (a& 1) == 0){
            return res % INF;
        }else{
            return (res + b) % INF;
        }
    }

    private long multiplyTwoNumbersItr(long a, long b){
        long res = 0;
        while(a > 0){
            if((a & 1) == 1){
                res += b;
            }
            res*=2;
            a>>=1;
        }
        return res;
    }

    // ----------- APPLICATIONS OF BIN EXP ----------------

}
