package factory;

public class IDCard extends Product {

    private String owner;

    public IDCard(String owner) {
        System.out.println("Create " + owner + "'s IDCard");
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public void use() {
        System.out.println("Use " + owner + "'s IDCard");

    }
}
