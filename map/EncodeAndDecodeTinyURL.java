package map;

import java.util.*;

/*
535. Encode and Decode TinyURL
Medium

https://leetcode.com/problems/encode-and-decode-tinyurl/

Runtime: 24 ms, faster than 5.10% of Java online submissions for Encode and Decode TinyURL.
Memory Usage: 43.8 MB, less than 29.74% of Java online submissions for Encode and Decode TinyURL.

    Note: This is a companion problem to the System Design problem: Design TinyURL.
    
    https://leetcode.com/discuss/interview-question/124658/Design-a-URL-Shortener-(-TinyURL-)-System/

TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk. Design a class to encode a URL and decode a tiny URL.

There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.

Implement the Solution class:

    Solution() Initializes the object of the system.
    String encode(String longUrl) Returns a tiny URL for the given longUrl.
    String decode(String shortUrl) Returns the original long URL for the given shortUrl. It is guaranteed that the given shortUrl was encoded by the same object.

 

Example 1:

Input: url = "https://leetcode.com/problems/design-tinyurl"
Output: "https://leetcode.com/problems/design-tinyurl"

Explanation:
Solution obj = new Solution();
string tiny = obj.encode(url); // returns the encoded tiny url.
string ans = obj.decode(tiny); // returns the original url after deconding it.

 

Constraints:

    1 <= url.length <= 104
    url is guranteed to be a valid URL.

Accepted
202,462
Submissions
237,147

*/

class Codec {
    
    String base;
    Map<String, String> map;
    public Codec(){
        this.map = new HashMap<>();
        this.base = "http://tinyurl.com/";
    }
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        
        String id = this.generateId(longUrl);
        return this.base + id;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String id = this.getId(shortUrl);
        return this.map.get(id);
    }
    
    private String generateId(String url){
        UUID uuid = UUID.randomUUID();
        this.map.put(uuid.toString(), url);
        return uuid.toString();
    }
    
    private String getId(String url){
        String parts[] = url.split("/");
        return parts[parts.length - 1];
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));

public class EncodeAndDecodeTinyURL {
	
	
}
