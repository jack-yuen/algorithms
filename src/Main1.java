import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by jack on 2017/4/8.
 */
public class Main1 {

    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []rows = new int[n];
        int []cols = new int[n];
        Map<Integer, Integer> ver = new HashMap<Integer, Integer>();
        Map<Integer, Integer> hor = new HashMap<Integer, Integer>();
        Map<Integer, Integer> dia1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> dia2 = new HashMap<Integer, Integer>();
        int count = 0;
        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            count = count + ver.getOrDefault(a, 0) + hor.getOrDefault(b, 0)  + dia1.getOrDefault(a-b, 0)  + dia2.getOrDefault(a+b, 0);

            ver.put(a, ver.getOrDefault(a, 0) + 1);
            hor.put(b, hor.getOrDefault(b, 0) + 1);
            dia1.put(a-b, dia1.getOrDefault(a-b, 0) + 1);
            dia2.put(a+b, dia2.getOrDefault(a+b, 0) + 1);

            ver.replace(a, ver.get(a) + 1);
            hor.replace(b, hor.get(b) + 1);
            dia1.replace(a-b, dia1.get(a-b) + 1);
            dia2.replace(a+b, dia2.get(a+b) + 1);
        }
        System.out.println(count / 2);
    }
}
