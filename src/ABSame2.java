/**
 * Created by jack on 2017/4/18.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class ABSame2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        Scanner sca = new Scanner(System.in);
        int m = sca.nextInt();
        int[] a = new int[m];
        for(int i=0; i<m; i++)
            a[i] = sca.nextInt();
        Arrays.sort(a);
        int n = sca.nextInt();
        int[] b = new int[n];
        for(int i=0; i<n; i++)
            b[i] = sca.nextInt();
        int[] temp = b.clone();
        Arrays.sort(b);

        for(int i=0,j=0; i<a.length && j<b.length; ){
            if(a[i] == b[j]){
                list.add(a[i]);
                i++;
                j++;
            }
            else if(a[i] < b[j])
                i++;
            else
                j++;
        }
        for(int i=0; i<temp.length; i++){
            if(list.contains(temp[i]))
                System.out.print(temp[i] + " ");
        }
        sca.close();
    }
}
