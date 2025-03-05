// package com.demo.spring.test.ThreadLocalUser;
package com.edu.ThreadLocal;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
// 定义租户对象！
@Data
public class Tenant {

    private String tenantId;

    private String tenantName;

    @Override
    public String toString () {
        return JSONObject.toJSONString(this);
    }
}
