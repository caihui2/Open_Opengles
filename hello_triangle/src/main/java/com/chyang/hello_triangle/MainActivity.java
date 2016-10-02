package com.chyang.hello_triangle;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private final int CONTEXT_CLIENT_VERSION = 3;

    private GLSurfaceView mGlSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGlSurfaceView = new GLSurfaceView(this);
        if(datectOpenGLES300()) {
            mGlSurfaceView.setEGLContextClientVersion(CONTEXT_CLIENT_VERSION);
            mGlSurfaceView.setRenderer(new HelloTriangleRenderer(this));
        } else {
            finish();
        }

        setContentView(mGlSurfaceView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGlSurfaceView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGlSurfaceView.onPause();
    }

    private boolean datectOpenGLES300 (){
        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        ConfigurationInfo info = am.getDeviceConfigurationInfo();
        return (info.getGlEsVersion().equals("3.0"));
    }
}
