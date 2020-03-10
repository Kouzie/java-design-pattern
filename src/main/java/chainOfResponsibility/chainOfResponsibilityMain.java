package chainOfResponsibility;

/*
 * chainOfResponsibility: 책임 떠넘기기
 * 복수의 객체(Object)를 사슬(chain)처럼 연결해 두고 목족한 객체를 찾을때 까지 돌아다니는 패턴
 *
 * 문제(Trouble)를 처리하는 객체(Support) 를 정의하고 사슬처럼 엮는다.(list 형식으로)
 *
 * 구성요소:
 * 1. Handler(처리자) - 문제를 처리하는 구체적 역할, 처리못하면 떠넘기고 최종적으로 처리못하면 예외나 처리못하는 루틴 실행, Support 클래스가 해당 역할
 * 2. ConcreteHandler(구체적 처리자) - 특정 문제를 처리할 수 있도록 특정구현한 클래스, Limit, Odd, Special, NoSupport 가 해당 역할
 * 3. Client(요구자) - Main 클래스가 해당 역할. Chain 을 구축하고 문제를 던지는 담당
 * */
public class chainOfResponsibilityMain {
    public static void main(String[] args) {
        Support alice = new NoSupport("alice");
        Support bob = new LimitSupport("bob", 100);
        Support charlie = new SpecialSupport("charlie", 429);
        Support diana = new LimitSupport("diana", 200);
        Support elmo = new OddSupport("elmo");
        Support fred = new LimitSupport("fred", 300);

        alice
                .setNext(bob)
                .setNext(charlie)
                .setNext(diana)
                .setNext(elmo)
                .setNext(fred);

        for (int i = 0; i < 500; i+=33) {
            alice.support(new Trouble(i));
        }
    }
}
