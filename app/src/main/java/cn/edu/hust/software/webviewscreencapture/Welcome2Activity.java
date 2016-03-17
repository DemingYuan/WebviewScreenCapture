package cn.edu.hust.software.webviewscreencapture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Welcome2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        final String[] url = new String[1];
        url[0]=intent.getStringExtra("textIndex");

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().addFlags(128);
        setContentView(R.layout.activity_welcome2);

        TextView text = (TextView) findViewById(R.id.w2t);
        text.setText(url[0]);
        Button bt = (Button) findViewById(R.id.sbt);


        bt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)

            {
                Intent intent1 = new Intent();
                intent1.putExtra("textIndex", url[0]);
                intent1.setClass(Welcome2Activity.this, MainActivity.class);
                Welcome2Activity.this.startActivity(intent1);
                // Do something in response to button click

            }

        });
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

        super.onWindowFocusChanged(hasFocus);
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }
}
