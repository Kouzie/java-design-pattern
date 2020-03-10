package strategy;

public class Hand {
    public static final int HANDVALUE_GOO = 0; //주먹
    public static final int HANDVALUE_CHO = 1; //가위
    public static final int HANDVALUE_PPA = 2; //보
    public static final Hand[] hand = {
            new Hand(HANDVALUE_GOO),
            new Hand(HANDVALUE_CHO),
            new Hand(HANDVALUE_PPA)
    };
    public static final String[] name = {"주먹", "가위", "보"};

    private int handValue;

    public Hand(int handValue) {
        this.handValue = handValue;
    }

    public static Hand getHand(int handValue) {
        return hand[handValue];
    }

    private int fight(Hand hand) {
        if (this == hand)
            return 0; //무승부
        else if ((this.handValue + 1) % 3 == hand.handValue) //상대 hand가 나보다 한칸 앞에 있을 경우
            return 1; //승
        else
            return -1; //패
    }

    public boolean isStrongerThan(Hand hand) {
        return fight(hand) == 1;
    }

    public boolean isWeakerThan(Hand hand) {
        return fight(hand) == -1;
    }

    @Override
    public String toString() {
        return name[handValue];
    }
}
