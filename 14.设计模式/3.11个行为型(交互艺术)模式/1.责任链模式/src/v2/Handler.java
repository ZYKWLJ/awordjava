package v2;

public abstract class Handler {
    protected Handler successor;
    private String name;

    public Handler(Handler successor) {
        this.successor = successor;
    }

    public Handler(String name) {
        this.name = name;
    }

    public Handler(Handler successor, String name) {
        this.successor = successor;
        this.name = name;
    }

    public abstract void handlerRequest(PurchaseRequest request);

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
