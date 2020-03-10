package abstractFactory.framework;

public abstract class Link extends Item {
    protected String url;

    public Link(String caption, String url) {
        super(url);
        this.url = url;
    }

}
