// IMusicPlayer.aidl
package com.aidlmusicplayer.www.aidl;

import com.aidlmusicplayer.www.aidl.IMusicPlayerListener;
import com.aidlmusicplayer.www.aidl.SongListBean;

// Declare any non-default types here with import statements

interface IMusicPlayer {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
//    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
//            double aDouble, String aString);


        void action(in int action ,in String datum);
        void registerListener(IMusicPlayerListener listener);
        void unregisterListener(IMusicPlayerListener listener);
        void setPlayerListData(in List<SongListBean> info);
        Message getCurrentSongInfo();
}
