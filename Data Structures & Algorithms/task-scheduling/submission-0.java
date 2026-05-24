class TaskNode {
    char c;
    int freq;
    public TaskNode(char c, int t) {
        this.c = c;
        this.freq=t;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int coolDown) {

        Map<Character, Integer>  taskCount = getTaskCount(tasks);
        PriorityQueue<TaskNode> pq = buildPQ(taskCount);
        int time =0;
        while(!pq.isEmpty()) {
            int n =0;
            int index=0;
            while(index<coolDown+1) {
                if (!pq.isEmpty()) {
                    TaskNode t = pq.poll();
                    if (taskCount.get(t.c)==1) {
                        taskCount.remove(t.c);
                    } else {
                        taskCount.put(t.c, taskCount.get(t.c)-1);
                    }
                    n++;
                }
                else if (taskCount.size()>0) {
                    n++;
                }
                index++;         
            }
            time = time+n;
            pq = buildPQ(taskCount);
        }
        return time;
    }
    private PriorityQueue<TaskNode> buildPQ(Map<Character, Integer>  tasks) {
        Comparator <TaskNode> tn = (t1, t2) -> {
            return t2.freq-t1.freq;
        };
        PriorityQueue<TaskNode> pq = new PriorityQueue<TaskNode>(tn);
        for (Map.Entry<Character,Integer> entry: tasks.entrySet()) {
            pq.offer(new TaskNode(entry.getKey(), entry.getValue()));
        }
        return pq;
    }
    private HashMap<Character, Integer> getTaskCount(char[] tasks) {
        HashMap<Character, Integer> output = new HashMap<>();
        for (char task:tasks) {
            output.put(task, output.getOrDefault(task, 0)+1);
        }
        return output;
    }
}

