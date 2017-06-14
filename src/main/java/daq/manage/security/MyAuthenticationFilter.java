package daq.manage.security;

/**
 * 
 * @author: ZengYunHu Email:zengyunhu@chelian.me
 * @file: ValidateCodeUsernamePasswordAuthenticationFilter.java
 * @version: v1.0
 * @create time: 2013-7-8
 * @Modification time: 2013-7-8
 * @description: 说明
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.TextEscapeUtils;
import org.springframework.util.StringUtils;

/**
* <li>带验证码校验功能的用户名、密码认证过滤器</li>
* <p>
* 支持不输入验证码；支持验证码忽略大小写。
* 
* @author SteveYang
* 
*/
public class MyAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

   private boolean postOnly = true;
   private boolean allowEmptyValidateCode = false;
   private String sessionvalidateCodeField = DEFAULT_SESSION_VALIDATE_CODE_FIELD;
   private String validateCodeParameter = DEFAULT_VALIDATE_CODE_PARAMETER;
   public static final String DEFAULT_SESSION_VALIDATE_CODE_FIELD = "authCode";
   public static final String DEFAULT_VALIDATE_CODE_PARAMETER = "validateCode";

   @Override
   public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
       if (postOnly && !request.getMethod().equals("POST")) {
           throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
       }

       String username = obtainUsername(request);
   
       String password = obtainPassword(request);
       
       Md5PasswordEncoder md5=new Md5PasswordEncoder();

       if (username == null) {
           username = "";
       }

       if (password == null) {
           password = "";
       }
       username = username.trim();
       
       password=md5.encodePassword(password, null);
	   UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
       // Place the last username attempted into HttpSession for views
       HttpSession session = request.getSession(false);

       if (session != null || getAllowSessionCreation()) {
           request.getSession().setAttribute(SPRING_SECURITY_FORM_PASSWORD_KEY,TextEscapeUtils.escapeEntities(username));
       }

       // Allow subclasses to set the "details" property
       setDetails(request, authRequest);
       // check validate code
      /*  if (!isAllowEmptyValidateCode())
            checkValidateCode(request);*/
       return this.getAuthenticationManager().authenticate(authRequest);
   }

   /**
    * 
    * <li>比较session中的验证码和用户输入的验证码是否相等</li>
    * 
    */
   protected void checkValidateCode(HttpServletRequest request) {
       String sessionValidateCode = obtainSessionValidateCode(request);
       String validateCodeParameter = obtainValidateCodeParameter(request);
       if (StringUtils.isEmpty(validateCodeParameter) || !sessionValidateCode.equalsIgnoreCase(validateCodeParameter)) {
           throw new AuthenticationServiceException("authCode");
       }
   }

   private String obtainValidateCodeParameter(HttpServletRequest request) {
       return request.getParameter(validateCodeParameter);
   }

   protected String obtainSessionValidateCode(HttpServletRequest request) {
       Object obj = request.getSession().getAttribute(sessionvalidateCodeField);
       return null == obj ? "" : obj.toString();
   }

   public boolean isPostOnly() {
       return postOnly;
   }

   @Override
   public void setPostOnly(boolean postOnly) {
       this.postOnly = postOnly;
   }

   public String getValidateCodeName() {
       return sessionvalidateCodeField;
   }

   public void setValidateCodeName(String validateCodeName) {
       this.sessionvalidateCodeField = validateCodeName;
   }

   public boolean isAllowEmptyValidateCode() {
       return allowEmptyValidateCode;
   }

   public void setAllowEmptyValidateCode(boolean allowEmptyValidateCode) {
       this.allowEmptyValidateCode = allowEmptyValidateCode;
   }

}