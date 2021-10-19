package hw_3_4;

public class ABC {
    static Object mon = new Object();
    static volatile char currentLetter = 'A';

    public static void main(String[] args) {
        ABC abc = new ABC();
        Thread tread1 =  new Thread(() -> {
            abc.printA();
        });
        Thread tread2 =  new Thread(() -> {
            abc.printB();
        });
        Thread tread3 =  new Thread(() -> {
            abc.printC();
        });
        tread1.start();
        tread2.start();
        tread3.start();

    }
    public void printA(){
        synchronized (mon){
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (mon) {
                        while (currentLetter != 'A') {
                            mon.wait();
                        }
                        System.out.print("A");
                        currentLetter = 'B';
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void printB(){
        synchronized (mon){
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (mon) {
                        while (currentLetter != 'B') {
                            mon.wait();
                        }
                        System.out.print("B");
                        currentLetter = 'C';
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void printC(){
        synchronized (mon){
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (mon) {
                        while (currentLetter != 'C') {
                            mon.wait();
                        }
                        System.out.print("C");
                        currentLetter = 'A';
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
