package com.sh.yunrich.keyborddemo.dialog;

import android.util.Log;
import android.widget.TextView;

import java.util.List;


public class TextViewHelper implements TextViewHelperInterface {
	
	private final String TAG = "TextViewHelper";
	private List<TextView> pins = null;
	private int PinNumber;
	private int index = 0;
	/**
	 * 密码明文存放
	 */
	private String pwd = "";

	public TextViewHelper(List<TextView> list) {
		pins = list;
		PinNumber = list.size();
		index = 0;
	}

	@Override
	public void add(String tx) {
		// TODO Auto-generated method stub
		if (index < PinNumber) {
			pins.get(index++).setText("*");
			pwd += tx;
			Log.d(TAG, "add 密码明文为 = "+pwd);
		}

	}

	@Override
	public void back() {
		// TODO Auto-generated method stub
		if(index > 0)
		{
			pins.get(--index).setText("");
			pwd = pwd.substring(0, pwd.length()-1);
			Log.d(TAG, "back 密码明文为 = "+pwd);
		}
	}

	public  String getPwd(){
		return pwd;
	}
	@Override
	public boolean isFinished() {
		if (index >= (PinNumber))
			return true;
		else
			return false;
	}

	@Override
	public void addPins(int len, int key) {
		clean();
		for (int i = 0; i < (len <= PinNumber ? len : PinNumber); i++) {
			pins.get(i).setText("*");
		}
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub
		for (int i = 0; i < PinNumber; i++) {
			pins.get(i).setText("");
			index = 0;//这里要把index重新置0 不然不能继续输入会引起程序crash
		}
		pwd = "";
	}

	@Override
	public boolean isPwdCorrect(String correct) {
		// TODO Auto-generated method stub
		Log.d(TAG, "pwd比对，输入pwd为 = "+pwd+" 需要验证的pwd为 = "+correct);
		Log.d(TAG, "比对结果为 = "+(pwd.equals(correct)?true:false));
		return pwd.equals(correct)?true:false;
	}
	
	
}
