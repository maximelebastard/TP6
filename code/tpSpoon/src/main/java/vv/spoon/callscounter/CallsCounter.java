package vv.spoon.callscounter;

import java.util.*;

/**
 * Created by maxime on 11/8/15.
 *
 * Singleton class that counts calls to methods
 */
public class CallsCounter {
    private static CallsCounter instance = null;

    List<String> calls = new ArrayList<>();

    protected CallsCounter() {

    }

    public static CallsCounter getInstance() {

        if(instance == null)
        {
            instance = new CallsCounter();
        }

        return instance;
    }

    public void addCall(String methodName)
    {
        calls.add(methodName);
    }

    public static void registerCall(String methodName)
    {
        CallsCounter counter = getInstance();
        counter.addCall(methodName);
    }

    public String toString() {
        return "HELLO THIS IS CALLS COUNTER";
    }
}
