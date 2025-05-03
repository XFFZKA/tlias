package com.itheima.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override   //目标资源运行前运行，返回值true放行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        System.out.println(2);

    }

    @Override    //目标资源运行后运行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURL().toString();
        log.info("url {}",url);

        if (url.contains("login")) {

            return true;
        }

        String token = request.getHeader("token");
        log.info("token {}",token);
        if (!StringUtils.hasLength(token)) {
            log.info("token 为空");
            Result result = Result.error("NOT_LOGIN");
            String jsonString = JSONObject.toJSONString(result);
            response.getWriter().write(jsonString);
            return false;

        }

        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败，返回错误信息");
            Result result = Result.error("NOT_LOGIN");
            String jsonString = JSONObject.toJSONString(result);
            response.getWriter().write(jsonString);
            return false;
        }

        log.info("令牌合法，放行");
        return true;
    }

    @Override  //视图渲染完运行，最好运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        System.out.println(3);
    }
}
