package hw_3_1;

import java.util.ArrayList;

class Box<T extends Fruit> {
    //private boolean isFree = true;
    //float maxWeight = 100.0f;
    float currWeight = 0;
    ArrayList<T> list = new ArrayList<>();

    public void addFruit(T fruit) {

        list.add(fruit);

        // System.out.println(list.size());
    }

    public float getWeight(Fruit f) {
        return list.size() * f.weight;
    }

    public boolean compare(Float f1, Float f2) {
        if ((f1 - f2) < 0.0001) {
            return true;
        } else {
            return false;
        }

    }

    public void transfer(Box<? super T> another) {
        if (another == this) {
            return;
        }
        another.list.addAll(this.list);
        this.list.clear();
    }
    //Не забываем про метод добавления фрукта в коробку.
    public void add(T fruit) {
        list.add(fruit);
    }

}


