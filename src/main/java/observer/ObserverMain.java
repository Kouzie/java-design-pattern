package observer;

/*
 * Observer(관찰자)
 * 관찰 대상의 상태가 변경하면 관찰자에게 알리고 변화에 따른 처리를 편하게 할 수 있는 패턴
 *
 * 숫자를 생성하고 생성됨을 알리는 NumberGenerator
 * 생성된 숫자를 처리하는 Observer
 *
 * 구성요소
 * Subject(관찰대상자) : 관창당하는 객체, Observer 등록/삭제 api, 현재 상태를 Observer 에 알리는(observer.notify 호출) api 있다.
 * Observer(관찰자) : Subject 의 notify 호출로 인해 Subject 의 상태를 검사하고 특정 작업을 수행
 *
 * 말이 관찰이지 전달자와 전달대기자이다. 구독/발생 시스템 구축시에 유리하다.
 *
 * Observer가 다른 종류의 Observer나 Subject에 영향을 끼치는 등 의존성이 있다면 문제가 될 수 있다.
 * 최대한 의존성을 줄이되 Subject에 영향을 끼칠때 이로인해 다른 Observer에게 영향을 끼치는지도 확인해야 한다.
 *
 * java.util.Observer(인터페이스), Observable(클래스)
 *
 * Observer 내부에 아래 메서드가 정의되어있다.
 * public void update(Observable obj, Object arg)
 * Subject 역할의 Observable, 부가정보로 arg를 받는다.
 *
 * 다중상속이 불가능한 Observable 클래스를 상위객체로 두는것은 많은 것을 포기해야 하기에 잘 사용하지 않는다.
 *
 * */
public class ObserverMain {
    public static void main(String[] args) {
        NumberGenerator generator = new RandomNumberGenerator();
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.execute();
    }
}