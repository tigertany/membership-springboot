package com.tany.membership.config;

import com.tany.membership.common.DateUtil;

import java.text.FieldPosition;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

 
/** 
 * Description: 智能日期转换 
 * Author:  
 */  
public class SmartDateFormat extends SimpleDateFormat {  
    /**
     * 
     */
    private static final long serialVersionUID = 6517753776479429611L;
 
    @Override  
    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition pos) {  
        return new StringBuffer(DateUtil.smartFormat(date));
    }  
  
    @Override  
    public Date parse(String text) throws ParseException {  
        return DateUtil.smartFormat(text);  
    }  
}
