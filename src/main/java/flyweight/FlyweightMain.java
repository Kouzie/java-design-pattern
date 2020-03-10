package flyweight;


/*
 * Flyweight : 권투에서 사용되는 용어 플라이급 이란 뜻
 *
 * 메모리 사용량을 최소한으로 줄이기 위해 최대한 이미 생성되어 있는 인스턴스를 재사용할 수 있도록 하는 패턴
 * pool 과 같은 저장소를 구성하고 필요할때 마다 꺼내쓰는 패턴이 Flyweight 에 해당한다.
 * 리소스가 많이 필요한 file reader 를 통해 BigChar 에 데이터를 저장하고 이를 pool 에 저장,
 *
 * Flyweight(플라이급) - pool에 저장되어 필요할때 마다 꺼내어지는 재활용 공유 객체, BigChar 이 해당역할
 * FlyweightFactory - Flyweight 객체를 생성해 pool에 저장, BigCharFactory 이 해당역할
 * Client - FlyweightFactory 를 사용해 Flyweight 를 만들고 사용하는 역할, BigString 이 해당역할
 *
 * 모든 프로그램이 그렇듯이 공유는 항상 예기치 않은 오류를 발생시킬 수 있다.
 * 명확히 공유할 내용을 Flyweight 에, 공유하지 않을 부가정보는 외부(Client 나 Flyweight 를 포함하는 다른 객체) 에 두도록 하자.
 *
 * */
public class FlyweightMain {
    public static void main(String[] args) {
        BigString bigString = new BigString("123456789-0");
        bigString.print();
    }
}
