//
// Created by caihui yang on 2016/10/2.
//
#include "HelloTriangleRandeer.h"


JNIEXPORT jstring Java_com_chyang_hello_1triangle_HelloTriangleRenderer_getString(JNIEnv * env, jobject obj) {

    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

