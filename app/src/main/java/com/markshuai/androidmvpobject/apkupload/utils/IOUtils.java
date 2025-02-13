package com.markshuai.androidmvpobject.apkupload.utils;

import android.content.Context;
import android.os.Environment;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

/**
 * 作者：MarkShuai on
 * 时间：2017/11/21 16:15
 * 邮箱：mark_mingshuai@163.com
 * 意图：IO工具类
 */

public class IOUtils {
    public static void closeIO(Closeable... closeables) {
        if (closeables != null) {
            for (Closeable closeable : closeables) {
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 删除之前的apk
     *
     * @param apkName apk名字
     * @return
     */
    public static File clearApk(Context context, String apkName) {
        File apkFile = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), apkName);
        if (apkFile.exists()) {
            apkFile.delete();
        }
        return apkFile;
    }
}
