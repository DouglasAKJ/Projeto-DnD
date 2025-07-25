package com.pougos.teste_pougos.helper;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

@Component
public class NullCopyProperties extends BeanUtilsBean {
    @Override
    public void copyProperty(Object bean, String name, Object value) throws IllegalAccessException, InvocationTargetException {
        if(value == null)
            return;
        super.copyProperty(bean, name, value);
    }
}
