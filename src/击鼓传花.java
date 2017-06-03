/**
 * Created by jack on 2017/5/31.
 */
import java.util.Scanner;
class Person{
    int id;
    short height;
    Sex sex;
    Person next;
    enum Sex{
        FEMALE(0),MALE(1);
        Sex(int i) {
        }
    }
    public Person(int _id, Sex _sex, short _height) {
        this.id = _id;
        this.sex = _sex;
        this.height = _height;
    }
}
public class 击鼓传花 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Person girlHead = null;
        Person boyHead = null;
        Person[] arr = new Person[n];
        for(int i = 0; i < n; i++){
            int id= sc.nextInt();
            String sexStr = sc.next();
            Person.Sex sex = sexStr.equalsIgnoreCase("MALE")?Person.Sex.MALE:Person.Sex.FEMALE;
            short height = sc.nextShort();
            Person p = new Person(id, sex, height);
            arr[i] = p;
        }
        int num = sc.nextInt();
        sortPerson(arr);
        linkPerson(arr);
        chuanhua(arr[0], num);
    }
    public static void sortPerson(Person[] arr){
        for(int i = 1; i < arr.length; i++){
            Person.Sex curSex = arr[i].sex;
            Person curVal = arr[i];
            int j;//记录最后该值应该处的位置
            for(j = i - 1; j >= 0 && (curSex == Person.Sex.FEMALE && arr[j].sex == Person.Sex.MALE || arr[j].height >= curVal.height); j--){
                arr[j+1] = arr[j];
            }
            arr[j + 1] = curVal;
        }
    }
    public static void linkPerson(Person[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            arr[i].next = arr[i+1];
        }
        arr[arr.length - 1].next = arr[0];
    }
    public static void chuanhua(Person p, int n){
        while(p.next != p){
            Person former = p;
            Person tmp = p;
            for(int i = 0; i < n-1; i++){
                former = tmp;
                tmp = tmp.next;
            }
            former.next = tmp.next;
            p = former.next;
        }
        System.out.println(p.id);
    }
}
