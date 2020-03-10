package adapter;

public class PrintBanner extends adapter.Print {
    private adapter.Banner banner;

    public PrintBanner(String string) {
        this.banner = new adapter.Banner(string);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
