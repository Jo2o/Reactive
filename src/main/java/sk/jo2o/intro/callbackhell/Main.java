package sk.jo2o.intro.callbackhell;

import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        log.info("Main thread running ...");
        
        Runnable runnable = () -> new Main().runningAsync(() -> log.info("Callback called ..."));
        Thread thread = new Thread(runnable);
        thread.start();

        TimeUnit.SECONDS.sleep(10);
        
        log.info("Main thread completed!");
    }
    
    @SneakyThrows
    public void runningAsync(MyCallback myCallback) {
        log.info("Running in another thread ...");
        TimeUnit.SECONDS.sleep(2);
        myCallback.call();
    }

}
