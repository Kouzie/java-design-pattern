package strategy;

public class Player {
    private String name;
    private Strategy strategy;
    private Integer wincount;
    private Integer losecount;
    private Integer gamecount;
    private Integer evencount;

    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
        this.wincount = 0;
        this.losecount = 0;
        this.gamecount = 0;
        this.evencount = 0;
    }

    public Hand nextHand() {
        return strategy.nextHand();
    }
    public void win() {
        strategy.study(true);
        wincount++;
        gamecount++;
    }
    public void lose() {
        strategy.study(false);
        losecount++;
        gamecount++;
    }
    public void even() {
        gamecount++;
        evencount++;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", strategy=" + strategy +
                ", wincount=" + wincount +
                ", losecount=" + losecount +
                ", gamecount=" + gamecount +
                ", evencount=" + evencount +
                '}';
    }
}
