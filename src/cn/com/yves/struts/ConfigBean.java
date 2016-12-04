/**   
 * Filename:    ServletConfig.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2016-11-27 下午6:32:26   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.struts;

import java.util.Map;

public class ConfigBean {
    private String path;// 访问的路径
    private String scope;// 请求作用域;
    private String actionType;// 自己定义的action.java
    private String BeanType;// javaBean

    private Map<String, String> forward;// 跳转

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getBeanType() {
        return BeanType;
    }

    public void setBeanType(String beanType) {
        BeanType = beanType;
    }

    public Map<String, String> getForward() {
        return forward;
    }

    public void setForward(Map<String, String> forward) {
        this.forward = forward;
    }

}
