package bridge;

import bridge.functionclass.CountDisplay;
import bridge.functionclass.Display;
import bridge.implementclass.StringDisplayImpl;

/*
* 두 장소를 연결하는 역할을 하는 다리처럼 기능의 클래스, 구현의 클래스를 연결하는 패턴
* 무엇인가 표시하는 기능의 클래스 - Display
* 무언인가 해당 횟수만큼 표시하는 기능의 클래스 -CountDisplay
*
* 어떤걸 어떻게 표시할껀지 구현한 클래스 - StringDisplayImpl
*
* StringDisplayImpl 클래스가 어떻게 Display, CountDisplay 클래스와 연결되어 출력되는지 확인
* StringDisplayImpl -> DisplayImpl -> Display -> CountDisplay (Display 의 impl 필드가 다리역할을 해준다)
*
* 구서요소
* Abstraction(추상화) - 기능의 클래스의 최상위 클래스, Display,
*
* RefinedAbstraction(개선된 추상화) - CountDisplay, 추상화에 추가기능을 더한 클래스
*
* Implementor(구현자) - 구현 클래스의 최상위 클래스, DisplayImpl, 추상화의 기능구현을 위한 메소드를 규정!
*
* Concrete Implementor(구체적 구현자) - StringDisplayImpl
* */
public class BridgeMain {
    public static void main(String[] args) {
        Display d1 = new Display(new StringDisplayImpl("Hello Korea!"));
        Display d2 = new CountDisplay(new StringDisplayImpl("Hello World!"));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello Universe!"));


        d1.display();
        d2.display();
        d3.display();
        d3.multiDisplay(5);
    }
}
