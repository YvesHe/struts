/**   
 * Filename:    UserBean.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2016-12-4 下午8:19:48   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.bean;

import cn.com.yves.struts.FormBean;

public class UserBean extends FormBean {
    private String name;
    private int age;
    private char sex;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
