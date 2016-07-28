package DifferentSorting;

import java.util.*;

public class Solution {
    
    public class Element {
        int val;
        int fre;
        
        public Element(int value) {
            this.val = value;
            this.fre = 1;
        }
    }
    
    public int schedule(int[] arr, int interval) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        PriorityQueue<Element> queue = new PriorityQueue<Element>(11, new Comparator<Element>() {
            public int compare(Element e1, Element e2) {
                return e2.fre - e1.fre;
            }
        });
        Element[] summary = new Element[10];
        for (int each : arr) {
            if (summary[each] == null) {
                summary[each] = new Element(each);
            } else {
                summary[each].fre++;
            }
        }
        for (Element e : summary) {
            if (e != null)
                queue.offer(e);
        }
        
        int time = 0;
        Queue<Element> temp = new LinkedList<>();
        while (!queue.isEmpty() || !temp.isEmpty()) {
            if (!queue.isEmpty()) {
                Element e = queue.poll();
                if (map.containsKey(e.val)) {
                    if (map.get(e.val) <= time) {
                        map.put(e.val, time + interval + 1);
                        e.fre--;
                        if (e.fre > 0)
                            queue.offer(e);
                        while (!temp.isEmpty()) {
                            queue.offer(temp.poll());
                        }
                        time++;
                    } else {
                        temp.offer(e);
                    }
                } else {
                    map.put(e.val, time + interval + 1);
                    e.fre--;
                    if (e.fre > 0)
                        queue.offer(e);
                    while (!temp.isEmpty()) {
                        queue.offer(temp.poll());
                    }
                    time++;
                }
            }
            else {
                while (!temp.isEmpty()) {
                    queue.offer(temp.poll());
                }
                time++;
            }
        }
        return time;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.schedule(new int[]{1, 1, 2, 2, 3, 3}, 2));
    }
}