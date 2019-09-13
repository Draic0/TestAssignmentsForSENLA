package assignment_5;

import java.util.Set;
import java.util.TreeSet;

import static common_package.common.*;

public class Main {

    public static void main(String[] args) {
        while (true){
            print("Введите предел поиска чисел-палиндромов: ");
            String input = readLine();
            if(isExitCommand(input)){
                break;
            }
            int limit;
            try{
                limit = Integer.valueOf(input);
            }catch(NumberFormatException exc){
                println("Ошибка ввода!");
                continue;
            }
            /*Тут в задании скорее всего закралась ошибка. Если перебирать числа в пределах 100, то все палиндромы
            * будут 1-2-значными, что как минимум некрасиво. Также вряд ли предполагалось вводить всю последовательность
            * из чисел вручную с клавиатуры, так чтобы её длина не превышала 100, так как вряд ли кто-то стал бы
            * вводить так много текста. В данном случае я решил изменить предел перебора до 1000.*/
            if(limit>1000){
                println("Предел не должен превышать 1000!");
                continue;
            }
            Set<Integer> aa = new TreeSet<Integer>();
            for(int a = 0;a<=limit;a++){
                int b = reverse(a);
                if(a==b){
                    aa.add(a);
                }
            }
            println("В указанных пределах содержатся следующие числа-палиндромы:");
            String line = "";
            int count = 0;
            int rowLength = 10;
            for(Integer a: aa){
                if(count==rowLength){
                    println(line);
                    line = "";
                    count = 0;
                }
                line += a + "\t";
                count++;
            }
            println(line);
        }
        println("Работа завершена.");
    }

    private static int reverse(int a){
        String str1 = String.valueOf(a);
        StringBuilder str2 = new StringBuilder(str1);
        str2.reverse();
        return Integer.valueOf(str2.toString());
    }
}
