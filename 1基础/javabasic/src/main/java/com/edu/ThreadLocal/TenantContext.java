package com.edu.ThreadLocal;
/** 
 * @Description: 创建上下文对象 ，用于传递参数，从前端传递到控制层等；
 */
public class TenantContext {
    // 是一个全局类变量，ThreadLocal也一定是这么用的！并且要对对象初始化！
    private static final ThreadLocal<Tenant> threadLocal = new ThreadLocal<Tenant>(){
        
        // 此处一定要对租户初始化实例对象，否则会报空指针异常，默认返回的空。
        //ThreadLocal 的 get() 方法用于获取当前线程的这个 ThreadLocal 变量的副本值。如果当前线程还没有为这个 ThreadLocal 变量设置过值，那么 get() 方法默认会返回 null
        // 所以重写initValue方法，为其设置初值！
        @Override
        protected Tenant initialValue() {
            return new Tenant();
        }
    };

    // 定义获取线程中租户静态方法
    public static Tenant getTenant(){
        return threadLocal.get();
    }

    // 定义移除线程中的租户静态方法
    public static void removeValue(Object key){
        Tenant tenant = threadLocal.get();
        if(null != tenant){
            threadLocal.remove();
        }
    }
}

