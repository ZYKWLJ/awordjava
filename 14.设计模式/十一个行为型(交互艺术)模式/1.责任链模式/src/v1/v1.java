package v1;
// import javax.swing.plaf.ComboBoxUI;

public class v1 {
    public void handlePurchase(PurchaseRequest request) {
        if (request.getAmount() < 50000) {
            handleByDirector(request);
        } else if (request.getAmount() < 100000) {
            handleByVicePresident(request);
        } else if (request.getAmount() < 500000) {
            handleByPresident(request);
        } else {
            handleByCongress(request);
        }
    }
    
	//主任审批采购单
	public void handleByDirector(PurchaseRequest request) {
        System.out.println("金额为 "+request.getAmount()+"在[0,50000] $, 让我主任审批就好了");
	}
	
	//副董事长审批采购单
	public void handleByVicePresident(PurchaseRequest request) {
        System.out.println("金额为 "+request.getAmount()+",在[50000,100000) $之间, 让我副董事长来审批");

	}
	
	//董事长审批采购单
	public void handleByPresident(PurchaseRequest request) {
        System.out.println("金额为 "+request.getAmount()+"在[100000,500000) $之间, 让我副董事长来审批");
	}
	
	//董事会审批采购单
	public void handleByCongress(PurchaseRequest request) {
        System.out.println("金额为 "+request.getAmount()+"在[500000,indifine) $之间, 我们董事会开会审批");
	}
    public static void main(String[] args) {
        v1 v1 = new v1();
        v1.handlePurchase(new PurchaseRequest(800000));
    }
}
