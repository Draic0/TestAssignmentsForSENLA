package assignment_4;

import static common_package.common.*;

public class Main {

    public static void main(String[] args) {
        while(true) {
            println("Введите текст:");
            String text = readLine().toLowerCase();
            if(isExitCommand(text)){
                break;
            }
            if(text.length()==0){
                println("Ошибка ввода!");
                continue;
            }
            println("Введите слово, число вхождений которого в текст необходимо найти:");
            String word = cleanPunctuation(readLine().toLowerCase());
            if(word.length()==0){
                println("Ошибка ввода!");
                continue;
            }
            if(isExitCommand(word)){
                print("Вы хотите завершить выполнение программы? (y/n) ");
                String result = readLine().toLowerCase();
                if(result.equals("y")||result.equals("yes")||result.equals("да")) {
                    break;
                }
            }
            int count = 0;
            String[] words = text.split("[ ,.]+");
            for(String wrd: words){
                if(cleanPunctuation(wrd).equals(word)) count++;
            }
            String times = "раз";
            if(count>1&&count<5||count>20&&count%10>1&&count%10<5){
                times = "раза";
            }
            println("Слово \""+word+"\" встречается в тексте "+count+" "+times+".");
        }
        println("Работа завершена.");
    }
}
