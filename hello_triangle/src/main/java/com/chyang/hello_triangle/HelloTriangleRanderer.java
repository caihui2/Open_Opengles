package com.chyang.hello_triangle;

import android.content.Context;
import android.content.res.AssetManager;
import android.opengl.GLSurfaceView;
import android.util.Log;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by caihuiyang on 2016/9/30.
 */

public class HelloTriangleRanderer implements GLSurfaceView.Renderer {

    public static final String TAG = "HelloTrianleRanderer";

    private FloatBuffer mVertices;
    private final float[] mVerticesDate = {0.0f, 0.0f, -0.5f, 0.0f, -0.5f, 0.0f, 0.5f, 0.0f};
    private AssetManager mAssetMgr = null;

    public HelloTriangleRanderer(Context context) {
        mVertices = ByteBuffer.allocateDirect(mVerticesDate.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        mVertices.put ( mVerticesDate ).position ( 0 );

    }

    public native void glesInit();
    public native  void glesRender();
    public native  void glesResize(int width, int height);
    public native  void readShaderFile(AssetManager assetMgr);

    public void RendererJNI(Context context) {
        mAssetMgr = context.getAssets();
        if(null == mAssetMgr) {
            Log.e(TAG, "getAssets return null !");
        }
    }


    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
         readShaderFile(mAssetMgr);
         glesInit();
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        glesResize(width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        glesRender();
    }


}
