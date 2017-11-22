package com.landsoft.startservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by TRANTUAN on 22-Nov-17.
 */

public class UnBoundService extends Service {
    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // Service này là loại không giàng buộc (Un bounded)
        // Vì vậy method này ko bao giờ được gọi.
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: Tạo đối tượng MediaPlayer, chơi file nhạc của bạn");
        // Tạo đối tượng MediaPlayer, chơi file nhạc của bạn.
        mediaPlayer =MediaPlayer.create(getApplicationContext(),R.raw.bay_ngan_dem_gop_lai);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: choi nhac");
        mediaPlayer.start();
        return START_NOT_STICKY;
    }



    @Override
    public void onDestroy() {
        // Giải phóng nguồn dữ nguồn phát nhạc.
        Log.d(TAG, "onDestroy: Giải phóng nguồn dữ nguồn phát nhạc");
        mediaPlayer.release();
        super.onDestroy();

    }
}
