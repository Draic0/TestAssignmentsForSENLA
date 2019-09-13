package assignment_1;

import static common_package.common.*;

public class Main {

    public static void main(String[] args) {
        while(true) {
            print("Введите пожалуйста целое число: ");
            String input = readLine();
            if(isExitCommand(input)){
                break;
            }
            int a;
            try {
                a = Integer.valueOf(input);
            } catch (NumberFormatException exc) {
                println("Ошибка ввода!");
                continue;
            }
            boolean even = isEven(a);
            boolean composite = hasFactors(a);
            println("Число "+a+" "+(even?"чётное":"нечётное")+" и "+(composite?"составное":"простое")+".");
        }
        print("Работа завершена.");
    }

    //Чётное ли число?
    private static boolean isEven(int a){
        return a%2==0;
    }

    //Есть ли у числа делители кроме 1 и самого числа?
    private static boolean hasFactors(int a){
        a = Math.abs(a);
        for(int i = 2;i<a;i++){
            if(a%i==0) return true;
        }
        return false;
    }
}
