package strategy;

import java.util.Random;

public class ProbStrategy implements Strategy {
    private Random random;
    private int prevHandValue = 0; //이전에 낸 손
    private int currentHandValue = 0; //지금 낼 손
    //[이전에낸손][지금낼손]
    private int[][] history = {
            {1, 1, 1}, // 이전 주먹-현 주먹 을 냈을 때 이긴 횟수, 이전 주먹-현 가위를 냈을 때 이긴 횟수, 이전 주먹-현 보를 냈을 때 이긴 횟수
            {1, 1, 1}, // 이전 가위-현 주먹 을 냈을 때 이긴 횟수 ...
            {1, 1, 1}  // 이전 보-현 주먹을 냈을 때 이긴 횟수...
    };

    public ProbStrategy(int seed) {
        this.random = new Random(seed);
    }

    private int getSum(int handValue) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum = history[handValue][i];
        }
        return sum;
    }

    @Override
    public Hand nextHand() {
        int bet = random.nextInt(getSum(currentHandValue)); //currentHandValue을 낸다 하였을때 발생한 모든 상황개수를 더해서 랜던값으로 사용
        int handValue = 0;
        if (bet < history[currentHandValue][0])
            handValue = 0;
        else if (bet < history[currentHandValue][0] + history[currentHandValue][1])
            handValue = 1;
        else
            handValue = 2;
        prevHandValue = currentHandValue;
        currentHandValue = handValue;
        return Hand.getHand(handValue);
    }


    @Override
    public void study(boolean win) {
        if (win)
            history[prevHandValue][currentHandValue]++; // 이겼을 경우엔 승률 + 1
        else {
            history[prevHandValue][(currentHandValue + 1) % 3]++; // 졌을경우엔 다른 배열 + 1
            history[prevHandValue][(currentHandValue + 2) % 3]++;
        }
    }
}
