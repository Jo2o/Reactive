package sk.jo2o.observablehotandcold;

import io.reactivex.rxjava3.core.Observable;
import java.util.ArrayList;
import java.util.List;

/**
 * Emits whole updated list again.
 */
public class ColdObservable {

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(15);
        intList.add(16);
        intList.add(17);

        Observable<Integer> source = Observable.fromIterable(intList);
        source.subscribe(System.out::println);

        System.out.println("-------- LIST UPDATED -------");
        intList.add(18);
        source.subscribe(System.out::println);
    }

}
