

public class MaxStack {

    public Stack max;
    public Stack regular;

    public MaxStack(){
        max = new Stack();
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
            this.max.push(payload);
        }
        else {
            if(payload >= this.max.peek()){
                this.max.push(payload);
            }
            this.regular.push(payload);
        }
    }

    public Integer pop(){
        if(this.regular.isEmpty())
            return null;
        else  {
            if(this.regular.peek() == this.max.peek())
                this.max.pop();
            return this.regular.pop();
        }   
    }

    public Integer peek(){
        return this.regular.peek();
    }

    public Integer getMax(){
        return this.max.peek();
    }
}