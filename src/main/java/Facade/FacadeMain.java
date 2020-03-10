package Facade;

/*
 * Facade: 정면, 앞면, 표면
 * 복잡하게 얽혀있는 것을 정리해 높은 레벨의 인터페이스를 제공할때 사용하는 패턴
 * 복잡한 비지니스 로직은 제쳐두고 각 객체간 창구만 연결하도록 설정
 *
 * mail 주소에서 사용자 이름을 구하는 DatabaseClass
 * Html 파일을 작성하는 HtmlWriter
 * 2객체의 창구 역할(Facade)을 수행하는 PageMaker
 *
 * 구성요소
 * 1. Facade(정면) - 많은 역할에 대해 단순한 창구가 된다. PageMaker가 해당 역할, 아래의 한줄코드로 Html파일이 만들어지는 것을 확인
 *  PageMaker 는 Database 에서 데이터를 읽어오 해당 데이터를 HtmlWriter 의 title, paragraph, mailto 와 같은 메서드에 사용했다.
 * 2. 그외 기타객체 - 단순 추상화를 통해 알지못해야 하는 객체들
 * */
public class FacadeMain {
    public static void main(String[] args) {
        PageMaker.makeWelcomePage("kgy1996@naver.com", "welcome.html");
    }
}
