package Classes;
import java.util.ArrayList;

public class Semaphore {
    private ArrayList<Boolean> statements = new ArrayList<Boolean>();
    public  boolean isRepeat = true;
    private boolean isCountable;
    private int count;

    public Semaphore(){
        this.isCountable = false;
    }
    public Semaphore(int count){
        this.count = count;
        this.isCountable = true;
    }

    public int onQueue(){
        statements.add(false);
        return statements.size()-1;
    }
    public synchronized void take(int id){
        statements.set(id, true);
        this.notify();
    }
    public synchronized void release(int id) throws InterruptedException{
        if(id == 0){
            while(!isRepeat)
                wait();
            isRepeat = false;
        } else{
            while(!statements.get(id-1))
                wait();
            statements.set(id-1,false);
        }
        if(id == statements.size() - 1){
            if(isCountable){
                if(count-- > 1)
                    isRepeat = true;
            } else
                isRepeat = true;
            for(int i = 0; i < statements.size();i++)
                statements.set(i,false);
        }
        statements.set(id,false);

    }



}
