import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        MaxPriorityQueue pq = new MaxPriorityQueue();
        int n = Integer.valueOf(br.readLine());
        while(n --> 0){
            int x = Integer.valueOf(br.readLine());
            if (x == 0){
                bw.write(pq.pop()+ "\n");
            }
            else
                pq.push(x);
        }
        bw.flush();
        bw.close();
    }
}

class MaxPriorityQueue{
    int[] heap;
    int size;
    public MaxPriorityQueue(){
        heap = new int[100001];
        size = 0;
    }
    void swap(int a, int b){
        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }

    public void push(int x) {
        heap[++size] = x;
        int current = size;
        while (current > 1){
            int parent = current / 2;
            if(heap[parent] >= heap[current]) break;
            swap(parent, current);
            current = parent;
        }
    }
    public int pop() {
        if (size == 0) return 0;
        int ret = heap[1];

        heap[1] = heap[size--];
        int current = 1;
        while (current * 2 <= size){
            int left = current * 2;
            int right = left + 1;
            int child = left;
            if (right <= size && heap[left] < heap[right]){
                child = right;
            }
            if (heap[current] >= heap[child]) break;
            swap(current, child);
            current = child;
        }


        return ret;
    }
}
