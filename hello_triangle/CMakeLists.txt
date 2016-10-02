# Sets the minimum version of CMake required to build your native library.
# This ensures that a certain set of CMake features is available to
# your build.

cmake_minimum_required(VERSION 3.4.1)

# Specifies a library name, specifies whether the library is STATIC or
# SHARED, and provides relative paths to the source code. You can
# define multiple libraries by adding multiple add.library() commands,
# and CMake builds them for you. When you build your app, Gradle
# automatically packages shared libraries with your APK.

link_directories("android/native_app_glue")
include_directories(src/main/cpp/include/)

add_library( # Specifies the name of the library.
             renderer

            # Sets the library as a shared library.
             SHARED

            # Provides a relative path to your source file(s).
            src/main/cpp/HelloTriangleRenderer.cpp)


find_library( OPENGLES3_LIBRARY GLESv2 "OpenGL ES v3.0 library")
find_library( EGL_LIBRARY EGL "EGL 1.4 library" )
find_library (android_native_app_glue glue )


