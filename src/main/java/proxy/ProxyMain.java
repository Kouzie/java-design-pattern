package proxy;

/*
 * Proxy (대리인) - 필요해지면 만들기
 * IT에서 자주 사용되는 용어,
 *
 * 특정 인스턴스를 생성하는 매우 많은 시간이 걸릴 경우
 * 굳이 인스턴스 생성이 필요 없는 코드는 Proxy에서 해결하고
 * 꼭 인스턴스가 필요한 경우에만 실제 Real 객체를 통해 처리한다.
 *
 * 예제의 경우 이름 설정과 같은 로직은 Proxy에서
 * 실제 이름을 출력하는건 Proxy 를 통해 Real 객체에서 처리한다.
 *
 * 구성요소:
 * Subject(주체) - Proxy 의 역할, RealSubject 의 역할을 일치화 하기 위한 인터페이스, 둘 다 Subject 를 구현함으로 Client 가 별 차이 없이 사용가능하다.  Printable 가 해당 역할
 * Proxy(대리인) - Client 의 역할을 처리할 수 있을정도만 구현, 이름 설정정돈 Proxy 가 할 수 있지만 출력은 RealSubject 가 필요하다. 정말 필요할때 RealSubject 를 생성하고 처리를 떠넘긴다. PrinterProxy 가 해당 역할
 * RealSubject(실제주체) - Proxy 와 마찬가지로 Subject 를 구현, Printer 가 해당 역할
 *
 * Printer 는 PrinterProxy 가 존재하는지 모른다.
 *
 * 프록시 패턴의 종류
 * 1. Virtual Proxy - 정말 인스턴스가 필요한 시점에 생성/초기화해 실행
 * 2. Remote Proxy - 원격 프로시저 호출시에 사용, 반대편에 정의된 메서드를 마치 자신의 메서드 처럼 사용
 * 3. Access Proxy - 정해진 사용자는 허용, 그외에는 에러로 처리하는 Proxy
 *
 * */
public class ProxyMain {
    public static void main(String[] args) {
        Printable printable = new PrinterProxy("alice");
        System.out.println("이름은 현재 " + printable.getPrinterName() + "입니다");
        printable.setPrinterName("bob");
        System.out.println("이름은 현재 " + printable.getPrinterName() + "입니다");

        printable.print("Hello world");
        printable.setPrinterName("jason");
    }
}
