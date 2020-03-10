package adapter;

/*
* Wrapper 패턴이라고도 함
* 상속, 위임 방식을 통해 adapter 패턴을 구현, 위임방식이 더 효율적
*
* 구성요소
* 1. target - 목적을 이루기 위한 메서드 정의(인터페이스), Print
* 2. client - target의 메서드를 사용하는 역할, AdapterMain
* 3. adaptee - 개조되는쪽, 이미 준비되어있는 핵심 기능, adapter 에 의해 포장되어 client 에게 제공, Banner
* 4. adapter - 개조하는쪽, 어쨋건 target 의 메서드를 사용해 목적을 이루는 클래스, PrintBanner
* */
public class AdapterMain {
    public static void main(String[] args) {
        adapter.Print p = new adapter.PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }
}
