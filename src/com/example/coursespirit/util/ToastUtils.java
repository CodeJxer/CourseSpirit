package com.example.coursespirit.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast��ʾ������  
 * createdTime: 2014��12��18�� ����10:55:21  
 *
 */
public class ToastUtils {
	
	public static void toast(Context context,String msg){
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}
	
	public static void toast(Context context,int msgId){
		Toast.makeText(context, msgId, Toast.LENGTH_SHORT).show();
	}
	
}
