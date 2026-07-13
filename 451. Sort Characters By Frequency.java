class Solution {
    public String frequencySort(String s) {

        // Step 1: Count frequency of every character
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Max Heap based on frequency
        PriorityQueue<Character> pq = new PriorityQueue<>(
                (a, b) -> map.get(b) - map.get(a));

        // Add all unique characters into heap
        pq.addAll(map.keySet());

        StringBuilder ans = new StringBuilder();

        // Step 3: Remove highest frequency character first
        while (!pq.isEmpty()) {

            char ch = pq.poll();

            int freq = map.get(ch);

            // Append the character freq times
            while (freq-- > 0) {
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}
