package memento;

/*
 * memento: 기념품
 * 객체의 상태를 저장, 복원하는데 사용하는 패턴
 *
 * 구성요소:
 * Originator(작성자) - 자신의 현상태를 저장하고 싶을때 Memento 객체를 생성, 복원하고 싶을때 복원하는 처리를 하는 클래스,  Gamer 가 해당 역할
 * Memnto(기념품) - Originator 내부의 상태를 저장, 정리하는 클래스, Originator 가 Memento 를 만들어 내기 때문에 둘의 의존성이 매우 강함.
 * Caretaker(경비원) - Originator 의 상태를 Memento 에 저장시키고 보관하다 Memento 를 다시 Originator 에 저장시키는 클래스, Caretaker 는 Memento를 보관만 할 뿐 내부에 접근하진 않는다. Main 클래스가 해당 역할
 * */
public class MementoMain {
    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);
        Memento memento = gamer.createMemento();
        for (int i = 0; i < 100; i++) {
            System.out.println("====" + i);
            System.out.println("현상: " + gamer);
            gamer.betting();

            System.out.println("소지금은 " + gamer.getMoney() + "원이 되었습니다.");
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("소지금이 증가했음으로 현 상태를 저장");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("소지금이 반타작 아래로 떨어져버렸다.... 복원!");
                gamer.restoreMemento(memento);
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("");
        }
    }
}
