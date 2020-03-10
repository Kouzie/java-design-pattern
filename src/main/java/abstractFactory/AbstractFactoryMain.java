package abstractFactory;

import abstractFactory.framework.Factory;
import abstractFactory.framework.Link;
import abstractFactory.framework.Page;
import abstractFactory.framework.Tray;

/*
* Factory 패턴이 단순 인스턴스를 일정한 틀(template)에 맞게 만들어 내는거라면
* Abstract Factory 패턴은 여러개의 추상적 부품을 사용해 하나의 추상적 제품을 만드는 패턴
* 부품 Link, Link 를 담는 부품 Tray, Tray 를 담는부품 Page
* 그리고 이런 부품을을 하나로 칭하기 위해 제일 하위 클래스로 Item을 깔고간다.
*
* 그리고 위의 추상적 부품을들 구현하는 ListLink ListTray ListPage, 이 부품을만들어내는 ListFactory 정의하자.
*
* 구성요소:
* AbstractProduct(추상 제품) - Link, Tray, Page 클래스가 역할 수행, 제품의 기본적 API(Tray,Page 의 add(Item), makeHTML, 기본 속성명세
* AbstractFactory(추상 공장) - Factory클래스가 역할 수행, AbstractProduct 인스턴스 생성을 위한 API정의
* Client(의뢰자) - AbstractProduct AbstractFactory의 API를 사용해 구체적 부품, 제품 생성, Main이 역할 수행중
* ConcreteProduct(구체적 제품) - ListLink... 클래스가 역할 수행,
* ConcreteFactory(구체적 공장) - ListFactory 클래스가 역할 수행, AbstractFactory의 api 구현,
*
* 새로운 종류의 Factory를 추가하는 것은 기존 명세에만 맞춰(Item을 밑에깔고 makeHTML구현) 정의하면 되어 Main로직을 변경할 필요 x
* 단 Link, Tray, Page외에 새로운 부품을 추가하는 것은 곤란(Picture추가), 새로운 구현클래스를 모두 생성해줘야 함(ListPicture, TablePicture등 추가).
* */
public class AbstractFactoryMain {

    public static void main(String[] args) {

        Factory factory = Factory.getFactory("abstractFactory.implement.ListFactory");

        Link joins = factory.createLink("중앙일보", "http://www.joins.com/");
        Link chosun = factory.createLink("조선일보", "http://www.chosun.com/");

        Link us_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/");
        Link naver = factory.createLink("Naver", "http://www.naver.com/");
        Link excite = factory.createLink("Excite", "http://www.excite.com/");
        Link google = factory.createLink("google", "http://www.google.com/");

        Tray trayNews = factory.createTray("신문");
        trayNews.add(joins);
        trayNews.add(chosun);

        Tray traySearch = factory.createTray("검색엔진");
        traySearch.add(us_yahoo);
        traySearch.add(naver);
        traySearch.add(excite);
        traySearch.add(google);

        Page page = factory.createPage("LinkedPage", "영진닷컴");
        page.add(trayNews);
        page.add(traySearch);
        page.output();
    }
}
