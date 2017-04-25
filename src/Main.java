import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by jack on 2017/4/8.
 */
public class Main {

    public static int calc(int robs, int t, int jobs, int q, Map<Integer, Integer> timeMap){
        int newRobs = timeMap.getOrDefault(t, 0) * 2;//new
        robs += newRobs;
        int time = Integer.MAX_VALUE;
        if(jobs <= robs * q){
            return jobs %robs == 0 ? jobs/robs : jobs/robs + 1;
        }
        int better = 0;
        Map<Integer, Integer> betterTimeMap = null;
        for(int i = 0; i <= robs; i++){//i copy count
            int leftJobs = jobs - (robs - i);
            int leftRobs = robs - i;//next time robs
            Map<Integer, Integer> newTimeMap = new HashMap<>();
            newTimeMap.putAll(timeMap);
            if(newTimeMap.containsKey(t + q)){
                newTimeMap.replace(t+q, newTimeMap.get(t+q) + i);
            }
            else{
                newTimeMap.put(t+q, i);
            }
            int leftTime = calc(leftRobs, t+1, leftJobs, q, newTimeMap);
            if(leftTime < time){
                better = i;
                betterTimeMap = newTimeMap;
                time = leftTime;
            }
        }
        return 1 + calc(robs - better, t + 1,jobs - (robs - better), q, betterTimeMap);
    }

    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        Map<Integer, Integer> timeMap = new HashMap<Integer, Integer>();

        System.out.println(calc(1, 0, n, q,timeMap));
    }
}
