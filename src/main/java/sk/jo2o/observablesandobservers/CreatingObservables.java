package sk.jo2o.observablesandobservers;

import io.reactivex.rxjava3.core.Observable;
import java.util.List;

public class CreatingObservables {

    public static void main(String[] args) {
        
        
        System.out.println("---------------------- CREATE ----------------------");
        Observable<Integer> intSource = Observable.create(
            emitter -> {
                emitter.onNext(10);
                emitter.onNext(11);
                emitter.onComplete();
            });
        intSource.subscribe(System.out::println);

        
        System.out.println("---------------------- JUST ----------------------"); // implicitly called: onNext, onComplete, onNext
        Observable<Integer> intSourceJust = Observable.just(1, 2, 3);
        intSourceJust.subscribe(System.out::println);

        
        System.out.println("---------------------- FROM ITERABLE ----------------------");
        List<String> names = List.of("Shaun", "Jessie", "Mark");
        Observable<String> namesSource = Observable.fromIterable(names);
        namesSource.subscribe(System.out::println);
        
        
    }
}
