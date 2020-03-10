package decorator;

/*
 * Decorator: 꾸미는자
 * 크림케이크, 초코케이크, 딸기케이크 등 모든 케이크는 스펀지 케이크에 데코를 더한것이다. Decorator 는 객체지향의 기본,
 *
 * 구성요소
 * Component - 핵심기능(스펀지 케이크), Display 가 역할 담당
 * ConcreteComponent - 구체적 핵심기능, StringDisplay 가 역할 담당
 * Decorator - 장식자 역할, Component의 API를 구현하면서 동시에 자신이 장식대상(Component)가 될 수 있다, 그리고 자신이 장식할 대상을 필드로 갖는다.
 *  Border가 해당역할 담당
 * ConcreteDecorator - 구체적 장식자 역할, 어떻게 장식할 것인지 결정, SideBorder, FullBorder 가 역할 담당
 *
 * Decorator 패턴에서 중요한 것은 내용물과 장식자 모두 Component 라는것, Border와 Display 구현체 모두 Display의 하위객체.
 * */
public class DecoratorMain {
    public static void main(String[] args) {
        Display b1 = new StringDisplay("Hello World");
        Display b2 = new SideBorder(b1, '#');
        Display b3 = new FullBorder(b2);
        b1.show();
        b2.show();
        b3.show();
        Display b4 = new SideBorder(
                new FullBorder(
                        new SideBorder(
                                new FullBorder(
                                        new StringDisplay("hello")
                                ), '*'
                        )
                ), '/'
        );

        b4.show();
    }
}
