package io.renren.utils;

import com.alibaba.fastjson2.JSON;
import com.amoy.common.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
/**
 * 异常处理器
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月27日 下午10:16:19
 */
//@Component
public class QExceptionHandler implements HandlerExceptionResolver {
	private Logger logger = LoggerFactory.getLogger(getClass());


	@Override
	public ModelAndView resolveException(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Object handler, Exception ex) {
		Result r = new Result();
		try {

			response.setContentType("application/json;charset=utf-8");
			response.setCharacterEncoding("utf-8");

			if (ex instanceof QException) {
				r.put("code", ((QException) ex).getCode());
				r.put("msg", ((QException) ex).getMessage());
			}else if(ex instanceof DuplicateKeyException){
				r = Result.error("数据库中已存在该记录");
			}else{
				r = Result.error();
			}

			//记录异常日志
			logger.error(ex.getMessage(), ex);

			String json = JSON.toJSONString(r);
			response.getWriter().print(json);
		} catch (Exception e) {
			logger.error("QExceptionHandler 异常处理失败", e);
		}
		return new ModelAndView();
	}
}
