package ir.maktabsharif127.jpa.designpatters;

public interface Prototype<T extends Prototype<T>> extends Cloneable {

    T clone();

}
