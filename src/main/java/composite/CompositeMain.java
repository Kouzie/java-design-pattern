package composite;

import strategy.Hand;
import strategy.Player;
import strategy.ProbStrategy;
import strategy.WinningStrategy;

/*
 * Composite: 합성물
 * 대부분 파일 시스템은 트리구조(재귀적 구조)를 가진다, 파일이던 디렉토리던 하나의 객체를 디렉토리 엔트리라 하며
 * 파일 시스템 구조를 분석, 접근하려면 모든 객체를 동일시(혼합물로 생각) 디렉토리 엔트리라 생각하고 진행 해야 한다.
 * 재귀적 구조를 효율적으로 사용하는 것이 Composite 패턴이다.
 *
 * 구성요소:
 * Leaf(나뭇잎) - 내용물 표시, 내부에는 다른것을 넣을 수 없는 엔드포인트, File 클래스가 해당 역할
 * Composite(복합체) - 그릇을 나타내는 역할, Leaf 나 Composite 객체를 넣을 수 있음, Directory 가 해당 역할
 * Component(요소) - Leaf 와 Composite 을 동일시 하는 역할, Entry 가 해당 역할
 * Client(의뢰자) - Composite 객체를 사용하는 요소, Main 클래스가 해당 역할
 * */
public class CompositeMain {
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
            rootdir.printList();

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
            rootdir.printList();
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }
}
