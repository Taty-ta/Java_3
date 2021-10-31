package hw_3_7;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception {
        Class c = MyClass.class;
        Object testObj = c.newInstance();// newInstance() позволяет создавать экземпляры класса через объект типа Class и возвращает объект типа Object
        Method[] methods = c.getDeclaredMethods();//Методы getMethods() и getDeclaredMethods() возвращают массив объектов типа Method, в которых содержится полная информация о методах класса
        ArrayList<Method> al = new ArrayList<>();
        Method beforeMethod = null;
        Method afterMethod = null;
        // проходим по всем методам MYClass
        for (Method o : c.getDeclaredMethods()) {
            if (o.isAnnotationPresent(Test.class)) {
                // с аннотацией тест добавляем в список
                al.add(o);
            }
            if (o.isAnnotationPresent(BeforeSuite.class)) {
                // если beforeMethod не NUUL, значит больше одного
                if (beforeMethod == null) beforeMethod = o;
                else throw new RuntimeException("Больше одного метода с аннотацией BeforeSuite");
            }
            if (o.isAnnotationPresent(AfterSuite.class)) {
                if (afterMethod == null) afterMethod = o;
                else throw new RuntimeException("Больше одного метода с аннотацией AfterSuite");
            }
            al.sort(new Comparator<Method>() {
                @Override
                public int compare(Method o1, Method o2) {
                    return o2.getAnnotation(Test.class).priority()-o1.getAnnotation(Test.class).priority();
                }
            });

        }


        if (beforeMethod != null){
            beforeMethod.invoke(testObj, null);
        }
        for (Method o : al){
            o.invoke(testObj, null);
            if (afterMethod != null) afterMethod.invoke(testObj, null);
        }

    }
}
