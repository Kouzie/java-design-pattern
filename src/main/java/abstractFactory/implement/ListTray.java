package abstractFactory.implement;

import abstractFactory.framework.Item;
import abstractFactory.framework.Tray;

public class ListTray extends Tray {
    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<li>\n");
        stringBuffer.append(caption + "\n");
        stringBuffer.append("<ui>\n");
        for (Item item : this.tray) {
            // item이 ListLink이건 MapLink이건 상관없다 앞으로 생성할 클래스도 조건에 맞게 정의하면 된다.
            stringBuffer.append(item.makeHTML());
        }
        stringBuffer.append("</ul>\n");
        stringBuffer.append("</li>\n");
        return stringBuffer.toString();
    }
}
