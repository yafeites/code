package test;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import javax.print.DocFlavor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    int i;

    public void setI(int i) {
        this.i = i;
    }
    public void dosomething()
    {
        System.out.println("Main");
    }

    public  int time= (int) System.currentTimeMillis();
    public static void main(String[] args) throws NoSuchMethodException {
      Method method= MainSub.class.getDeclaredMethod("dosomething");
      System.out.println(method.getDeclaringClass());
    }
}

