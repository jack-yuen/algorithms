import java.util.Scanner;
import java.util.Set;
public class tentxun325{
    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n < 2){
            System.out.println(0);
        }
        boolean[] b = new boolean[n+1];
        for(int i = 0; i < n; i++){
            b[i] = true;
        }
        for(int i = 2; i < n+1; i++){
            if(b[i] == true){
                for(int j = 2; i*j < n+1; j++){
                    b[i*j] = false;
                }
            }
        }
        int count = 0;
        for(int i = 2; i < n+1; i++){
            if(b[i] == true){
                count++;
            }
        }
        int[] arr = new int[count];
        int index = 0;
        for(int i = 2; i < n+1; i++){
            if(b[i] == true){
                arr[index] = i;
                index++;
            }
        }
        int result = 0;
        for(int i = 0; i < count; i++){
            for(int j = i; j <count; j++){
                if(arr[i] + arr[j] == n){
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}