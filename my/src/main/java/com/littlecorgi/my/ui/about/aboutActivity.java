package com.littlecorgi.my.ui.about;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;



import android.content.Context;
import android.content.Intent;

import android.os.Bundle;


import com.littlecorgi.commonlib.BaseActivity;
import com.littlecorgi.my.R;
import com.littlecorgi.my.logic.model.MyMessage;

import static com.littlecorgi.my.logic.dao.Tool.copyHelper;
import static com.littlecorgi.my.logic.dao.WindowHelp.setWindowStatusBarColor;
import static com.littlecorgi.my.ui.about.adviceActivity.StartAdviceActivity;
public class aboutActivity extends BaseActivity {
    /*
        这里需要版本号和下载地址，这里的处理为从Message中获取，Message为intent传入的带有数据的对象
     */
    private AppCompatTextView update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_about);
        initView();
        initData();
        //点击事件
        initClick();

    }
    private void initBarColor() {
        setWindowStatusBarColor(this,R.color.blue);
    }
    private void initClick() {
        AppCompatTextView returnButton = findViewById(R.id.my_about_returnButton);
        returnButton.setOnClickListener(v -> finish());
        ConstraintLayout adviceLayout = findViewById(R.id.my_about_advice);
        adviceLayout.setOnClickListener(v -> StartAdviceActivity(this));
        //长按复制
        update.setOnLongClickListener(v -> {
            copyHelper(this,update.getText().toString());
            return false;
        });
    }
    private void initView() {
        initBarColor();
        /*
            设置背景？
         */
        AppCompatImageView imageView = findViewById(R.id.my_about_bg);
    }
    private void initData() {

        Intent intent = getIntent();
        MyMessage myMessage = (MyMessage) intent.getSerializableExtra("myMessage");
        AppCompatTextView textView = findViewById(R.id.versionNumber);
        assert myMessage != null;
        textView.setText(myMessage.getVersion());
        update = findViewById(R.id.my_about_update);
        update.setText(myMessage.getUpdate());
    }
    public static void StartAboutActivity(Context context, MyMessage myMessage) {
        Intent intent = new Intent(context, aboutActivity.class);
        intent.putExtra("myMessage", myMessage);
        context.startActivity(intent);
    }
}