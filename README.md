# Count-Unique-Characters-of-All-Substrings-of-a-Given-String
Given a string s, return the sum of unique characters of all substrings of s.  A character is unique in a substring if it occurs exactly once in that substring.
Explanation:
We track the two most recent occurrences of each character (using index[c][0] and index[c][1]).

The contribution of each character is calculated using the formula:
(𝑙𝑎𝑠𝑡−𝑝𝑟𝑒𝑣)×(𝑖−𝑙𝑎𝑠𝑡)
(last−prev)×(i−last)
Which counts how many substrings contain that character as unique.

Finally, we process the remaining contribution after the string ends.

This solution is linear in time O(n) and space O(1), making it suitable for strings up to 10,000 characters............
