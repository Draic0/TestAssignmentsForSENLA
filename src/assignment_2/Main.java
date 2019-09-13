package assignment_2;

import static common_package.common.*;

public class Main {

    public static void main(String[] args) {
        outer: while(true) {
            print("Введите пожалуйста два простых числа: ");
            String[] ints;
            String inputs = "";
            do {
                String input = readLine();
                if (isExitCommand(input)) {
                    break outer;
                }
                if(inputs.length()==0) {
                    inputs = input;
                }else{
                    inputs += ", "+input;
                }
                ints = inputs.split("\\s*[,; ]\\s*");
            }while(ints.length<2);
            if (ints.length > 2) {
                println("Ошибка ввода!");
                continue;
            }
            int a,b;
            try{
                a = Integer.valueOf(ints[0]);
                b = Integer.valueOf(ints[1]);
            }catch(NumberFormatException exc){
                println("Ошибка ввода!");
                continue;
            }
            int gcd = gcd(a,b);
            int lcm = lcm(a,b,gcd);
            println("Для чисел "+a+" и "+b+" наименьшее общее кратное равно "+lcm+", а наибольший общий делитель "+
                    "равен "+gcd+".");
        }
        println("Работа завершена.");
    }

    //Нахождение наибольшего общего делителя.
    private static int gcd(int a,int b){
        return b == 0?a:gcd(b,a%b);
    }

    //Нахождение наименьшего общего кратного.
    private static int lcm(int a,int b,int gcd){
        return a / gcd * b;
    }
}
