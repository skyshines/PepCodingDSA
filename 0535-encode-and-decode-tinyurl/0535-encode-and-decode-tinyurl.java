public class Codec {
    HashMap<String, String> hm = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        
        StringBuilder sb = new StringBuilder();
        
        while(hm.containsKey(sb.toString())){
            int ascii = (int)Math.floor(Math.random() * 100);
            sb.append((char)ascii);
        }
        
        String tinyurl = sb.toString();
        
        hm.put(tinyurl, longUrl);
        
        return tinyurl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return hm.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));