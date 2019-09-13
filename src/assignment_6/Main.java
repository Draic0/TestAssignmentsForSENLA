package assignment_6;

import java.util.ArrayList;

import static common_package.common.*;

public class Main {

    private static int limit = 100;
    private static Item book = new Item("Книга",3,300,5);
    private static Item lunch = new Item("Завтрак",5,150,1);
    private static Item portable = new Item("Портативка",5,15000,2);
    private static Item laptop = new Item("Ноутбук",15,40000,1);
    private static Item umbrella = new Item("Зонт",5,300,3);
    private static Item pencilCase = new Item("Пенал",3,200,1);
    private static Item wrenchSet = new Item("Набор гаечных ключей",25,1500,1);
    private static Item packOfPaper = new Item("Папка с бумагами",15,300,3);
    private static Item present = new Item("Подарок",5,700,5);
    private static Item flashlight = new Item("Фонарик",5,350,2);

    public static void main(String[] args) {
        //Составляем список доступных вещей.
        ArrayList<Item> items = initItems();
        //Условная оптимизация - максимизируем стоимость.
        ArrayList<ArrayList<Column>> tables = makeTables(items);
        //Безусловная оптимизация - отбираем количества предметов, соответствующие максимальному значению f(L)
        //в пределах остающегося объема рюкзака.
        ArrayList<Integer> optQts = getOptimalQuantities(items,tables);
        println("В рюкзак нужно положить следующие вещи в следующих количествах:");
        for(int i = 0;i<items.size();i++){
            println(items.get(i).toString()+" --> "+optQts.get(i)+" шт.");
        }
    }

    private static ArrayList<Item> initItems(){
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(book);
        items.add(lunch);
        items.add(portable);
        items.add(laptop);
        items.add(umbrella);
        items.add(pencilCase);
        items.add(wrenchSet);
        items.add(packOfPaper);
        items.add(present);
        items.add(flashlight);
        return items;
    }

    private static ArrayList<ArrayList<Column>> makeTables(ArrayList<Item> items){
        ArrayList<ArrayList<Column>> tables = new ArrayList<ArrayList<Column>>();
        ArrayList<Column> table = null;
        for(int i = 0;i<items.size();i++){
            table = makeTable(items.get(i),table);
            //printTable(table,i+1);
            tables.add(table);
        }
        return tables;
    }

    private static ArrayList<Column> makeTable(Item item, ArrayList<Column> prevTable){
        ArrayList<Column> table = new ArrayList<Column>();
        for(int L = 0; L<=limit;L++){
            int fL = 0;
            int x = 0;
            //Максимизируем функцию fn(L) = max(j*Value + fn-1(L-j*Weight)) в переменной fL
            for(int j = 0;j<=item.getQuantity()&&j<=L/item.getWeight();j++){
                int ffL = calculateFl(j,L,item,prevTable);
                if(ffL>fL){
                    fL = ffL;
                    x = j;
                }
            }
            table.add(new Column(fL,x));
        }
        return table;
    }

    private static int calculateFl(int x, int L, Item item, ArrayList<Column> prevTable){
        //f(L) = x*Value + fn-1(L-x*Weight)
        int fL = prevTable==null?0:prevTable.get(L-x*item.getWeight()).fL;
        return x*item.getValue() + fL;
    }

    private static ArrayList<Integer> getOptimalQuantities(ArrayList<Item> items, ArrayList<ArrayList<Column>> tables){
        int spaceLeft = limit;
        ArrayList<Integer> optQts = new ArrayList<Integer>();
        for(int i = items.size()-1;i>=0;i--){
            ArrayList<Column> table = tables.get(i);
            double fL = 0;
            int x = 0;
            for(int j = 0;j<=spaceLeft;j++){
                Column c = table.get(j);
                if(c.fL>fL){
                    fL=c.fL;
                    x =c.x;
                }
            }
            optQts.add(0,x);
            spaceLeft -= x*items.get(i).getWeight();
        }
        return optQts;
    }

    private static void printTable(ArrayList<Column> table,int numTable){
        println("Таблица "+numTable+":");
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<table.size();i++){
            sb.append(i);
            sb.append("\t");
        }
        println(sb.toString());
        sb = new StringBuilder();
        for(Column c: table){
            sb.append(c.fL);
            sb.append("\t");
        }
        println(sb.toString());
        sb = new StringBuilder();
        for(Column c: table){
            sb.append(c.x);
            sb.append("\t");
        }
        println(sb.toString());
    }

    private static class Column {
        int fL;
        int x;
        Column(int fL, int x){
            this.fL = fL;
            this.x = x;
        }
    }
}
