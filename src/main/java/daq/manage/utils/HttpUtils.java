package daq.manage.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

import daq.manage.enums.CollectTypeEnum;

public class HttpUtils {
	public static void main(String[] args) throws Exception {
		String url = "http://v1.avatardata.cn/Sms/Send";
		JSONObject json = new JSONObject();
		json.put("id", "qiuyinvt");
		json.put("pwd", "120914jiao");
		json.put("to", "18750753932");
		json.put("content", URLEncoder.encode("【数据监测】半小时内均值为60，峰值为80.", "gb2312"));
		// System.out.println(new
		// String("【数据监测】半小时内均值为60，峰值为80.".getBytes("UTF-8"),"gb2312"));
		// System.out.println(json.toJSONString());
		//System.out.println(get(url, "key=f31b147fe0744b6eb7e6ed3467a27325&mobile=18750753932&templateId=b7feb3626137423fae65e29178e54af7&param=20,30"));
	}

	public static String get(String path, String params) throws Exception {
		BufferedReader in = null;
		PrintWriter out = null;
		HttpURLConnection httpConn = null;
		try {
			URL url = new URL(path);
			httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setRequestMethod("POST");
			httpConn.setDoInput(true);
			httpConn.setDoOutput(true);

			out = new PrintWriter(httpConn.getOutputStream());
			out.println(params);
			out.flush();

			if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				StringBuffer content = new StringBuffer();
				String tempStr = "";
				in = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
				while ((tempStr = in.readLine()) != null) {
					content.append(tempStr);
				}
				return content.toString();
			} else {
				throw new Exception("请求出现了问题!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			in.close();
			out.close();
			httpConn.disconnect();
		}
		return null;
	}

	public static String post1(String uri, String param) throws Exception {
		URL url = new URL(uri);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		http.setDoOutput(true);
		http.setDoInput(true);
		http.setRequestMethod("POST");
		http.connect();
		OutputStreamWriter out = new OutputStreamWriter(http.getOutputStream(), "gb2312");
		out.append(param);
		out.flush();
		out.close();
		BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
		String line;
		StringBuffer buffer = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
		}
		reader.close();
		http.disconnect();
		return buffer.toString();
	}

	public static String post2(String url, String param) {
		String result = null;
		try {
			HttpPost req = new HttpPost(url);
			StringEntity se = new StringEntity(param, "gb2312");
			se.setContentEncoding("gb2312");
			se.setContentType("application/json;charset=gb2312");
			req.setEntity(se);
			HttpClient httpClient = new DefaultHttpClient();
			HttpResponse resp = httpClient.execute(req);
			if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result = EntityUtils.toString(resp.getEntity(), "utf-8");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String post(String url, String param) {

		String result = null;
		try {
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			list.add(new BasicNameValuePair("data", new String(param.getBytes("gbk"), "gb2312")));
			HttpParams params = new BasicHttpParams();
			HttpClient client = new DefaultHttpClient(params);
			HttpPost post = new HttpPost(url);
			post.setEntity(new UrlEncodedFormEntity(list));
			HttpResponse resp = client.execute(post);
			if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result = EntityUtils.toString(resp.getEntity(), "utf-8");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
