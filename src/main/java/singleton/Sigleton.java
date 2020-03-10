package singleton;

public class Sigleton {
    private static Sigleton sigleton = new Sigleton();

    private Sigleton() {
        System.out.println("create instance");
    }
    public static Sigleton getInstance(){
        return sigleton;
    }
}
