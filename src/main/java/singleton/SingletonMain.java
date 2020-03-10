package singleton;


/*
* 복수의 인스턴스가 존재하면 버그발생, 동기화 문제가 발생할경우 사용하는 패턴
*
* */
public class SingletonMain {
    public static void main(String[] args) {
        System.out.println("Start");
        Sigleton sigleton1 = Sigleton.getInstance();
        Sigleton sigleton2 = Sigleton.getInstance();
        if (sigleton1 == sigleton2)
            System.out.println("same object!");
        else
            System.out.println("different object!");

        System.out.println("End");
    }
}
