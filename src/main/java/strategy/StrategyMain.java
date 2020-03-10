package strategy;

/*
 * Strategy: 전략
 * 알고리즘(비지니스) 구현부를 모두 전략적으로 교체할수 있도록 하는 패턴
 * 가위바위보 전략을 예제로 Strategy 를 구현해보자. 어떻게 해야 이길지 낼 손을 결정하는 알고리즘을 Strategy 패턴을 통해 구성
 *
 * Strategy - 다음에 내는 손을 정하기 위한, 전략을 위한 추상메서드, nextHand를 통해 다음 낼 손을 결정, 이겼을경우 study에 true, 졌을땐 false를 전달,
 * WinningStrategy - 가장 단순한 전략, 질때까지 계속 똑같은 손을 낸다. 지고나면 랜덤으로 하나 선택
 * ProbStrategy - 과거 승수에 따라 낼 손을 선택, 이전에 해당 손을 냈을때 다음에 어떤손을 내서 이겼는지를 기록, 이전에 주먹을 냈다면 다음에 주먹,가위,보 중 이긴횟수가 많은 손을 낸다.
 *
 * 구성요소:
 * 1. Strategy(전략) - 전략을 위한 API 정의, nextHand, study 추상 메서드를 갖고 있는 Strategy 가 해당 역할
 * 2. ConcreteStrategy(구체적 전략) - 해당 전약을 구체적으로 정의한 클래스, ProbStrategy, WinningStrategy 가 해당 역할,
 * 3. Context(문맥) - Strategy 를 이용하는 역할, 전략클래스의 API를 호출, Player가 해당 역할을 한다.
 * */
public class StrategyMain {
    public static void main(String[] args) {

        int seed1 = Integer.parseInt("123415");
        int seed2 = Integer.parseInt("567281");

        Player player1 = new Player("둘리", new WinningStrategy(seed1));
        Player player2 = new Player("또치", new ProbStrategy(seed2));

        for (int i = 0; i < 10000; i++) {
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();

            if (nextHand1.isStrongerThan(nextHand2)) {
                System.out.println("Winner: " + player1);
                player1.win();
                player2.lose();
            } else if (nextHand2.isStrongerThan(nextHand1)) {
                System.out.println("Winner: " + player2);
                player2.win();
                player1.lose();
             } else {
                System.out.println("Even...");
                player2.even();
                player1.even();
            }
        }
        System.out.println("Total Result:");
        System.out.println(player1.toString());
        System.out.println(player2.toString());
    }
}
