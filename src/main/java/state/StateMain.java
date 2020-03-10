package state;

/*
 * 특정 상태를 클래스로 표현하는 패턴
 * 상태의 변화, 추가 등을 쉽게 처리할 수 있다.
 *
 * 실존하는 객체가 아닌 상태를 객체화 한다는 것에 이질감이 느껴지지만 복잡한 조건문 대신 상태값을 통해 비지니스 로직을 처리하고 싶을때 사용하면 유지보수에 좋다.
 *
 * 아래의 경우 특정 작업(버튼누르기)가 상태(주간,야간)에 따라 다른 결과값을 반환한다.
 *
 * 구성요소
 * State(상태) - 객체의 상태를 나타냄, 객체가 상태에서 동작할 API를 정의, 상태에 의존한 동작을 하는 메소드의 집합이다. State 인터페이스가 해당 역할
 * ConcreteState(구체적 상태) - 객체의 상태의 구현, 특정 상태에서 동작하는 API 구현, DayState, NightState 가 해당 역할
 * Context(상황, 문맥) - 현재의 상태를 저장하기 위한 역할, State를 변경하는 API를 지원, 또한 ConcreteState 를 지원하며 각 State 에서 행동할 메서드를 제공
 *  특정 상황(State)에서 버튼을 누르면 문맥(Context)에 맞게 동작하도록 비지니스 로직 메서드 API 르 제공하는 클래스
 * ConcreteContext - Context 를 구현한 클래스,
 *
 * 상태 변화를 누가 하는지 자세히 보면 main(시간입력) -> context 가 doClock 호출(State에게 시간 전달) -> 시간 확인후 상태전환
 * 결과적으론 실제 상태전환 코드를 실행하는 건 State 이다.
 * 이렇게 되면 ConcreteState 간 의존성이 높아지기에 변환역할을 State 가 아닌 context 에서 처리하게 할 수 도 있다.
 * */
public class StateMain {
    public static void main(String[] args) {
        SafeFrame frame = new SafeFrame("state sample");
        while(true) {
            for (int hour = 0; hour < 24; hour++) {
                frame.setClock(hour);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
