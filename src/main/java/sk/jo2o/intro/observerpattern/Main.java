package sk.jo2o.intro.observerpattern;

public class Main {

    public static void main(String[] args) {
        Book book = new Book("Atlantida", "Josh Ling", 23.20, "Sold Out!");
        
        ReaderUser jozef = new ReaderUser("Jozef", book);
        ReaderUser rob = new ReaderUser("Rob", book);
        
        book.getInStock();
        book.setInStock("AVAILABLE AGAIN!!!");
    }
}
