/**
 * Created by jack on 2017/4/18.
 * 实现如下的功能：把5/2表示成：
 ***       ***       ***      ***  ***
 *      *    *  ***    *      *    * *
 ***   *   ***       ***      ***  * *
 *  *    *    ***  *    **    *  * *
 ***       ***       ***  **  ***  ***
 */
import com.sun.deploy.util.ArrayUtil;

import java.util.Scanner;
public class Calc {
    public static void reverse(int temp [][] ){
        for(int i=0;i<temp.length;i++){
            for(int j=i;j<temp[i].length;j++){
                int k=temp[i][j];
                temp[i][j]=temp[j][i];
                temp[j][i]=k;
            }
        }
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int first = 0, second = 0;
        char[] arr = str.toCharArray();
        boolean b = true;
        int formLen = 0;
        int type = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= '0' && arr[i] <= '9'){
                if(b == true) {
                    first = first * 10 + (arr[i] - '0');
                }
                else{
                    second = second * 10 + (arr[i] - '0');
                }
                if(arr[i] == '1') formLen++;
                else formLen += 3;
            }
            else{
                b = false;
                switch (arr[i]){
                    case '+':
                        type = 0;
                        break;
                    case '-':
                        type = 1;
                        break;
                    case '*':
                        type = 2;
                        break;
                    case '/':
                        type = 3;
                        break;
                    default: break;
                }
                formLen += 3;
            }
        }
        formLen += (arr.length - 1) * 2;//two spaces
        String resultStr = "";
        switch (type){
            case 0:
                resultStr = (first + second) + "";
                break;
            case 1:
                resultStr = (first - second) + "";
                break;
            case 2:
                resultStr = (first * second) + "";
                break;
            case 3:
                if(first % second != 0){
                    resultStr = String.format("%.2f", (double)first/second);
                }
                else{
                    resultStr = first/second + "";
                }
                break;
            default:
                break;
        }
        int resultLen = 0;
        char[] resultArr = resultStr.toCharArray();
        for(int i = 0; i < resultArr.length; i++){
            if(resultArr[i] >= '0' && resultArr[i] <= '9'){
                if(resultArr[i] == '1') formLen++;
                else resultLen += 3;
            }
            else{
                resultLen += 2;
            }
        }
        resultLen += (resultArr.length - 1) * 2 + 8;
        char[] finalArr = (str + "=" + resultStr).toCharArray();
        int totalLen = formLen + resultLen;
        int[][] finalResult = new int[5][totalLen];
        int curPos = 0;
        for(int i = 0; i < finalArr.length; i++){
            if(finalArr[i] >= '0' && finalArr[i] <= '9'){
                switch (finalArr[i]){
                    case '1':
                        finalResult[0][curPos] = 1;
                        finalResult[1][curPos] = 1;
                        finalResult[2][curPos] = 1;
                        finalResult[3][curPos] = 1;
                        finalResult[4][curPos] = 1;
                        curPos += 3;
                        break;
                    case '2':
                        finalResult[0][curPos] = 1;
                        finalResult[2][curPos] = 1;
                        finalResult[3][curPos] = 1;
                        finalResult[4][curPos] = 1;
                        curPos ++;
                        finalResult[0][curPos] = 1;
                        finalResult[2][curPos] = 1;
                        finalResult[4][curPos] = 1;
                        curPos ++;
                        finalResult[0][curPos] = 1;
                        finalResult[1][curPos] = 1;
                        finalResult[2][curPos] = 1;
                        finalResult[4][curPos] = 1;
                        curPos += 3;
                        break;
                    case '3':
                        finalResult[0][curPos] = 1;
                        finalResult[2][curPos] = 1;
                        finalResult[4][curPos] = 1;
                        curPos ++;
                        finalResult[0][curPos] = 1;
                        finalResult[2][curPos] = 1;
                        finalResult[4][curPos] = 1;
                        curPos ++;
                        finalResult[0][curPos] = 1;
                        finalResult[1][curPos] = 1;
                        finalResult[2][curPos] = 1;
                        finalResult[3][curPos] = 1;
                        finalResult[4][curPos] = 1;
                        curPos += 3;
                        break;
                    case '4':
                        finalResult[0][curPos] = 1;
                        finalResult[1][curPos] = 1;
                        finalResult[2][curPos] = 1;
                        curPos ++;
                        finalResult[2][curPos] = 1;
                        curPos ++;
                        finalResult[0][curPos] = 1;
                        finalResult[1][curPos] = 1;
                        finalResult[2][curPos] = 1;
                        finalResult[3][curPos] = 1;
                        finalResult[4][curPos] = 1;
                        curPos += 3;
                        break;
                    case '5':
                        finalResult[0][curPos] = 1;
                        finalResult[1][curPos] = 1;
                        finalResult[2][curPos] = 1;
                        finalResult[4][curPos] = 1;
                        curPos ++;
                        finalResult[0][curPos] = 1;
                        finalResult[2][curPos] = 1;
                        finalResult[4][curPos] = 1;
                        curPos ++;
                        finalResult[0][curPos] = 1;
                        finalResult[2][curPos] = 1;
                        finalResult[3][curPos] = 1;
                        finalResult[4][curPos] = 1;
                        curPos += 3;
                        break;
                    case '6':
                        finalResult[0][curPos] = 1;
                        finalResult[1][curPos] = 1;
                        finalResult[2][curPos] = 1;
                        finalResult[3][curPos] = 1;
                        finalResult[4][curPos] = 1;
                        curPos ++;
                        finalResult[0][curPos] = 1;
                        finalResult[2][curPos] = 1;
                        finalResult[4][curPos] = 1;
                        curPos ++;
                        finalResult[0][curPos] = 1;
                        finalResult[2][curPos] = 1;
                        finalResult[3][curPos] = 1;
                        finalResult[4][curPos] = 1;
                        curPos += 3;
                        break;
                    case '7':
                        finalResult[0][curPos] = 1;
                        curPos ++;
                        finalResult[0][curPos] = 1;
                        curPos ++;
                        finalResult[0][curPos] = 1;
                        finalResult[1][curPos] = 1;
                        finalResult[2][curPos] = 1;
                        finalResult[3][curPos] = 1;
                        finalResult[4][curPos] = 1;
                        curPos += 3;
                        break;
                    case '8':
                        finalResult[0][curPos] = 1;
                        finalResult[1][curPos] = 1;
                        finalResult[2][curPos] = 1;
                        finalResult[3][curPos] = 1;
                        finalResult[4][curPos] = 1;
                        curPos ++;
                        finalResult[0][curPos] = 1;
                        finalResult[2][curPos] = 1;
                        finalResult[4][curPos] = 1;
                        curPos ++;
                        finalResult[0][curPos] = 1;
                        finalResult[1][curPos] = 1;
                        finalResult[2][curPos] = 1;
                        finalResult[3][curPos] = 1;
                        finalResult[4][curPos] = 1;
                        curPos += 3;
                        break;
                    case '9':
                        finalResult[0][curPos] = 1;
                        finalResult[1][curPos] = 1;
                        finalResult[2][curPos] = 1;
                        finalResult[4][curPos] = 1;
                        curPos ++;
                        finalResult[0][curPos] = 1;
                        finalResult[2][curPos] = 1;
                        finalResult[4][curPos] = 1;
                        curPos ++;
                        finalResult[0][curPos] = 1;
                        finalResult[1][curPos] = 1;
                        finalResult[2][curPos] = 1;
                        finalResult[3][curPos] = 1;
                        finalResult[4][curPos] = 1;
                        curPos += 3;
                        break;
                    case '0':
                        finalResult[0][curPos] = 1;
                        finalResult[1][curPos] = 1;
                        finalResult[2][curPos] = 1;
                        finalResult[3][curPos] = 1;
                        finalResult[4][curPos] = 1;
                        curPos ++;
                        finalResult[0][curPos] = 1;
                        finalResult[4][curPos] = 1;
                        curPos ++;
                        finalResult[0][curPos] = 1;
                        finalResult[1][curPos] = 1;
                        finalResult[2][curPos] = 1;
                        finalResult[3][curPos] = 1;
                        finalResult[4][curPos] = 1;
                        curPos += 3;
                        break;
                    default:
                        break;
                }
            }
            else {
                switch (finalArr[i]){
                    case '+':
                        finalResult[2][curPos] = 1;
                        curPos ++;
                        finalResult[1][curPos] = 1;
                        finalResult[2][curPos] = 1;
                        finalResult[3][curPos] = 1;
                        curPos ++;
                        finalResult[2][curPos] = 1;
                        curPos += 3;
                        break;
                    case '-':
                        finalResult[2][curPos] = 1;
                        curPos ++;
                        finalResult[2][curPos] = 1;
                        curPos ++;
                        finalResult[2][curPos] = 1;
                        curPos += 3;
                        break;
                    case '*':
                        finalResult[1][curPos] = 1;
                        finalResult[3][curPos] = 1;
                        curPos ++;
                        finalResult[2][curPos] = 1;
                        curPos ++;
                        finalResult[1][curPos] = 1;
                        finalResult[3][curPos] = 1;
                        curPos += 3;
                        break;
                    case '/':
                        finalResult[3][curPos] = 1;
                        curPos ++;
                        finalResult[2][curPos] = 1;
                        curPos ++;
                        finalResult[1][curPos] = 1;
                        curPos += 3;
                        break;
                    case '=':
                        finalResult[1][curPos] = 1;
                        finalResult[3][curPos] = 1;
                        curPos ++;
                        finalResult[1][curPos] = 1;
                        finalResult[3][curPos] = 1;
                        curPos ++;
                        finalResult[1][curPos] = 1;
                        finalResult[3][curPos] = 1;
                        curPos += 3;
                        break;
                    case '.':
                        finalResult[3][curPos] = 1;
                        finalResult[4][curPos] = 1;
                        curPos ++;
                        finalResult[3][curPos] = 1;
                        finalResult[4][curPos] = 1;
                        curPos += 3;
                        break;
                    default:
                        break;
                }
            }
        }
        //reverse(finalResult);
        for(int i = 0; i < finalResult.length; i++){
            for(int j = 0; j < finalResult[i].length; j++){
                System.out.print(finalResult[i][j] == 1 ? "*" : " ");
            }
            System.out.println();
        }
    }
}
