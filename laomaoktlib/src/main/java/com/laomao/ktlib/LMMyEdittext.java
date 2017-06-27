package com.laomao.ktlib;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laomao on 2017/6/27.
 */

public class LMMyEdittext extends LinearLayout {
    private EditText et1, et2, et3, et4;
    List<EditText> list = new ArrayList<>();
    int foucesInex = 0;

    public LMMyEdittext(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attributeSet) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.custcom_edittext, this, true);
        list.add((EditText) findViewById(R.id.lm_et1));
        list.add((EditText) findViewById(R.id.lm_et2));
        list.add((EditText) findViewById(R.id.lm_et3));
        list.add((EditText) findViewById(R.id.lm_et4));
        for (EditText et : list) {
            et.setInputType(InputType.TYPE_NULL);
        }
        setFouces(MYEDIT.HOUR1);
    }

    public void setInitText(String s1, String s2, String s3, String s4) {
        list.get(0).setText(s1);
        list.get(1).setText(s2);
        list.get(2).setText(s3);
        list.get(3).setText(s4);

    }

    public void setText(MYEDIT myedit, String str) {

        list.get(myedit.getIndex()).setText(str);
    }

    public void setFouces(MYEDIT myedit) {
        foucesInex = myedit.getIndex();
        list.get(myedit.getIndex()).requestFocus();
        Selection.selectAll(list.get(myedit.getIndex()).getText());
    }

    public void setFoucesText(String str) {
        list.get(foucesInex).setText(str);
        setFoucesRight();

    }

    public void setFoucesLeft() {
        if (foucesInex > 0) {
            list.get(foucesInex - 1).requestFocus();
            Selection.selectAll(list.get(foucesInex - 1).getText());
            foucesInex-=1;
        }
    }

    public void setFoucesRight() {
        if (foucesInex < 3) {
            list.get(foucesInex + 1).requestFocus();
            Selection.selectAll(list.get(foucesInex + 1).getText());
            foucesInex+=1;
        }

    }

}

