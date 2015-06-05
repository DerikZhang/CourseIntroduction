package org.tdgo.CourseIntroduction.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Timer;

import org.tdgo.CourseIntroduction.common.Config;

import javassist.expr.NewArray;

public class CommonFunction {
	/*
	 * @description:��ȡ�����ĸ������
	 */
	static public String getCommentCode(){
        String val = "";  
        Random random = new Random();  
		int length = Config.COMMENT_CODE_LENGTH;
		
		for(int i = 0; i < length; i++) {  
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";  
            //�����ĸ��������  
            if( "char".equalsIgnoreCase(charOrNum) ) {  
                //����Ǵ�д��ĸ����Сд��ĸ  
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;  
                val += (char)(random.nextInt(26) + temp);  
            } else if( "num".equalsIgnoreCase(charOrNum) ) {  
                val += String.valueOf(random.nextInt(10));  
            }  
        }  
        return val;  
	}

	public static String getTime() {
		SimpleDateFormat df = new SimpleDateFormat(Config.DATE_FORMAT);
		return df.format(new Date());
	}
}
