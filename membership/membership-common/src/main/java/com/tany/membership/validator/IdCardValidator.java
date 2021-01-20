package com.tany.membership.validator;

import com.tany.membership.annotation.CheckIDCard;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;


public class IdCardValidator implements ConstraintValidator<CheckIDCard, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// 身份证正则表达式(18位)
		String isIdCard2 = "^[1-9]\\d{5}(19\\d{2}|[2-9]\\d{3})((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])(\\d{4}|\\d{3}X)$(?i)";// i;
		String stard = "10X98765432"; // 最后一位身份证的号码
		Integer[] first = new Integer[] { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 }; // 1-17系数
		Integer sum = 0;

		if (!value.matches(isIdCard2)) {
			return false;
		}
		String year = value.substring(6, 10);
		String month = value.substring(10, 12);
		String day = value.substring(12, 14);
		String birthday = value.substring(6, 14);

		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		if (!birthday.equals(dateToString(calendar))) {// 校验日期是否合法
			return false;
		}
		String[] strings = value.split("");
		for (int i = 0; i < strings.length - 1; i++) {
			sum += Integer.parseInt(strings[i]) * first[i];
		}
		// for (int i = 0; i < value.length() - 1; i++) {
		// sum += Integer.valueOf(Character.toString(value.charAt(i))) *
		// first[i];
		// }
		Integer result = sum % 11;

		String last = Character.toString(stard.charAt(result)); // 计算出来的最后一位身份证号码
		//strings[strings.length - 1].toUpperCase()
		//System.out.println( new Character('X').toString().equalsIgnoreCase("x"));
		//if (Character.toUpperCase(value.charAt(value.length() - 1)) == last) {
		if (last.equalsIgnoreCase(strings[strings.length - 1])) {
			return true;
		} else {
			return false;
		}

	}

	private String dateToString(Calendar date) {
		if (date instanceof Calendar) {
			String year = String.valueOf(date.get(Calendar.YEAR));
			String month = String.valueOf(date.get(Calendar.MONTH));
			month = StringUtils.leftPad(month, 2, '0');

			String day = String.valueOf(date.get(Calendar.DATE));
			day = StringUtils.leftPad(day, 2, '0');
			return year + month + day;
		}
		return "";
	}

}
