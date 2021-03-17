package com.example.uicustomviews;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.jar.Attributes;


// 创建自定义控件类
public class TitleLayout extends LinearLayout {
    // 构造函数：对标题栏布局进行动态加载
    public TitleLayout(Context context, AttributeSet attr) {
        super(context, attr);

        // from()构建出一个LayoutInflater对象
        // 调用该对象的inflate()动态加载一个布局文件
        // inflate()第一个参数是要加载的布局文件的id，第二个参数是给加载好的布局添加一个父布局
        LayoutInflater.from(context).inflate(R.layout.title, this);

        Button titleBack = (Button) findViewById(R.id.title_back);
        Button titleEdit = (Button) findViewById(R.id.title_edit);
        titleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish();
            }
        });
        titleEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "You clicked Edit Button",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
