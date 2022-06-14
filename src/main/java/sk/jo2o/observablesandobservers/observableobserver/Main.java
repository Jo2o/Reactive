package sk.jo2o.observablesandobservers.observableobserver;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class Main {

    public static void main(String[] args) {
        
        Observable<Integer> source = Observable.create(
            new ObservableOnSubscribe<>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
                    try {
                        emitter.onNext(10);
                        emitter.onNext(11);
                        emitter.onNext(12);
                        emitter.onComplete();
                    } catch (Throwable t) {
                        emitter.onError(t);
                    }
                }
            }    
        );
        
        Observer<Integer> observer = new Observer<>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("SUBSCRIBED");   
            }
            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println("OnNext: " + integer);
            }
            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
            }
            @Override
            public void onComplete() {
                System.out.println("COMPLETED");
            }
        };
        
        source.subscribe(observer);
    }

}
