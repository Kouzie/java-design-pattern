package flyweight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BigChar {
    private char charName;
    private String fontData;
    public BigChar(char charName) {
        try {
            this.charName = charName;
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("file/big" + charName + ".txt")
            );
            String line;
            StringBuffer buffer = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line);
                buffer.append("\n");
            }
            bufferedReader.close();
            this.fontData = buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
            this.fontData = charName + "?";
        }
    }

    public void print() {
        System.out.println(fontData);
    }
}
