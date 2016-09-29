package com.chyang.hello_triangle;

import android.content.Context;
import android.opengl.GLSurfaceView;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by caihuiyang on 2016/9/30.
 */

public class HelloTriangleRanderer implements GLSurfaceView.Renderer {

    private FloatBuffer mVertices;
    private final float[] mVerticesDate = {0.0f, 0.0f, -0.5f, 0.0f, -0.5f, 0.0f, 0.5f, 0.0f};

    public HelloTriangleRanderer(Context context) {
        mVertices = ByteBuffer.allocateDirect(mVerticesDate.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        mVertices.put ( mVerticesDate ).position ( 0 );

    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

    }

    @Override
    public void onDrawFrame(GL10 gl) {

    }

}
