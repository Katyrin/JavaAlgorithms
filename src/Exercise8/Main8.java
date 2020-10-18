package Exercise8;

//Задание 8.1
// структурированая таблица с ценами на товар

//Задание 8.2
// ключь - может быть паролем, колизия - одинаковые значения хеширования разных паролей

//Задание 8.3
// популярная - наиболее быстрая, эффективная - с наименьшим шансом вызвать коллизию


import java.util.Random;

public class Main8 {
    public static void main(String[] args) {
        //данные массива из задания 2.3
        Random rand = new Random();
        int[] integers = new int[400];
        for (int i = 0;i < integers.length-1;i++)
            integers[i] = rand.nextInt(10000);

        //Задание 8.4
        Item aDataItem;
        int aKey;
        int size = 1000;
        HashTable hashTable = new HashTable(size);
        for (int i = 0;i < integers.length-1;i++) {
            aKey = integers[i];
            aDataItem = new Item(aKey);
            hashTable.insert(aDataItem);
        }
        hashTable.insert(new Item(105));
        hashTable.display();
        System.out.println(hashTable.find(105).getKey());

        System.out.println("**************************************");

        //Задание 8.5
        HashTable2 hashTable2 = new HashTable2(size);
        for (int i = 0;i < integers.length-1;i++) {
            aKey = integers[i];
            aDataItem = new Item(aKey);
            hashTable2.insert(aDataItem);
        }
        hashTable2.insert(new Item(105));
        hashTable2.display();
        System.out.println(hashTable2.find(105).getKey());
    }
}
