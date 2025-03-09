package v2;

public class ConcreteHandlerVicePresident extends Handler {

     public ConcreteHandlerVicePresident(Handler successor, String name) {
          super(successor, name);
     }

     public ConcreteHandlerVicePresident(String name) {
          super(name);
     }

     public ConcreteHandlerVicePresident(Handler successor) {
          super(successor);
     }

     @Override
     public void handlerRequest(PurchaseRequest request) {
          if (request.getAmount() >= 50000 && request.getAmount() < 100000) {
               System.out.println(this.getName() + "处理此次订单,金额为" + request.getAmount() + ",目的为" + request.getPurpose());
          } else {
               this.successor.handlerRequest(request);
          }
     }
}
