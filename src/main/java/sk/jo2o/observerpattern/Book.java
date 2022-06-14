package sk.jo2o.observerpattern;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
@ToString
public class Book implements Subject {
    
    @Setter
    private List<Observer> observers = new ArrayList<>();
    
    @NonNull
    @Setter
    private String name;
    @NonNull
    @Setter
    private String author;
    @NonNull
    @Setter
    private double price;
    @NonNull
    private String inStock;
    
    public void setInStock(String inStock) {
        this.inStock = inStock;
        log.info("Availability changed from SOLD-OUT to IN-STOCK!");
        notifyObserver();
    }
    
    @Override
    public void subscribeObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        log.info("Book arrived: {}", this);
        log.info("Informing observers");
        observers.forEach(observer -> observer.update(this.inStock));
    }
}
