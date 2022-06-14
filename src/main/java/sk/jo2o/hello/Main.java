package sk.jo2o.hello;

import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    
    @SneakyThrows
    public static void main(String[] args) {

        Observable<String> producer = Observable.create(
            emitter -> {
                log.info("Started emitting ...");
                emitter.onNext("Hello");
                emitter.onNext("RxJava");
            }
        );
       
        producer.subscribe(str -> log.info("Observer 1 - consumed: {}", str));
        producer.subscribe(str -> log.info("Observer 2 - consumed: {}", str));
    }
}
