package election;
import candidate.candidate;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface election extends Remote{
    void vote(String name) throws RemoteException;
    candidate announceWinner() throws RemoteException;
}
