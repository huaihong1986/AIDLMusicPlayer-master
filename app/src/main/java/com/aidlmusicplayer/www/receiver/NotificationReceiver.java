package com.aidlmusicplayer.www.receiver;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;

import com.aidlmusicplayer.www.App;
import com.aidlmusicplayer.www.config.Constant;
import com.aidlmusicplayer.www.service.MusicService;

import static com.aidlmusicplayer.www.service.MusicService.MUSIC_ACTION_PLAY;

public class NotificationReceiver extends BroadcastReceiver {

    public static final String ACTION_MUSIC_PLAY = "com.aidlmusicplayer.www.action.music.play";
    public static final String ACTION_MUSIC_NEXT = "com.aidlmusicplayer.www.action.music.next";
    public static final String ACTION_MUSIC_STOP = "com.aidlmusicplayer.www.action.music.stop";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (App.app.getMusicPlayerService() == null) {
            return;
        }
        String action = intent.getAction();
        try {
            switch (action) {
                case ACTION_MUSIC_PLAY:
                    if (MusicService.MUSIC_CURRENT_ACTION == MUSIC_ACTION_PLAY) {
                        App.app.getMusicPlayerService().action(MusicService.MUSIC_ACTION_PAUSE, "");
                    } else {
                        App.app.getMusicPlayerService().action(MusicService.MUSIC_ACTION_CONTINUE_PLAY, "");
                    }
                    break;
                case ACTION_MUSIC_NEXT:
                    App.app.getMusicPlayerService().action(MusicService.MUSIC_ACTION_NEXT, "");
                    break;
                case ACTION_MUSIC_STOP:
                    App.app.getMusicPlayerService().action(MusicService.MUSIC_ACTION_STOP, "");
                    break;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
