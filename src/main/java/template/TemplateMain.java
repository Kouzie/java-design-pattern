package template;

/*
* 탬플릿 - 구멍이 뚤려있는 얇은 판
* 연필을 사용해 흑색으로 도형을 만들고, 색연필로 칼러풀한 도형을 만들듯이
* 템플릿을 사용해 디테일한 설정을 하위 클래스에서 구성 가능.
*
* 상위 클래스에서 뼈대를 구성하고 하위클래스에서 구체적인 내용을 결정하는 디자인 패턴
*
* 구성요소
* 1. AbstractClass 추상클래스 - AbstractDisplay
* 2. ConcreteClass 구현클래스 - CharDisplay, StringDisplay
*
* 주의사항
* 1. 상위, 하위 클래스간의 연계 - 실제 상위 클래스의 구현 하위클래스의 메서드가 어디 시점에서 호출될지 명확히 알고 정의하자.
* 2. 상위, 하위 클래스 동일시 - 상위클래스 변수로 하위클래스 인스턴스를 참조해도 작동상 문제 없도록 설계, LSP(Liskov Substitution Principle)이라 함,
* */
public class TemplateMain {
    public static void main(String[] args) {
        template.AbstractDisplay abstractDisplay1 = new template.CharDisplay('H');
        template.AbstractDisplay abstractDisplay2 = new template.StringDisplay("안녕하세요.");
        template.AbstractDisplay abstractDisplay3 = new template.StringDisplay("Hello, world!");

        abstractDisplay1.display();
        abstractDisplay2.display();
        abstractDisplay3.display();
    }
}
