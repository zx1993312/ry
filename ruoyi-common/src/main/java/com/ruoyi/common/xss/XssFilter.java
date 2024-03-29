package com.ruoyi.common.xss;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;

import com.ruoyi.common.utils.StringUtils;

/**
 * 防止XSS攻击的过滤器
 * 
 * @author ruoyi
 */
public class XssFilter implements Filter
{
    /**
     * 排除链接
     */
    public List<String> excludes = new ArrayList<>();

    /**
     * xss过滤开关
     */
    public boolean enabled = false;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        String tempExcludes = filterConfig.getInitParameter("excludes");
        String tempEnabled = filterConfig.getInitParameter("enabled");
        if (StringUtils.isNotEmpty(tempExcludes))
        {
            String[] url = tempExcludes.split(",");
            for (int i = 0; url != null && i < url.length; i++)
            {
                excludes.add(url[i]);
            }
        }
        if (StringUtils.isNotEmpty(tempEnabled))
        {
            enabled = Boolean.valueOf(tempEnabled);
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
      /*//跨域请求，*代表允许全部类型
        resp.setHeader("Access-Control-Allow-Origin", "*");
      		//允许请求方式
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
      		//用来指定本次预检请求的有效期，单位为秒，在此期间不用发出另一条预检请求
        resp.setHeader("Access-Control-Max-Age", "3600");
      		//请求包含的字段内容，如有多个可用哪个逗号分隔如下
        resp.setHeader("Access-Control-Allow-Headers", "content-type,x-requested-with,Authorization, x-ui-request,lang");
      		//访问控制允许凭据，true为允许
        resp.setHeader("Access-Control-Allow-Credentials", "true");
      		// 浏览器是会先发一次options请求，如果请求通过，则继续发送正式的post请求
              // 配置options的请求返回
      		if (req.getMethod().equals("OPTIONS")) {
      			resp.setStatus(200);
      			resp.getWriter().write("OPTIONS returns OK");
      			return;
      		}
      		// 传递业务请求处理
      		chain.doFilter(request, response);*/
        if (handleExcludeURL(req, resp))
        {
            chain.doFilter(request, response);
            return;
        }
        XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper((HttpServletRequest) request);
        chain.doFilter(xssRequest, response);
    }

    private boolean handleExcludeURL(HttpServletRequest request, HttpServletResponse response)
    {
        if (!enabled)
        {
            return true;
        }
        if (excludes == null || excludes.isEmpty())
        {
            return false;
        }
        String url = request.getServletPath();
        for (String pattern : excludes)
        {
            Pattern p = Pattern.compile("^" + pattern);
            Matcher m = p.matcher(url);
            if (m.find())
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy()
    {

    }
}