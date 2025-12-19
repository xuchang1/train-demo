package org.example;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;

public class DebugObservable1 {

    public static void main(String[] args) throws Exception {

        Observable<Integer> source = Observable.defer(() -> {
                    System.out.println("[defer] executed, thread = " + Thread.currentThread().getName());
                    return Observable.just(1, 2, 3);
                })
                .doOnSubscribe(() ->
                        System.out.println("[doOnSubscribe] thread = " + Thread.currentThread().getName())
                )
                .map(x -> {
                    System.out.println("[map] " + x + ", thread = " + Thread.currentThread().getName());
                    return x * 10;
                })
                .lift(new LogOperator())  // 自定义操作符
                .doOnNext(x ->
                        System.out.println("[doOnNext] value = " + x + ", thread = " + Thread.currentThread().getName())
                )
                .doOnCompleted(() ->
                        System.out.println("[doOnCompleted] thread = " + Thread.currentThread().getName())
                )
                .doOnTerminate(() ->
                        System.out.println("[doOnTerminate] thread = " + Thread.currentThread().getName())
                )
                .doOnUnsubscribe(() ->
                        System.out.println("[doOnUnsubscribe] thread = " + Thread.currentThread().getName())
                )
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation());

        Subscription sub = source.subscribe(
                x -> System.out.println("[onNext] " + x + ", thread = " + Thread.currentThread().getName()),
                e -> System.out.println("[onError] " + e),
                () -> System.out.println("[onCompleted] thread = " + Thread.currentThread().getName())
        );

        // 模拟稍后取消订阅（触发 doOnUnsubscribe）
        Thread.sleep(1000);
        sub.unsubscribe();

        Thread.sleep(2000);
    }

    // 自定义 lift Operator：打印每个事件
    static class LogOperator implements Observable.Operator<Integer, Integer> {
        @Override
        public Subscriber<? super Integer> call(Subscriber<? super Integer> downstream) {

            return new Subscriber<Integer>() {
                @Override
                public void onNext(Integer value) {
                    System.out.println("[lift] onNext = " + value + ", thread = " + Thread.currentThread().getName());
                    downstream.onNext(value);
                }

                @Override
                public void onError(Throwable e) {
                    System.out.println("[lift] onError, thread = " + Thread.currentThread().getName());
                    downstream.onError(e);
                }

                @Override
                public void onCompleted() {
                    System.out.println("[lift] onCompleted thread = " + Thread.currentThread().getName());
                    downstream.onCompleted();
                }
            };
        }
    }
}
