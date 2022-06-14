package sk.jo2o.observablesandobservers;

import io.reactivex.rxjava3.core.Observable;

public class CreatingObserver {
    
    public static void main(String[] args) {
        Observable<String> source = Observable.just("Hello", "Holla", "Ahoj");
        
        // as lambda-s: onNext, onError, onComplete
        source.subscribe(
            System.out::println,
            Throwable::printStackTrace,
            () -> System.out.println("Completed"));
    }
}
