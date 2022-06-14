package sk.jo2o.intro.observerpattern;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReaderUser implements Observer {
    @Setter
    @Getter
    private String name;
    
    public ReaderUser(String name, Book book) {
        this.name = name;
        book.subscribeObserver(this);           // <----- IMPORTANT !
    }
    
    @Override
    public void update(String message) {
        log.info("Hello {}, message for you: {}", name, message);
    }
}
