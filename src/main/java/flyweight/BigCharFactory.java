package flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BigCharFactory {
    private Map<Character, BigChar> pool;

    private static BigCharFactory singletone = new BigCharFactory();

    private BigCharFactory() {
        pool = new ConcurrentHashMap();
    }

    public static BigCharFactory getInstance() {
        return singletone;
    }

    public BigChar getBigChar(char charName) {
        BigChar bigChar = pool.get(charName);
        if (bigChar == null) {
            bigChar = new BigChar(charName);
            pool.put(charName, bigChar);
        }
        return bigChar;
    }
}
