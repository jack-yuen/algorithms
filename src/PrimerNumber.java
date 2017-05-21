/**
 * Created by jack on 2017/5/14.
 * 求出小于N的所有的质数，接近线性的方法
 */
public class PrimerNumber {
    public static void main(String[] args){
        long startMili = System.currentTimeMillis();
        printPrimerNumbers(2000);
        long endMili = System.currentTimeMillis();
        System.out.println();
        System.out.println("总耗时:" + (endMili - startMili) + "毫秒");
    }
    public static void printPrimerNumbers(int n){
        int[] primes = new int[n];
        primes[0] = 2;
        boolean[] composites = new boolean[n];
        for(int i = 0; i < n; i++){
            composites[i] = false;//将所有数设置为质数(非合数)
        }
        int primeIndex = 0;
        for(int i = 2; i < n; i++){//从1开始判断，看看哪些数是质数，哪些数是合数
            if(composites[i] == false){
                primes[primeIndex] = i;
                primeIndex++;//primeIndex是下一个要存的位置
            }
            for(int j = 0; j < primeIndex && i * primes[j] < n; j++){
                composites[primes[j] * i] = true;
                if(i % primes[j] == 0){//如果i是primes[j]的倍数，那么再往上乘其他质数(大质）就可以表示成（当前的质数*(大质）*现在的倍数）
                    break;
                }
            }
        }
//        for(int i = 0; i < primeIndex; i++){
//            System.out.print(primes[i]);
//            if(i != primeIndex - 1){
//                System.out.print(",");
//            }
//        }
    }
}

