package com.sh.yunrich.keyborddemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sh.yunrich.keyborddemo.dialog.BaseDialog;

public class MainActivity extends AppCompatActivity {

    private TextView tv_money;
    private Button btn_pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_money= (TextView) findViewById(R.id.tv_money);

    }

    public void showPwdDialog(View view){
        String money = tv_money.getText().toString();
        BaseDialog dialog = new BaseDialog();
        dialog.setStyle(0,R.style.dialog_anim_bottom);
        dialog.show(getFragmentManager(),"PwdDialog");
    }
}
