package io.dandan.github.task.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import io.dandan.github.task.contant.ErrorCode;
import io.dandan.github.task.vo.ResultVo;

@ControllerAdvice
public class MyExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(MyExceptionHandler.class);
	
	@ExceptionHandler(Exception.class)
	public @ResponseBody ResultVo handleException(Exception ex) {
		log.error(ex.getMessage(), ex);
		ResultVo result = new ResultVo();
		result.setCode(ErrorCode.ERROR);
		result.setMsg(ex.getMessage());
		return result;
	}
}
