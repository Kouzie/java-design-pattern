package prototype;

/*
 * 인스턴스를 복사해 새로운 인스턴스를 만드는 경우
 *
 * 사용되는 경우
 * 1. 종류가 너무 많아 클래스로 정리하고 싶지 않을때 - 비슷한 기능의 다양한 종류의 클래스 정의시 효율적, 밑의 MessageBox참고
 *    (각종 도형사용 패키징하는 기능의 클래스를 개별로 만들기엔...)
 * 2. 인스턴스 초기화 과정이 복잡할때 - 그냥 하나 생성해두고 복사해서 쓰자
 * 3. framework 와 생성할 인스턴스를 분리하고 싶을때 - new를 통해서가 아닌 자신이 만든 framework로 인스턴스를 생성하고 싶을때
 *
 * 구성요소
 * 1. Prototype(원형) - 새로운 인스턴스를 만들기 위한 인터페이스, Product
 * 2. ConcretePrototype(구체적 원형) - Product를 구현한 인스턴스를 복제하기 위한 메서드를 구현, MessageBox, UnderlinePen
 * 3. Client - 인스턴스 복사 메서드를 사용해 새로운 인스턴스 생성, Manager
 * */
public class PrototypeMain {
    public static void main(String[] args) {
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('~');
        MessageBox messageBox1 = new MessageBox('*');
        MessageBox messageBox2 = new MessageBox('/');
        manager.register("Strong message", upen);
        manager.register("Warning box", messageBox1);
        manager.register("Slash box", messageBox2);

        Product p1 = manager.create("Strong message");
        p1.use("Hello world");
        Product p2 = manager.create("Warning box");
        p2.use("Hello world");
        Product p3 = manager.create("Slash box");
        p3.use("Hello world");
    }
}
