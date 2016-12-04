/**   
 * Filename:    LoadConfig.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2016-12-4 下午3:26:20   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.struts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 * 加载Struts的配置文件:缺省权限的类只能包内访问;私有构造防止反射;提供静态方法,允许不产生对象直接调用方法.
 * 
 * @author Yves He
 * 
 */
final class LoadConfig {

    private LoadConfig() {
    }

    // static {
    // configBean = new ConfigBean();
    // }

    public static void main(String[] args) {
        Map<String, ConfigBean> loadConfig = loadConfig();

    }

    public static Map<String, ConfigBean> loadConfig() {// 采用的是解析xml文件
        Map<String, ConfigBean> map = new HashMap<String, ConfigBean>();
        Document doc = null;
        InputStream in = null;
        try {
            in = new FileInputStream(new File("struts.xml"));
            SAXBuilder saxBuilder = new SAXBuilder();
            doc = saxBuilder.build(in);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        ConfigBean configBean = null;
        Element root = doc.getRootElement();
        Element fBeans = root.getChild("form-beans");
        Element actions = root.getChild("action-mappings");
        List<Element> fBean = fBeans.getChildren();
        List<Element> action = actions.getChildren();
        for (int i = 0; i < fBean.size(); i++) {
            configBean = new ConfigBean();
            configBean.setBeanType(fBean.get(i).getAttributeValue("type",
                    root.getNamespace()));
            configBean.setPath(action.get(i).getAttributeValue("path",
                    root.getNamespace()));
            configBean.setScope(action.get(i).getAttributeValue("scope",
                    root.getNamespace()));
            configBean.setActionType(action.get(i).getAttributeValue("type",
                    root.getNamespace()));
            HashMap<String, String> forwardMap = new HashMap<String, String>();

            List<Element> forward = action.get(i).getChildren();
            for (Element e : forward) {
                String name = e.getAttributeValue("name");
                if (name.equals("result")) {
                    forwardMap.put("result", e.getAttributeValue("path"));

                }
                if (name.equals("error")) {
                    forwardMap.put("error", e.getAttributeValue("path"));

                }
            }
            configBean.setForward(forwardMap);

            map.put(action.get(i)
                    .getAttributeValue("path", root.getNamespace()), configBean);
        }

        return map;
    }
}
