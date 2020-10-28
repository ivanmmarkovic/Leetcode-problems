/*
187. Repeated DNA Sequences
Medium

https://leetcode.com/problems/repeated-dna-sequences/

Runtime: 16 ms, faster than 76.78% of Java online submissions for Repeated DNA Sequences.
Memory Usage: 47.9 MB, less than 13.23% of Java online submissions for Repeated DNA Sequences.

All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T', for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 

Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]

Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]

 

Constraints:

    0 <= s.length <= 105
    s[i] is 'A', 'C', 'G', or 'T'.

Accepted
189,229
Submissions
465,265

*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
		Set<String> seen = new HashSet<>();
		Set<String> sequences = new HashSet<>();
		String tmp = null;
		for (int i = 0; i + 10 <= s.length(); i++) {
			tmp = s.substring(i, i + 10);
			if (seen.contains(tmp))
				sequences.add(tmp);
			else
				seen.add(tmp);

		}
		return new ArrayList<>(sequences);

	}
}
