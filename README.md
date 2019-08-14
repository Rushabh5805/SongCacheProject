# SongCacheProject

SongCache is an Interface with the abstract methods:
  recordSongPlays(String songId, int numPlays)
  getPlaysForSong(String songId)
  getTopNSongsPlayed(int n)
 
SongCacheImpl is the implementation of the SongCache Interface. Logic used for the methods:
  Here I have used a HashMap to store all the song Id and the numPlays.
  
  #recordSongPlays(String songId, int numPlays) : Using this method I have just added the songId and numplays into the hashmap if it is not present. And if it is present then we will just add the numPlays to the existing ones.
  
  getPlaysForSong(String songId) : Here we will return the numPlays from the HashMap using the get method of the HashMap.
  
  getTopNSongsPlayed(int n) : As we need to return the top N songs here, we will put the top N songs into the list and in order to get the top N songs we will sort the hashMap that we have according to its values. And then simple add the top N songs from the hashmap to the list. And finally return it.
  
  getSortedMap(HashMap<String,Integer> songRecord) : Here we will sort the hashmap according to its values in a descending order. I am using the Stream API of java 8 in order to sort hashmap.
