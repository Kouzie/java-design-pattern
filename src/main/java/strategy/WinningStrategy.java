package strategy;

import java.util.Random;

public class WinningStrategy implements Strategy {
    private Random random;
    private boolean won = false;
    private Hand prevHand;

    public WinningStrategy(int seed) {
        this.random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        if (!won) //이전경기에서 졌다면(첫경기) 새로운 전략을
            prevHand = Hand.getHand(random.nextInt(3));
        return prevHand; //이겼다면 똑같은 손을 전달
    }

    @Override
    public void study(boolean win) {
        won = win;
    }
}
