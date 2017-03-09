package l33t_medium.google;

	import java.util.Comparator;
	import java.util.HashMap;
	import java.util.Map.Entry;
	import java.util.PriorityQueue;

/**
 * #451
 * 
 * @author qiaozhizhao
 *
 */
public class SortCharactersByFrequency {
	
    public String frequencySort(String s) {
    	HashMap<Character, Integer> map = new HashMap<>();
    	for(char c : s.toCharArray()){
    		map.put(c, map.getOrDefault(c, 0) + 1);
    	}
    	PriorityQueue<Entry<Character, Integer>> heap = new PriorityQueue<>(new Comparator<Entry<Character, Integer>>() {

			@Override
			public int compare(Entry<Character, Integer> o1,
					Entry<Character, Integer> o2) {
				// o1 - o2 == natural ordering 1-2-3
				return o2.getValue() - o1.getValue();
			}
    	});
    	heap.addAll(map.entrySet());
    	StringBuilder sb = new StringBuilder();
    	while(heap.peek() != null){
    		Entry<Character, Integer> e = heap.poll();
    		for(int i = 0; i < e.getValue(); i++){
    			sb.append(e.getKey());
    		}
    	}
    	return sb.toString();
    }
}
