package factory;

/*
* factory - 공장
* 인스턴스 생성하는 공장을 Template Pattern 으로 구현한 것을 Factory Pattern 이라함 .
*
* 구성요소
* 1. Product - 모든 인스턴스가 기본적으로 가지는 구조(인터페이스), Product
* 2. Creator - 모든 인스턴스를 생성하는 추상클래스 framework에 가까움. new를 사용해 만드는 것보다 구체적인 클래스 하의 속박에서, Factory
* 3. ConcreteProduct - 구체적인 제품을 결정, IdCard
* 4. ConcreteCreator, IdCardFactory
*
* 만약 IdCard외에 Television 제품을 생성하고 싶다면 IdFCardactory와 상관없이 TvFactory를 새로 만들고 조금만 수정하면 된다.
* product의 default기능을 abstract로 구현하고 있을때 효율성이 증가한다.
* */
public class FactoryMain
{
    public static void main( String[] args )
    {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("홍길동");
        Product card2 = factory.create("김길동");
        Product card3 = factory.create("고길동");

        card1.use();
        card2.use();
        card3.use();
    }
}