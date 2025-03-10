package v2;

public class ConcreteHandlerCongress extends Handler {

     public ConcreteHandlerCongress(Handler successor, String name) {
          super(successor, name);
     }

     public ConcreteHandlerCongress(String name) {
          super(name);
     }

     public ConcreteHandlerCongress(Handler successor) {
          super(successor);
     }

     @Override
     public void handlerRequest(PurchaseRequest request) {
          if (request.getAmount() <= 10000000) {
               System.out.println(this.getName() + "处理此次订单,金额为" + request.getAmount() + ",目的为" + request.getPurpose());

          } else {
               System.out.println("款项"+request.getAmount()+"过于巨大,拒绝处理!");
          }
     }
}
