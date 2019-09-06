

public class MinStack {

    public Stack min;
    public Stack regular;

    public MinStack(){
        min = new Stack();
        regular = new Stack();
    }

    public boolean isEmpty(){
        return this.regular.isEmpty();
    }

    public int size(){
        return this.regular.size();
    }

    public void push(int payload){
        if(this.regular.isEmpty()){
            this.regular.push(payload); 
            this.min.push(payload);
        }
        else {
            if(payload <= this.min.peek()){
                this.min.push(payload);
            }
            this.regular.push(payload);
        }
    }

    public Integer pop(){
        if(this.regular.isEmpty())
            return null;
        else  {
            if(this.regular.peek() == this.min.peek())
                this.min.pop();
            return this.regular.pop();
        }   
    }

    public Integer peek(){
        return this.regular.peek();
    }

    public Integer getMin(){
        return this.min.peek();
    }
}