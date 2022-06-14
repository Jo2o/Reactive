package sk.jo2o.observablehotandcold;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;

/**
 * Converts cold observable into hot: publish() + connect()
 */
public class ConnectableObservable {

    @SneakyThrows
    public static void main(String[] args) {

        io.reactivex.rxjava3.observables.@NonNull ConnectableObservable<Long> hotSource = Observable.interval(1, TimeUnit.SECONDS).publish();
        hotSource.connect();
        hotSource.subscribe(System.out::println);
        
        TimeUnit.SECONDS.sleep(5);

        hotSource.subscribe(System.out::println); // will miss the previous

        TimeUnit.SECONDS.sleep(5);

//        0
//        1
//        2
//        3
//        4
//-------------------        
//        5
//        5
//        6
//        6
//        7
//        7
//        8
//        8
//        9
//        9
    }
}
