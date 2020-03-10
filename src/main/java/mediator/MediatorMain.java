package mediator;

/*
 * Mediator(중재인)
 * 다수의 객체가 상호작용하며 밀접하게 연관되어있을때 Mediator 패턴을 사용하면 효과적이다.
 * 비지니스 로직을 한곳에 집중시켜 관리하도록 하는 패턴, 디버깅, 유지보수가 편하다.
 *
 * 구성요소
 * Mediator - 중개인 표현 인터페이스, 버튼, 텍스트필드 생성(createColleagues), 특정 이벤트 발생시 중개인에게 통보하도록 호출(colleagueChanged), Mediator 클래스가 해당 역할
 * Colleague(동료) - 각종 이벤트가 발생할때 마다 Mediator 에게 보고, Mediator 의 지시에 따라 유/무효 될수 있는 api를 정의하는 인터페이스, Colleague 클래스가 해당 역할
 * ConcreteColleague - 버튼, 텍스트, 체크박스와 같은 특정 목적(로그인)을 위해 서로 긴밀하게 연관되어 있는 클래스
 * ConcreteMediator - 중개자의 구현 클래스, 각종 이벤트의 처리, 처리과정에서 Colleague 들의 상태 변경을 담당하는 클래스, LoginFrame 클래스가 해당 역할
 *
 * Colleague 구현클래스들은 재활용하기 쉽지만 Mediator 구현클래스는 어렵다.
 * LoginFrame은 이미 checkBox 체크 -> 활성화된 text 입력 -> 활성화도니 pass 입력 -> 버튼 클릭
 * 위 로직이 고정되어 있다. 로그인 다이얼로그를 새로 만든다 했을때 위의 로직을 따르지 않는다면 새로 만들어야지 재활용은 못한다.
 * */
public class MediatorMain {
    public static void main(String[] args) {
        new LoginFrame("Mediator Sample");
    }
}
