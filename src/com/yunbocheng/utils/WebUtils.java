package com.yunbocheng.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {

    public static <T>  T copyParamToBean(Map value, T bean){
        try {
            BeanUtils.populate(bean,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int change(String strInt, int defaultValue){
        if (strInt==null || "".equals(strInt) || strInt.equals("1")){
            return defaultValue;
        }else {
            return Integer.parseInt(strInt);
        }
    }
}
