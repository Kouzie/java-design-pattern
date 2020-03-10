package chainOfResponsibility;

public abstract class Support {
    private String name;
    private Support next;

    public Support(String name) {
        this.name = name;
    }

    public final void support(Trouble trouble) { //최종 구현 메서드
        if (resolve(trouble)) {
            done(trouble);
        } else if (next != null) {
            next.support(trouble);
        } else {
            fail(trouble);
        }
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    protected abstract boolean resolve(Trouble trouble);

    protected void done(Trouble trouble) {
        System.out.println(trouble + "is resolved by " + this + ".");
    }

    protected void fail(Trouble trouble) {
        System.out.println(trouble + "can not be resolved");
    }

    @Override
    public String toString() {
        return "Support{" +
                "name='" + name + '\'' +
                '}';
    }

}
