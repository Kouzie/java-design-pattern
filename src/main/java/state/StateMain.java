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
 * State(상태) -
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
