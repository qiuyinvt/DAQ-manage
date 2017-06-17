package daq.manage.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;

import daq.manage.annotation.Constants;
import daq.manage.model.User;
import daq.manage.service.MembershipFacade;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 自定义的Shiro Filter,用于处理用户是否登录
 *
 * @author Tom Deng
 */
public class MembershipFilter extends PathMatchingFilter {
    @Resource
    private MembershipFacade membershipFacade;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue)
            throws Exception {
        String account = (String) SecurityUtils.getSubject().getPrincipal();
        User user=membershipFacade.getUser(account);
        request.setAttribute(Constants.CURRENT_USER, user);
        return true;
    }
}
