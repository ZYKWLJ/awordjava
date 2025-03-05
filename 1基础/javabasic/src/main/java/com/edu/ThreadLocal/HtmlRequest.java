package com.edu.ThreadLocal;

/**
 * @Description: 模拟前端发送请求，进行参数的预封装；
 */
public class HtmlRequest implements Runnable {

    private TenantIdAction tenantIdAction = new TenantIdAction();//模拟前台请求，这里获取设置对象

    @Override
    public void run() {
        // 上下文获取租户对象，此时租户对象为初始化对象，属性均为null；
        Tenant tenant = TenantContext.getTenant();

        // 模拟前端准备发送请求：开始设置租户的id
        tenantIdAction.setTenantId();
        tenantIdAction.setTenantName();
        System.out.println("tenantId:" + tenant.getTenantId() + "  --- " + tenant.getTenantName());

        // 每个线程设置完属性以后，要清除掉上下文中的对象，使得Tenant实例重新回到初始化状态；
        // 可以保证每个线程取到的上下文里的初始对象都是一样的；
        TenantContext.removeValue(tenant);

        // 因为上一行的已经清空了上下文中的租户对象，所以下面这行代码打印的租户id和name应该都是null；需要看执行效果的同学放开下面代码注释即可。
        // System.out.println("remove----tenantId : "+
        // TenantContext.getTenant().getTenantId() +"name : "+
        // TenantContext.getTenant().getTenantName());
    }
}
