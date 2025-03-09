package v2;

public class ConcreteHandlerDirector extends Handler {

     public ConcreteHandlerDirector(Handler successor, String name) {
          super(successor, name);
     }
     public ConcreteHandlerDirector(String name) {
          super(name);
     }

     public ConcreteHandlerDirector(Handler successor) {
          super(successor);
     }

     @Override
     public void handlerRequest(PurchaseRequest request) {
          if (request.getAmount() < 50000) {
               System.out.println(this.getName() + "处理此次订单,金额为" + request.getAmount() + ",目的为" + request.getPurpose());
          } else {
               this.successor.handlerRequest(request);
          }
     }
}
