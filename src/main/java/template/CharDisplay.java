package template;

public class CharDisplay extends AbstractDisplay {
    private char ch;

    public CharDisplay(char ch) {
        this.ch = ch;
    }

    @Override
    public void open() {
        System.out.printf("<<");
    }

    @Override
    public void print() {
        System.out.printf(String.valueOf(ch));
    }

    @Override
    public void close() {
        System.out.println(">>");
    }
}
