package com.sixdog.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class CSVUtil {

	public static char separator = ',';
	public static String filePath = "src/main/resources/sayInfo.csv";
    public static void main(String[] args) throws Exception {
        //添加标题
        List<String[]> dataList = new ArrayList<String[]>();
//        for (int i = 0; i < 10; i++) {
//        	dataList.add(new String[]{"100" + i, "张三" + i, "8" + i});
//        }
//        createCSV(dataList);

        // 读取CSV文件
        //dataList = readCSV();
        dataList = readCsv();
    }

    /**
     * 读取CSV文件
     */
    public static List<String[]> readCSV() throws Exception {
        CsvReader reader = null;
        List<String[]> dataList = new ArrayList<String[]>();
        try {
        	File file=new File(filePath);
        	if(file.exists()) {
        		//如果生产文件乱码，windows下用gbk，linux用UTF-8
        		reader = new CsvReader(filePath, separator, Charset.forName("UTF-8"));
        		// 逐条读取记录，直至读完
        		while (reader.readRecord()) {
        			String[] sayInfo = new String[3];
        			//System.out.println(reader.get(0));
        			sayInfo[0] = reader.get(0);
        			sayInfo[1] = reader.get(1);
        			sayInfo[2] = reader.get(2);
        			dataList.add(sayInfo);
        		}
        	}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                reader.close();
            }
        }

        return dataList;
    }

    /**
     * 生成CSV文件
     * @param sayInfoList:数据集
     */
    public static boolean createCSV(List<String[]> dataList) throws Exception {
        boolean isSuccess = false;
        CsvWriter writer = null;
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath, true);
            //如果生产文件乱码，windows下用gbk，linux用UTF-8
            writer = new CsvWriter(out, separator, Charset.forName("UTF-8"));
            for(String[] item : dataList) {
            	writer.writeRecord(item);
            }
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != writer) {
                writer.close();
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return isSuccess;
    }
    
    /**
     * 生成CSV文件
     * 将排完序后的数据再写入文件 
     * @param sayInfoList:数据集
     */
    public static boolean createCsv(List<String[]> dataList) {
    	boolean isSuccess = false;
    	//尝试使用try-with-resource语法
    	try(FileWriter fw = new FileWriter(filePath)){
    		dataList.forEach(item->{
				try {
					fw.write(item[0]+","+item[1]+","+item[2]+"\n");
					fw.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
    		isSuccess = true;
    	} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return isSuccess;
    }
    
	public static List<String[]> readCsv() {
		List<String[]> dataList = new ArrayList<String[]>();
		String record;
		try (BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
			while ((record = file.readLine()) != null) {
				String fields[] = record.split(",",-1);
				dataList.add(fields);
			}
			// 关闭文件
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataList;

	}
}
