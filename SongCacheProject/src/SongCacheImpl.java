import java.util.*;

/**
 * Implementation of the SongCache interface.
 */
public class SongCacheImpl implements SongCache {
    HashMap<String , Integer> songRecord = new HashMap<>();
    @Override
    public void recordSongPlays(String songId, int numPlays) {
        songRecord.put(songId, songRecord.getOrDefault(songId, 0)+numPlays);
    }

    @Override
    public int getPlaysForSong(String songId) {
        return songRecord.get(songId);
    }

    @Override
    public List<String> getTopNSongsPlayed(int n) {
        LinkedHashMap<String, Integer> sortedMap = getSortedMap(songRecord);
        List<String> topNSongs = new ArrayList<>();
        for(Map.Entry<String, Integer> e : sortedMap.entrySet()){
            if(n>0){
                topNSongs.add(e.getKey());
                n--;
            }
            else{
                break;
            }
        }
        return topNSongs;
    }

    /**
     * @param songRecord A hashMap that will contain all the songs and the no. of times
     *                   they have played in an unsorted manner
     * @return A sorted HashMap by its values is returned
     * Using Java 8 Stream API I have sorted this hashmap based on its values in a descending
     * order.
     */
    private LinkedHashMap<String,Integer> getSortedMap(HashMap<String,Integer> songRecord) {
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        songRecord.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
        return reverseSortedMap;
    }
}
