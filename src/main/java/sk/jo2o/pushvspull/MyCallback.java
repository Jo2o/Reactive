package sk.jo2o.pushvspull;

public interface MyCallback {
    void pushData(String data);
    void pushComplete();
    void pushError(Exception exception);
}
