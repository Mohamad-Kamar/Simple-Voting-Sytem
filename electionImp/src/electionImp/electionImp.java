
package electionImp;
import candidate.candidate;
import election.election;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class electionImp extends UnicastRemoteObject  implements election{
    public ArrayList <candidate> cands;
        
    public electionImp() throws RemoteException{
        this.cands = new ArrayList<candidate>();
        
    }
    
    @Override
    public void vote(String name){
        for(candidate c: this.cands){
            if(c.name.equals(name)){
                c.increaseVotes();
                return;
            }
        }
        candidate c = new candidate();
        c.name = name;
        c.votes = 0;
        this.cands.add(c);


        return;
    }

    @Override
    public candidate announceWinner(){
        int maxVoter = 0;
        candidate winner = null;
        for(candidate c: this.cands){
            if(c.votes>=maxVoter){
                maxVoter = c.votes;
                winner = c;
            }
        }
        
        System.out.println("==================");
        for(candidate l: this.cands){
            System.out.println(l.name);
        }
        System.out.println("==================");
        return winner;
    }
}
