package candidate;

import java.io.*;

public class candidate implements java.io.Serializable{
    public String name;
    public int votes;
    
    public int getNumberOfVotes(){
        return this.votes;
    }
    
    public void increaseVotes(){
        this.votes++;
    }
}
