package com.design.designdemo.other._1delegate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: ${description}
 * @ClassName: ServletDelegate
 * @Author: yuexx
 * @Date: 2019/2/13 10:32
 * @Version: 1.0
 */
public class ServletDelegate {

    private List<Handler> handlerMapping = new ArrayList<Handler>();

    public void putHandlerMapping(Handler handler) {
        handlerMapping.add(handler);
    }

    public void doService(HttpServletRequest request, HttpServletResponse respose) {
        doDispatch(request, respose);
    }

    private void doDispatch(HttpServletRequest request, HttpServletResponse respose) {
        //  1.获取用户的请求的url
        //      如果按照J2EE的标准，每个url对应一个servlet
        String uri = request.getRequestURI();
        //  2.servlet拿到url后 要做权衡（zi）
        //   根据用户请求的UTL 去找到这个url对应的的一个java方法


        //3.通过拿到URL 去handlerMapping
        Handler hander = null;
        for (Handler h : handlerMapping){
            if(uri.equals(h.url)){
                hander = h;
                break;
            }
        }

        //4.讲具体的任务分发给method (通过反射去调动对应的方法)
        Object object = null;
        try {

            object =  hander.getMethod().invoke(hander.getController(), request.getParameter("mid"));
        } catch (Exception e){
            e.printStackTrace();
        }


        //5.获取method执行的结果，通过Response返回出去
        try {
            respose.getWriter().write(object.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    class Handler {
        private Object controller;
        private Method method;
        private String url;

        public Object getController() {
            return controller;
        }

        public void setController(Object controller) {
            this.controller = controller;
        }

        public Method getMethod() {
            return method;
        }

        public void setMethod(Method method) {
            this.method = method;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
