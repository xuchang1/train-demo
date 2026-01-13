package org.example;

import rx.Observable;
import rx.schedulers.Schedulers;

public class DebugObservable1 {

    public static void main(String[] args) throws Exception {
        // 定义被观察者（数据源）
        Observable<Integer> observable = Observable.range(1, 5);

        observable
                .map(i -> {
                    System.out.println("map1 : " + Thread.currentThread().getName() + ", " + i);
                    return i * 10;
                })
                // subscribeOn 定义被观察者执行的异步线程池
                .subscribeOn(Schedulers.io())       // 数据发射在 IO 线程
                .map(i -> {
                    System.out.println("map2 : " + Thread.currentThread().getName() + ", " + i);
                    return i * 10;
                })
                // observeOn 定义观察者执行的异步线程池
                .observeOn(Schedulers.computation()) // 观察者在计算线程
                // 操作符，对数据源中的数据执行的操作
                .map(i -> {
                    System.out.println("map3 : " + Thread.currentThread().getName() + ", " + i);
                    return i * 10;
                })
                // subscribe 之后的逻辑，即是定义观察者（订阅者）
                // 以上逻辑都属于定义阶段，并没有真正被执行。subscribe 这一步定义观察者逻辑，才会触发真正的上面所有流程的操作。
                .subscribe(i -> System.out.println(Thread.currentThread().getName() + " 接收到: " + i));

        Thread.sleep(2000); // 等待异步线程完成
    }
}
