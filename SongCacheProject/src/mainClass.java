import java.util.List;

public class mainClass {
    public  static void main(String args[]){
        SongCache cache = new SongCacheImpl();
        cache.recordSongPlays("ID-1", 3);
        cache.recordSongPlays("ID-1", 1);
        cache.recordSongPlays("ID-2", 2);
        cache.recordSongPlays("ID-3", 5);

        System.out.println(cache.getPlaysForSong("ID-1"));
        //System.out.println(cache.getPlaysForSong("ID-9"));

        List<String> ans1 = cache.getTopNSongsPlayed(2);
        List<String> ans2 = cache.getTopNSongsPlayed(0);

        System.out.println(ans1);
        System.out.println(ans2);

    }
}
