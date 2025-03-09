package v2;
public class Client {
    public static void main(String[] args) {
        PurchaseRequest purchaseRequest1 = new PurchaseRequest(40000,"给公司买10台笔记本");
        PurchaseRequest purchaseRequest2 = new PurchaseRequest(5000000,"给公司购置地皮建新楼");
        PurchaseRequest purchaseRequest3 = new PurchaseRequest(70000,"公司培训新职员教培支出");
        // 审批人
        Handler director=new ConcreteHandlerDirector("主任部张三");
        Handler vicePresident=new ConcreteHandlerVicePresident("副董事李四");
        Handler President=new ConcreteHandlerPresident("董事长王五");
        Handler congress=new ConcreteHandlerCongress("董事会全体董事");
        director.setSuccessor(vicePresident);
        vicePresident.setSuccessor(President);
        President.setSuccessor(congress);

        director.handlerRequest(purchaseRequest1);
        director.handlerRequest(purchaseRequest2);
        director.handlerRequest(purchaseRequest3);
    }
}