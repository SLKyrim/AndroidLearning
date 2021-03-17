package com.example.activitytest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        // 通过findViewById()方法获取布局中的元素，返回View对象，向下转型为Button
        Button button1 = (Button) findViewById(R.id.button_1);

        // 为按钮注册监听器，点击按钮时执行监听器中的onClick()方法
        button1.setOnClickListener(new View.OnClickListener() {
            // @Override
            // public void onClick(View v) {
            //     // Toast将短小的信息通知给用户，过段时间自动消失
            //     // makeText()方法第一个参数为Toast要求的上下文，第二个参数为Toast显示的内容
            //     // 第三个参数为Toast显示的时长
            //     Toast.makeText(FirstActivity.this, "You clicked Button 1",
            //             Toast.LENGTH_SHORT).show();
            // }

            // @Override
            // public void onClick(View v) {
            //     finish(); // 销毁当前活动，效果等于按下Back键
            // }

            // // 显式Intent
            // @Override
            // public void onClick(View v) {
            //     // intent是Android程序中各组件之间交互的一种重要方式
            //     // Intent()，第一个参数指定启动活动的上下文，第二个参数指定待启动的目标活动
            //     Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
            //     startActivity(intent);
            // }

            // // 隐式Intent
            // @Override
            // public void onClick(View v) {
            //     // Intent intent = new Intent("com.example.activitytest.ACTION_START");
            //     // intent.addCategory("com.example.activitytest.MY_CATEGORY");
            //     // startActivity(intent);
            //
            //     // 启动程序外的浏览器
            //     Intent intent = new Intent(Intent.ACTION_VIEW);
            //     intent.setData(Uri.parse("http://www.baidu.com"));
            //     startActivity(intent);
            // }

            @Override
            public void onClick(View v) {
                // // 给SecondActivity传递字符串
                // String data = "Hello SecondActivity";
                // Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                // // putExtra()第一个参数为键，用于后面从intent中取值，第二个参数为要传递的数据
                // intent.putExtra("extra_data", data);
                // startActivity(intent);

                // startActivityForResult()第二个参数为请求码，在之后的回调中判断数据的来源
                // 用此方法启动的活动被销毁后会回调上一个活动的onActivityResult()方法
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // getMenuInflater()获取MenuInflater对象
        // inflate()方法，第一个参数指定通过哪一个资源文件来创建菜单
        // 第二个参数指定菜单项将添加到哪一个Menu对象中
        getMenuInflater().inflate(R.menu.main, menu);
        return true; // true允许创建的菜单显示出来
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    // 在此活动中调用startActivityForResult()启动的下一活动在被销毁后将回调此方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnedData);
                }
                break;
            default:
        }
    }
}