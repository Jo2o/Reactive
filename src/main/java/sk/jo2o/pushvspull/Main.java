package sk.jo2o.pushvspull;

import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        log.info("Main thread running ...");
        
        Runnable runnable = () -> new Main().runningAsync(
            new MyCallback() {
                @Override
                public void pushData(String data) {
                    log.info("Callback data: {}", data);
                }
                @Override
                public void pushComplete() {
                    log.info("Callback completed.");
                }
                @Override
                public void pushError(Exception exception) {
                    log.error("Callback error called:", exception);
                }
            }
        );
        Thread thread = new Thread(runnable);
        thread.start();

        TimeUnit.SECONDS.sleep(10);
        
        log.info("Main thread completed!");
    }
    
    @SneakyThrows
    public void runningAsync(MyCallback myCallback) {
        log.info("Running in another thread ...");
        TimeUnit.SECONDS.sleep(2);
        
        myCallback.pushData("DATA-01");
        myCallback.pushData("DATA-02");
        myCallback.pushData("DATA-03");
        myCallback.pushError(new RuntimeException("RTE EX - Oops"));
        myCallback.pushComplete();
    }

}
