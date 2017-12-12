package com.dinghy.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dinghy.domain.user.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class FirstInterceptor implements HandlerInterceptor{
//    private static Logger logger=LoggerFactory.getLogger(FirstInterceptor.class);

    // 在DispatcherServlet完全处理完请求之后被调用，可用于清理资源
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        System.out.println("afterCompletion");
        
    }

    // 在业务处理器处理请求之前被调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            response.sendRedirect(request.getContextPath()+"111/231");
            return false;
        }
        System.out.println("postHandle123");
        return true;
    }

    // 在业务处理器处理请求完成之后，生成视图之前执行
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        System.out.println("postHandle");
        
    }

    
}
