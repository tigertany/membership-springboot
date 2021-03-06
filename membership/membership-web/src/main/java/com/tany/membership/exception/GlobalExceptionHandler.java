package com.tany.membership.exception;

import com.tany.membership.common.CommonUtils;
import com.tany.membership.common.JSONResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) { BindingResult
	 * bindingResult = binder.getBindingResult();
	 * System.out.println("@InitBinder"); }
	 */

	/*@ModelAttribute(Constant.USER_ID)
	public String getUserId(HttpServletRequest request) {
		String token = request.getHeader(Constant.TOKEN_ID);
		if (StringUtils.isNotBlank(token)) {
			// model.addAttribute(Constant.USER_ID,
			// JWTUtil.getClaim(token).get(Constant.USER_ID).asString());
			Map<String, Claim> claim = JWTUtil.getClaim(token);
			if (claim != null) {
				return claim.get(Constant.USER_ID).asString();
			}
		}
		return "";
	}*/

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public JSONResult MethodArgumentNotValidException(MethodArgumentNotValidException ex) {

		// MethodArgumentNotValidException c = (MethodArgumentNotValidException)
		// BindingResult bindingResult = ex.getBindingResult();

		List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
		ObjectError objectError = allErrors.get(0);
		FieldError fieldError = (FieldError) objectError;

		CommonUtils.printException(logger, ex);
		

		return JSONResult.fail(fieldError.getDefaultMessage());

	}

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public JSONResult globalException(RuntimeException ex) {
		CommonUtils.printException(logger, ex);
		return JSONResult.fail(ex.getMessage() == null ? ex.toString() : ex.getMessage(), ex.getStackTrace()[0]);
	}

	// @ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public JSONResult globalException( Exception ex) {
		// JSONResult jsonResult = new JSONResult();
		// if (isAjax(request)) {
		// jsonResult.setStatus(response.getStatus());
		// jsonResult.setMsg(ex.getMessage() == null ? ex.toString() :
		// ex.getMessage());
		// jsonResult.setData(ex.getStackTrace()[0]);
		// }

		CommonUtils.printException(logger, ex);
		return JSONResult.fail(ex.getMessage() == null ? ex.toString() : ex.getMessage(), ex.getStackTrace()[0]);
	}

	public static boolean isAjax(HttpServletRequest httpRequest) {
		return (httpRequest.getHeader("X-Requested-With") != null
				&& "XMLHttpRequest".equals(httpRequest.getHeader("X-Requested-With")));
	}
}
