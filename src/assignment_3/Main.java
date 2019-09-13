package assignment_3;

import java.util.Set;
import java.util.TreeSet;

import static common_package.common.*;

public class Main {

    public static void main(String[] args) {
        while (true){
            println("Введите текст предложения:");
            String input = readLine();
            if (isExitCommand(input)) {
                break;
            }
            String[] inputs = input.split("[ .,]+");
            Set<String> words = new TreeSet<String>();
            for(int i = 0;i<inputs.length;i++){
                String word = cleanPunctuation(inputs[i]);
                if(word.length()>0){
                    word = word.substring(0,1).toUpperCase()+word.substring(1);
                    words.add(word);
                }
            }
            if(words.size()>0) {
                println("Упорядоченный список слов: ");
                for (String word : words) {
                    println(word);
                }
                println("");
            }else{
                println("Не было введено ни одного слова!");
            }
        }
        println("Работа завершена.");
    }


}
