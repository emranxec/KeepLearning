package com.xec.promise;

import org.riversun.promise.Action;
import org.riversun.promise.Func;
import org.riversun.promise.Promise;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    static final ExecutorService myExecutor = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        Func function = Test::run;

        Func function1 = (action, data) -> {
            Promise.sleep(1000);

            String newString = data + " imran";
                System.out.println(newString);
                action.resolve(newString + " " + " ,function1, ");
            };

        Func function2 = (action, data) -> {
            Promise.sleep(1000);
            System.out.println("No.1 " + Thread.currentThread());
          //  String newString = "Sorry " + " imran";
          //  System.out.println(newString);
            action.resolve(data + " " + " ,function2, ");

        };

        Func function3 = (action, data) -> {
            Promise.sleep(1000);
            System.out.println("No.1 " + Thread.currentThread());

           // String newString = "Don't worry! we have some backup ready";
          //  System.out.println(newString);
          //  action.resolve();
            action.resolve(data + " " + " ,function3, ");

        };

        Func finalFunc = (action, data) -> {
            Promise.sleep(1000);
            System.out.println("No.1 " + Thread.currentThread());

            System.out.println("Received the final result.");
            List<Object> resultList = (List<Object>) data;
            for (int i = 0; i < resultList.size(); i++) {
                Object result = resultList.get(i);
                System.out.println("finalFunc operation : " + (i + 1) + " is " + result);
            }
            action.resolve();
        };

 /*       Promise.resolve()
                .then(
                        function
                )
                .then(
                        function1,
                        function2
                ).always(function3)
                .start();*/
        Promise.all(myExecutor,function,function1, function2, function3)
                .always(finalFunc)
                .start();// start asynchronous operations

        System.out.println("promised something");



}


    private static void run(Action action, Object data) {
        Promise.sleep(1000);
        System.out.println("No.1 " + Thread.currentThread());
        new Thread(() -> {
            String newData = "hello";
            action.resolve(newData);
        }).start();
    }
}
