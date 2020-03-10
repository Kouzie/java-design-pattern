package builder;

/*
* 한번에 정형화된 인스턴스를 생성하기 보단 단계적으로 쌓아올리는 방식
*
* 구성요소
* 1. Builder 인스턴스의 각 부분을 작성하기위한 메소드 준비, 아래 예제의 경우 title, string, items 부분을 위한 메서드 정의
* 2. ConcreteBuilder 구체적으로 어떤 파일(텍스트, html)을 작성할건지 Builder를 구현
* 3. Directort 실제 Builder, ConcreteBuilder 인스턴스를 사용해
* */
public class BuilderMain {
    public static void main(String[] args) {
        String temp = "html";
        if (temp.equals("plain")) {
            TextBuilder textBuilder = new TextBuilder();
            Director director = new Director(textBuilder);
            director.construct();
            String result = textBuilder.getResult();
            System.out.println(result);
        } else if(temp.equals("html")){
            HTMLBuilder htmlBuilder = new HTMLBuilder();
            Director director = new Director(htmlBuilder);
            director.construct();
            String fileName = htmlBuilder.getResult();
            System.out.println(fileName + " 작성완료");
        } else {
            usage();
            System.exit(0);
        }
    }

    private static void usage() {
        System.out.println("Usage : java Main Plain 일반 텍스트로 문서 작성");
        System.out.println("Usage : java Main html HTML 파일로 문서 작성");
    }
}