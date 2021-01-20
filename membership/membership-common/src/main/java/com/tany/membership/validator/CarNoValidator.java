package com.tany.membership.validator;

import com.tany.membership.annotation.CheckCarNo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class CarNoValidator implements ConstraintValidator<CheckCarNo, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		String regex = "^(([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领][A-Z](([0-9]{5}[DF])|([DF]([A-HJ-NP-Z0-9])[0-9]{4})))|([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领][A-Z][A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳使领]))$";
		
		return Pattern.matches(regex, value);//value.matches(regex);
	}

}
