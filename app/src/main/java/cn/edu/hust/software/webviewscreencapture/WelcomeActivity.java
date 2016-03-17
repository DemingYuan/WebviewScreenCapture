package cn.edu.hust.software.webviewscreencapture;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URL;
import java.net.HttpURLConnection;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().addFlags(128);
        setContentView(R.layout.activity_welcome);

        final EditText myEdit = (EditText)findViewById(R.id.edit_wel);
        final TextView myText = (TextView)findViewById(R.id.edit_wel);
        final String[] url = new String[1];
        myEdit.setHint("Your URL");




        Button button_b = (Button) findViewById(R.id.button_demo);

        button_b.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)

            {
                url[0] = "http://192.168.0.101:8080";
                myEdit.setText(url[0]);
                // Do something in response to button click

            }

        });

        Button button_a = (Button) findViewById(R.id.button_auto);

        button_a.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)

            {
                url[0] = autoUrl();
                myEdit.setText(url[0]);
                // Do something in response to button click

            }

        });

        Button button_o = (Button) findViewById(R.id.button_ok);

        button_o.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)

            {
                url[0] = myEdit.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("textIndex", url[0]);
                intent.setClass(WelcomeActivity.this, Welcome2Activity.class);
                WelcomeActivity.this.startActivity(intent);
                // Do something in response to button click

            }

        });


    }

    public String autoUrl() {
        String myUrl = new String("http://www.youtube.com");

        return myUrl;
    }

    @Override

    public
    void onWindowFocusChanged(boolean hasFocus) {

        super.onWindowFocusChanged(hasFocus);
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

//    public String ip() throws IOException {
//        int port = 8080;
//        int retry = 3;// 重试次数
//        int count = 0;
//        String all = "";
//
//        String ip = InetAddress.getLocalHost().getHostAddress();
//        String ipHead = ip.substring(0, ip.lastIndexOf('.') + 1);
//        Selector selector = Selector.open();
//        for (int tail = 1; tail < 255; tail++) {
//            SocketChannel channel = SocketChannel.open();
//            SocketAddress address = new InetSocketAddress(ipHead + tail, port);
//            channel.configureBlocking(false);
//            channel.connect(address);
//            channel.register(selector, SelectionKey.OP_CONNECT, address);// 这里你也可以用输入或者输出
//        }
//        while (retry-- > 0) {
//            // selector.select(1000 * 5);这里可以设置超时时间
//            selector.select();
//            Set<SelectionKey> keys = selector.selectedKeys();
//
//            for (Iterator<SelectionKey> it = keys.iterator(); it.hasNext(); ) {
//                SelectionKey key = it.next();
//                it.remove();
//
//                if (key.isConnectable()) {
//                    all += key.attachment();
//                    all = all.replace("/", "");
//                    all = all.replace(ipHead, "");
//                    all = all.replace("8080", "");
//                    key.cancel();
//
//                }
//            }
//        }
//        String thisip = ip;
//        thisip = thisip.replace(ipHead, "");
//
//        all = all.replace("1:", "");
//        all = all.replace(thisip, "");
//        all = all.replace(":", "");
//
//        thisip = ipHead.concat(all);
//        return thisip;
//    }
}


