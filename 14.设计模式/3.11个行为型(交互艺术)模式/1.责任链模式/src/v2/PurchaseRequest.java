package v2;

public class PurchaseRequest {
    private int amount;
    private String purpose;//采购目的
    public PurchaseRequest(int amount, String purpose) {
        this.amount = amount;
        this.purpose = purpose;
    }
    public String getPurpose() {
        return purpose;
    }
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    public PurchaseRequest(int amount) {
        this.amount = amount;
    }
    public int getAmount() {
        return amount;
    }   
}
