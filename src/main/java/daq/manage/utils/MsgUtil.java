package daq.manage.utils;

/**
 * 短信发送工具包
 * @author linj
 *
 */
public class MsgUtil {
	//短信api地址    阿凡达短信接口
	private static String MSG_API_URL= "http://v1.avatardata.cn/Sms/Send";
	
	private static String MSG_KEY = PropertiesUtil.getPro("application.properties").getProperty("MSG_KEY") ;
	
	private static String MSG_TEMPLATEID = PropertiesUtil.getPro("application.properties").getProperty("MSG_TEMPLATEID");
	
	public static void sendMsg(String params){
		try {
			HttpUtils.get(MSG_API_URL, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 发送模板发送均值和峰值提醒
	 * @param mobile
	 * @param param  均值、峰值
	 */
	public static void sendMsg(String mobile,String param){
		try {
			HttpUtils.get(MSG_API_URL, "key="+MSG_KEY+"&mobile="+mobile+"&templateId="+MSG_TEMPLATEID+"&param="+param);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void sendMsg(String mobile,String templateId,String param){
		try {
			HttpUtils.get(MSG_API_URL, "key="+MSG_KEY+"&mobile="+mobile+"&templateId="+templateId+"&param="+param);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
