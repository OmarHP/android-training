package com.example.android.et027_rxjava;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Aptivist-U001 on 10/30/2017.
 */

public class RxJavaLambda {
    public static void main(String[] args) {
        Integer[] integers = new Integer[]{5, 6, 7, 8};
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);

        Observable<Integer> observable1 = Observable.just(1, 2, 3, 4);
        Observable<Integer> observable2 = Observable.fromArray(integers);
        Observable<Integer> observable3 = Observable.fromIterable(integerList);

        Observer<Integer> observer1 = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("d = [" + d + "]");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("integer = [" + integer + "]");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("e = [" + e + "]");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete:");
            }
        };

        Observer<String> observer2 = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("d = [" + d + "]");
            }

            @Override
            public void onNext(String s) {
                System.out.println("s = [" + s + "]");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("e = [" + e + "]");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        observable1.subscribe(observer1);
        observable2.subscribe(observer1);
        observable3.subscribe(observer1);

        observable1.concatWith(observable2)
                .subscribe(observer1);

        observable1.mergeWith(observable2)
                .subscribe(observer1);

        observable3.filter(integer -> integer % 2 != 0)
                .subscribe(observer1);

        observable1.concatWith(observable2)
                .filter(integer -> integer % 2 == 0)
                .subscribe(observer1);

        observable3.map(integer -> integer.toString()).subscribe(observer2);

        observable3.map(integer -> integer*integer).subscribe(observer1);

        observable1.zipWith(observable2, (integer, integer2) -> String.format("%s-%s", integer, integer2)).subscribe(observer2);

        observable3.filter(integer -> integer % 2 != 0)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(observer1);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
