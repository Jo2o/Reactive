package sk.jo2o.observablesandobservers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;

public class Disposing {
    
    private static final CompositeDisposable compositeDisposable = new CompositeDisposable();
    
    @SneakyThrows
    public static void main(String[] args) {

        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);
        
        Disposable disposable1 = source.subscribe(e -> System.out.println("Observer 1 : " + e));
        Disposable disposable2 = source.subscribe(e -> System.out.println("Observer 2 : " + e));
        
        TimeUnit.SECONDS.sleep(5);

//        disposable1.dispose();
        
        compositeDisposable.addAll(disposable1, disposable2);
        compositeDisposable.dispose();
        
        TimeUnit.SECONDS.sleep(8);
        
//        source.subscribe(new Observer<>() {
//            private Disposable disposable;                 // <<<<<<<<<<<<<<<<<<< added by myself
//            
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//                disposable = d;                            // <<<<<<<<<<<<<<<<<<< now I have reference to it
//            }
//            @Override
//            public void onNext(@NonNull Long aLong) {
//            }
//            @Override
//            public void onError(@NonNull Throwable e) {
//            }
//            @Override
//            public void onComplete() {
//            }
//        });
    }
}
