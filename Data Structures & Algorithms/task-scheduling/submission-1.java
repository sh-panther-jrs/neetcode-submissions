class Task {
    char id;
    int timestamp;
    int count;
    public Task(char id, int timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int coolDown) {
        PriorityQueue<Task> taskQueue = getPQTaskCount(tasks);
        Queue<Task> que = new LinkedList<>();
        int time=0;
        while(!taskQueue.isEmpty() || !que.isEmpty()) {
            time++;
            if(taskQueue.isEmpty()) {
                time = que.peek().timestamp;
            } else {
                Task t = taskQueue.poll();    
                if(t.count-1>0) {
                    t.timestamp=time + coolDown;
                    t.count-=1;
                    que.offer(t);
                }
            }
            if(!que.isEmpty() && que.peek().timestamp==time) {
                taskQueue.offer(que.poll());
            }
        }
        return time;
    }


    private PriorityQueue<Task> getPQTaskCount(char[] tasks) {
        HashMap<Character, Integer> taskToCount = new HashMap<>();
        for(char ch: tasks) {
            taskToCount.putIfAbsent(ch, 0);
            taskToCount.put(ch, taskToCount.get(ch)+1);
        }
        Comparator<Task> c = (t1, t2) -> {
            return t2.count-t1.count;
        };
        PriorityQueue<Task> pq = new PriorityQueue<Task>(c);
        for(Map.Entry<Character, Integer> tk: taskToCount.entrySet()) {
            Task t = new Task(tk.getKey(), 0);
            t.count = tk.getValue();
            pq.offer(t);
        }
        return pq;
    }
}

