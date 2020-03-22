package com.jiaotd.getaway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;

/**
 * 描述：TODO
 *
 * @author jiaotengda
 * Date:     2020/3/22
 */
public class UserResolveFilter extends ZuulFilter {
    /**
     * 请求拦截类型
     *
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 20;
    }

    /**
     * 哪些请求要被拦截
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        // 端口号之后的请求地址
        return request.getRequestURI().startsWith("/core-server");
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.getZuulRequestHeaders().remove("user");
        HttpServletRequest request = ctx.getRequest();
        String token = request.getHeader("token");
        if (!StringUtils.isBlank(token)) {
            ctx.addZuulRequestHeader("user", "{\"id\":1,\"name\":\"jiaotd\",\"age\":18}");
        }
        return null;
    }
}
