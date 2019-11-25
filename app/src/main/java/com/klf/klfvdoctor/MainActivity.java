package com.klf.klfvdoctor;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.klf.videodoctor.KlfVDoctor;
import com.klf.videodoctor.listener.KlfLoginListener;
import com.klf.videodoctor.listener.KlfVCallListener;

public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private KlfVCallListener hhCallListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hhCallListener = new KlfVCallListener() {

            @Override
            public void onStart() {//启动呼叫
                Log.e(TAG, "call onStart");
            }

            @Override
            public void onCalling() {//呼叫中
                Log.e(TAG, "call onCalling");
            }

            @Override
            public void onInTheCall() {//通话中
                Log.e(TAG, "call onInTheCall");
            }

            @Override
            public void onFinish() {//通话结束
                Log.e(TAG, "call onFinish");
            }

            @Override
            public void onCallSuccess() {//呼叫成功，等待医生接受
                Log.e(TAG, "call onCallSuccess");
            }

            @Override
            public void onFail(int i) {//呼叫失败
                Log.e(TAG, "call onFail - code==" + i);
            }

            @Override
            public void onCancel() {//取消呼叫  含 取消排队
                Log.e(TAG, "call onCancel");
            }

            @Override
            public void onLineUpTimeout() {//排队超时 自动取消
                Log.e(TAG, "call onLineUpTimeout");
            }

            @Override
            public void onLineUp() {//需要排队等待
                Log.e(TAG, "call onLineUp");
            }
        };

        KlfVDoctor.login(this, "4841CFDB738B20E9BDEC7C81CC7241573F0D04F68EA2608F6783B874E4F50EEF", new KlfLoginListener() {
            @Override
            public void onSuccess() {
                Log.e(TAG, "loginSucceed...");
                KlfVDoctor.callForAdult(MainActivity.this, hhCallListener);
            }

            @Override
            public void onError(String s) {
                Log.e(TAG, s);
            }
        });
    }
}
