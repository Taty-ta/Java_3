package hw_3_1;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Задача 1. Написать метод, который меняет два элемента массива местами.
        // (массив может быть любого ссылочного типа);
        Integer[] arr = {4, 5, 6, 7, 8};


        System.out.println( Arrays.toString(arr));
        change(arr, 2, 3);
        System.out.println(Arrays.toString(arr));


        //Задача 2. Написать метод, который преобразует массив в ArrayList
        List<Integer> list = convertToList(arr);
        System.out.println( list.getClass() + " : " + list);


        /*
	Задача:
        Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
        Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
        Для хранения фруктов внутри коробки можно использовать ArrayList;
        Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);

	 */
        Apple apple = new Apple();
        Orange orange = new Orange();

        Box<Apple> appleBox = new Box();
        Box<Orange> orangeBox = new Box();

        appleBox.addFruit(apple);
        appleBox.addFruit(apple);
        appleBox.addFruit(apple);
        appleBox.addFruit(apple);

        orangeBox.addFruit(orange);
        orangeBox.addFruit(orange);
        orangeBox.addFruit(orange);
        //Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного
        // фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
        Float applW = appleBox.getWeight(apple);
        Float orW = orangeBox.getWeight(orange);
        System.out.println("вес коробки с яблоками = " + applW);
        System.out.println("вес коробки с апельсинами = " + orW);

        /**
         * Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра. true – если их массы равны,
         * false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
         */

        Box<Fruit> fruitBox = new Box();
        System.out.println("вес коробок с фруктими одинаков -  " + fruitBox.compare(applW, orW));
/*
Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
 Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
 Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты,
 которые были в первой;

 */
        // подсмотрела у вас
        Box<Apple> appleBox1 = new Box();
        Box<Orange> orangeBox1 = new Box();
       appleBox.transfer(appleBox1);
    }
    private static <T> void change(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        return;
    }

    private static <E> List<E> convertToList(E[] array) {
        return Arrays.asList(array);
    }
}
