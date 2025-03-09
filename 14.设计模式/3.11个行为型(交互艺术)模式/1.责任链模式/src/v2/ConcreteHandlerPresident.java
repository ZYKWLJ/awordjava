package v2;

public class ConcreteHandlerPresident extends Handler {

     public ConcreteHandlerPresident(Handler successor, String name) {
          super(successor, name);
     }

     public ConcreteHandlerPresident(String name) {
          super(name);
     }

     public ConcreteHandlerPresident(Handler successor) {
          super(successor);
     }

     @Override
     public void handlerRequest(PurchaseRequest request) {
          if (request.getAmount() >= 100000 && request.getAmount() < 500000) {
               System.out.println(this.getName() + "处理此次订单,金额为" + request.getAmount() + ",目的为" + request.getPurpose());
          } else {
               this.successor.handlerRequest(request);
          }
     }
}
