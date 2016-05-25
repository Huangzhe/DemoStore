package com.sh.yunrich.keyborddemo.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.sh.yunrich.keyborddemo.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hyz84 on 16/5/23.
 */
public class BaseDialog extends DialogFragment {

    ViewStub  viewStub ;
    View keyBordView;
    private TextView tv1,tv2,tv3,tv4,tv5,tv6;
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnOk;
    private ImageButton btnBack;
    private List<Button> btnsList = new ArrayList<>();
    private List<String> pins = new ArrayList<>();
    private List<TextView> listPins = new ArrayList<>();
    TextViewHelper textHelper;
    private int pinLen=0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog,null);
        tv1= (TextView) view.findViewById(R.id.tx_pin01);
        tv2= (TextView) view.findViewById(R.id.tx_pin02);
        tv3= (TextView) view.findViewById(R.id.tx_pin03);
        tv4= (TextView) view.findViewById(R.id.tx_pin04);
        tv5= (TextView) view.findViewById(R.id.tx_pin05);
        tv6= (TextView) view.findViewById(R.id.tx_pin06);
        listPins.add(tv1);
        listPins.add(tv2);
        listPins.add(tv3);
        listPins.add(tv4);
        listPins.add(tv5);
        listPins.add(tv6);

        textHelper = new TextViewHelper(listPins);

        viewStub = (ViewStub) view.findViewById(R.id.viewstub);
        initView();


        return view;
    }

    private void initView() {
        if(viewStub!=null){
            keyBordView =  viewStub.inflate();

            btn0= (Button) keyBordView.findViewById(R.id.num0);
            btn1= (Button) keyBordView.findViewById(R.id.num1);
            btn2= (Button) keyBordView.findViewById(R.id.num2);
            btn3= (Button) keyBordView.findViewById(R.id.num3);
            btn4= (Button) keyBordView.findViewById(R.id.num4);
            btn5= (Button) keyBordView.findViewById(R.id.num5);
            btn6= (Button) keyBordView.findViewById(R.id.num6);
            btn7= (Button) keyBordView.findViewById(R.id.num7);
            btn8= (Button) keyBordView.findViewById(R.id.num8);
            btn9= (Button) keyBordView.findViewById(R.id.num9);
            btnOk= (Button) keyBordView.findViewById(R.id.num_ok);
            btnBack= (ImageButton) keyBordView.findViewById(R.id.num_back);

            btnsList.add(btn0);
            btnsList.add(btn1);
            btnsList.add(btn2);
            btnsList.add(btn3);
            btnsList.add(btn4);
            btnsList.add(btn5);
            btnsList.add(btn6);
            btnsList.add(btn7);
            btnsList.add(btn8);
            btnsList.add(btn9);
            btnsList.add(btnOk);

            List<Integer> data =  getRadomnum();

            for(int x=0;x<data.size();x++){
                btnsList.get(x).setText(data.get(x)+"");
                btnsList.get(x).setOnClickListener(new MyOnClickListener());
            }
            btnOk.setOnClickListener(new MyOnClickListener());
            btnBack.setOnClickListener(new MyOnClickListener());

        }

    }




    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        WindowManager.LayoutParams layoutParams = getDialog().getWindow().getAttributes();
        layoutParams.width = dm.widthPixels;
        layoutParams.height = dm.heightPixels/2;
        layoutParams.gravity = Gravity.BOTTOM;
        getDialog().getWindow().setAttributes(layoutParams);


        initView();

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    /**
     * 将0-9十个数字从新排列
     * @return
     */
   private List<Integer> getRadomnum(){
       List<Integer> data = new ArrayList<>();
       data.add(0);
       data.add(1);
       data.add(2);
       data.add(3);
       data.add(4);
       data.add(5);
       data.add(6);
       data.add(7);
       data.add(8);
       data.add(9);
       Collections.shuffle(data);//刷新顺序
       return data;
   }

    private class MyOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
        switch (v.getId()){
            case R.id.num0:
            case R.id.num1:
            case R.id.num2:
            case R.id.num3:
            case R.id.num4:
            case R.id.num5:
            case R.id.num6:
            case R.id.num7:
            case R.id.num8:
            case R.id.num9:
                textHelper.add(((Button)v).getText().toString());
                break;
            case R.id.num_back:
                    textHelper.back();
                break;
            case R.id.num_ok:
                Toast.makeText(getActivity(),textHelper.getPwd(),Toast.LENGTH_LONG).show();
                dismiss();
                break;
        }
        }
    }
}
