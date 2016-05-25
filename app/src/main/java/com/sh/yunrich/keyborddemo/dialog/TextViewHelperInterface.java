package com.sh.yunrich.keyborddemo.dialog;


public interface TextViewHelperInterface {
	public void add(String tx);
	public void addPins(int len, int key);
	public void back();
	public boolean isFinished();
	public void clean();
	public boolean isPwdCorrect(String correct);
}
