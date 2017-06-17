package daq.manage.export;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import daq.manage.model.Collect;
import daq.manage.service.CollectService;
import daq.manage.utils.DateUntil;

public class ExportXls {
	
	public static void exportCollect(HttpServletResponse response,CollectService collectService,Map map) throws Exception
	{
		// 第一步，创建一个webbook，对应一个Excel文件  
        HSSFWorkbook wb = new HSSFWorkbook();  
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
        HSSFSheet sheet = wb.createSheet("学生表一");  
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
        HSSFRow row = sheet.createRow((int) 0);  
        // 第四步，创建单元格，并设置值表头 设置表头居中  
        HSSFCellStyle style = wb.createCellStyle();  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
  
        HSSFCell cell = row.createCell((short) 0);  
        cell.setCellValue("序号");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 1);  
        cell.setCellValue("类型");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 2);  
        cell.setCellValue("数值");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 3);  
        cell.setCellValue("传值时间");  
        cell.setCellStyle(style);  
  
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，  
        List list = collectService.getALLCollect(map);  
  
        for (int i = 0; i < list.size(); i++)  
        {  
            row = sheet.createRow((int) i + 1);  
            Collect collet = (Collect) list.get(i);  
            // 第四步，创建单元格，并设置值  
            row.createCell((short) 0).setCellValue(i+1);  
            row.createCell((short) 1).setCellValue(collet.getType());  
            row.createCell((short) 2).setCellValue(collet.getValue());  
            cell = row.createCell((short) 3);  
            cell.setCellValue(DateUntil.date2Str(collet.getCreated(), DateUntil.NORMAL_FORMAT));  
        }  
        // 第六步，将文件存到指定位置  
//        try  
//        {  
//            FileOutputStream fout = new FileOutputStream("E:/students.xls");  
//            wb.write(fout);  
//            fout.close();  
//        }  
//        catch (Exception e)  
//        {  
//            e.printStackTrace();  
//        }  
        Date date=new Date();
		String fileName=DateUntil.date2Str(date,"yyyy年MM月dd日")+".xls";
        OutputStream outp = response.getOutputStream();
		try {
			String mimeType = "application/vnd.ms-excel";
			response.setContentType(mimeType);
			String filedisplay = URLEncoder.encode(fileName, "UTF-8");
			response.addHeader("Content-disposition", "attachment;filename="
					+ filedisplay);
			wb.write(outp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (outp != null) {
				outp.close();
				outp = null;
				response.flushBuffer();
			}
		}
	}
	
}
