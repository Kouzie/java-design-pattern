package visitor;


/*
 * Visitor(방문자)
 * 트리구조의 각 요소를 돌며 해당 요소의 데이터로 특정처리를 할 경우 해당 요소클래스 안에 처리구문을 메서드로 작성할 것인지
 * 방문자 클래스의 각 요소의 처리 메서드를 작성할 것인지
 * 전자라면 새로운 처리방식이 생기거나 수정할 때마다 해당 클래스를 수정해야 하지만 후자의 경우 방문자 클래스파일만 수정하면 된다.
 *
 * 방문 가능한 요소(Element)는 Entry이며 Entry의 종류는 File, Directory가 있다.
 * 모든 요소(Element)를 구현하는 클래스는 Visitor 클래스를 맞이하는 accept 메서드를 정의할 필요가 있다.
 * accept 메서드는 별달리 할거 없다 방문한 Visitor의 visit 메서드만 호출하면 된다.
 *
 * 이제 개발자가 입맛에 맞게 Visitor만 구현해주면 된다. ListVisitor는 단순히 폴더/파일 명을 과 용량을 출력하면 된다.
 * 출력외에 다른작업을 할 때에도 Element 들은 변경 필요 없이 새로운 Visitor만 구현하면 된다.
 *
 * 더블 디스페치(이중분리): 위처럼 visitor와 element 한쌍으로 역할을 수행하는 구조
 *
 * 구성요소
 * Visitor(방문자) - 각 Entry 를 돌아다는 클래스 visit(element) 메서드가 있어야함, Visitor 가 해당 역할
 * ConcreteVisitor - 각 Entry 를 돌아다니며 Entry 에 모종의 작업을 수행, ListVisitor 가 해당 역할
 * Element(요소) - 방문자를 받아들이는 맞이하는 클래스 accept(visitor) 메서드가 있어야함, Element 가 해당 역할
 * ConcreteElement - 맞이하는 클래스의 구현체, 내부의 어떤 데이터가 있는지 정의
 * ObjectStructure(객체 구조) - Element(요소)의 집합해줄 수 있는 객체, Directory 가 해당역할,
 * */
public class VisitorMain {
    public static void main(String[] args) {
        try {
            System.out.println("Making root entries...");
            Directory rootdir = new Directory("root");
            Directory bindir = new Directory("bin");
            Directory tmpdir = new Directory("tmp");
            Directory usrdir = new Directory("usr");
            rootdir.add(bindir);
            rootdir.add(tmpdir);
            rootdir.add(usrdir);
            bindir.add(new File("vi", 10000));
            bindir.add(new File("latex", 20000));
            rootdir.accept(new ListVisitor());

            System.out.println("");
            System.out.println("Making user entries...");
            Directory Kim = new Directory("Kim");
            Directory Lee = new Directory("Lee");
            Directory Park = new Directory("Park");
            usrdir.add(Kim);
            usrdir.add(Lee);
            usrdir.add(Park);
            Kim.add(new File("diary.html", 100));
            Kim.add(new File("Composite.java", 200));
            Lee.add(new File("memo.tex", 300));
            Park.add(new File("game.doc", 400));
            Park.add(new File("junk.mail", 500));
            rootdir.accept(new ListVisitor());
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }
}
