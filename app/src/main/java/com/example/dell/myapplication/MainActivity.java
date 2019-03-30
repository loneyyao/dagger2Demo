package com.example.dell.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.ArrowKeyMovementMethod;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ClickableSpan;
import android.text.util.Linkify;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.dell.myapplication.four.DaggerAppComponent;
import com.example.dell.myapplication.four.IView;
import com.example.dell.myapplication.four.MyModule;
import com.example.dell.myapplication.four.MyPresenter;
import com.example.dell.myapplication.lottie.LottieActivity;
import com.example.dell.myapplication.retrofit.RetrofitActivity;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, IView {

    private TextView textView;
//    @Inject
//    User user;
//    @Inject
//    Student student;
//
//    @Inject
//Teacher teacher;

    @Inject
    MyPresenter myPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String string = getResources().getString(R.string.mystring);
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        textView = findViewById(R.id.textView);
        boolean linksClickable = textView.getLinksClickable();
        int autoLinkMask = textView.getAutoLinkMask();
        String str = "这是我010-56238956 13994110831的邮箱 13261960306 6656896357@t-online.de  656896357@   656896357.com   656896357@.com  656896357@QQ.com1我是你爸爸 请给我发有限你百度http://www.baidu.com/，腾讯http://www.qq.com/，淘宝www.taobao.com/  百:  baidu.com大叔大婶阿斯达艾什顿  " + linksClickable + autoLinkMask;
        String str1 = "我爱你 baidu.com";
//        textView.setText(str1);

        textView.setLinkTextColor(getResources().getColor(R.color.colorPrimary));//如保持系统风

        //设置这一步才可以响应点击事件,要不然点击没反应
        textView.setMovementMethod(new LinkMovementMethod());
        textView.setText(checkAutoLink(str));


        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);

        ArrayList<String> list = new ArrayList<>();
        list.add("13261960306");
        list.add("13261960307");

//        DaggerUserActivityComponent.create().inject(this);
//        DaggerStudentAvtivityComponent.create().inject(this);
//        DaggerSchoolActivityComponent.builder().schoolModule(new SchoolModule(list)).build().inject(this);
//        TestUrl.makeUrl("http://guanyu.rce-dev.rongcloud.net/////////////////////////////////api/////////////////////////groups//////////////zDSgjqQgSNIoDysxhYMxx4/////////////////////////////////////////////////////////////////////////name");
        DaggerAppComponent.builder().myModule(new MyModule(this)).build().inject(this);


    }

    //利用正则识别
    private CharSequence checkAutoLink(String content) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(content);
        Pattern urlPattern = Pattern.compile("((https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|])|((www|ftp)\\.[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|])");
        Matcher urlMatcher = urlPattern.matcher(spannableStringBuilder);
        while (urlMatcher.find()) {
            Log.d(this.getPackageName(), "匹配到网址了");
            setClickableSpan(spannableStringBuilder, urlMatcher);
        }

        Pattern emailPattern = Pattern.compile(
                "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                        "\\@" +
                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                        "(" +
                        "\\." +
                        "[a-zA-Z0-9][a-zA-Z\\-]{0,25}" +
                        ")+"
        );
        Matcher emailMatcher = emailPattern.matcher(spannableStringBuilder);
        while (emailMatcher.find()) {
            setClickableSpan(spannableStringBuilder, emailMatcher);
//            Toast.makeText(this, "匹配到邮箱了",Toast.LENGTH_SHORT).show();
        }

        Pattern phonePattern = Pattern.compile(                      // sdd = space, dot, or dash
                "([0-9]+[\\- \\.]*)?"        // +<digits><sdd>*
                        + "(\\([0-9]+\\)[\\- \\.]*)?"   // (<digits>)<sdd>*
                        + "([0-9][0-9\\-]+[0-9])");
        Matcher phoneMatcher = phonePattern.matcher(spannableStringBuilder);
        while (phoneMatcher.find()) {
            setClickableSpan(spannableStringBuilder, phoneMatcher);
//            Toast.makeText(this, "匹配到phone了",Toast.LENGTH_SHORT).show();
        }
        return spannableStringBuilder;
    }


//给符合的设置自定义点击事件


    private void setClickableSpan(final SpannableStringBuilder clickableHtmlBuilder, final Matcher matcher) {
        int start = matcher.start();
        int end = matcher.end();

        final String url = matcher.group();
        ClickableSpan clickableSpan = new ClickableSpan() {
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
//                intent.putExtra("url", url);
//                startActivity(intent);
                Toast.makeText(MainActivity.this,"哈哈哈哈",Toast.LENGTH_SHORT).show();

            }
        };
        clickableHtmlBuilder.setSpan(clickableSpan, start, end, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.button:
//                user.setName("lizejun");
//                textView.setText(user.getName());
                break;
            case R.id.button2:
//                textView.setText(student.getUser().getName() + student.getUser().getAge() + student.getGrade());
                break;
            case R.id.button3:
//                textView.setText(teacher.getmList().toString());
                break;
            case R.id.button4:
                myPresenter.loadData();
                break;
            case R.id.button5:
                startActivity(new Intent(this, LottieActivity.class));
                break;
            case R.id.button6:
                startActivity(new Intent(this, RetrofitActivity.class));
                break;
            default:
                break;
        }
    }

    @Override
    public void updateUI(String result) {
        textView.setText(result);
    }
}
