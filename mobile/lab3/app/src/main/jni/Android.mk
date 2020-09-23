LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := local
LOCAL_SRC_FILES := local.c

include $(BUILD_SHARED_LIBRARY)