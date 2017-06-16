package daq.manage.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.util.StringUtils;

public class PropertiesUtil {
	public static Properties getPro(String fileName){
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream(StringUtils.class.getResource("/").getPath()+fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pro;
	}
}
