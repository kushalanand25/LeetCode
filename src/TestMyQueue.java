import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 * @author Kushal
 *
 */
public class TestMyQueue {
	public static void main(String[] args) {
		MyQueue q = new MyQueue();
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(4);
		System.out.println(q.peek());
		q.pop();
		System.out.println(q.peek());
	}
}


class MyQueue {
    private int size = 0;
    private Stack<Integer> a = new Stack<>();
    private Stack<Integer> b = new Stack<>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        a.push(x);
        
//    	System.out.println("push:" + a + ">-->"+b ) ;
        size++;
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (empty())
            return;
        
        peek();
    	b.pop();
//    	System.out.println("pop:" + a + ">-->"+b ) ;
        size--;
    }

    // Get the front element.
    public int peek() {
    	if(b.isEmpty())
        	while(!a.isEmpty()){
        		b.push(a.pop());
        	}
        return b.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return size == 0;
    }
}