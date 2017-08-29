package weixin.entity.resp;

/**
 * Created by Administrator on 2016/7/13.
 * IntelliJ IDEA 2016 of gzcss
 */
public class MusicMessage extends weixin.entity.req.BaseMessage {
    // 音乐
    private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}