package abstractFactory.implement;

import abstractFactory.framework.Item;
import abstractFactory.framework.Page;

public class ListPage extends Page {
    public ListPage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<html><head><title>" + title + "</title></head></html>");
        stringBuffer.append("<body>\n");
        stringBuffer.append("<h1>" + title + "</h1>\n");
        stringBuffer.append("<ul>\n");

        for (Item item : this.content) {
            stringBuffer.append(item.makeHTML());
        }
        stringBuffer.append("</ul>\n");
        stringBuffer.append("<hr><address>" + author + "</address>\n");
        stringBuffer.append("</body></html>\n");
        return stringBuffer.toString();
    }

}
