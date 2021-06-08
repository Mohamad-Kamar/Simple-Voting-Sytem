
package elecserver;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import electionImp.electionImp;
import java.rmi.AlreadyBoundException;
public class ElecServer {
    public static void main(String[] args) throws AlreadyBoundException {
        try{
            Registry reg = LocateRegistry.createRegistry(1999);
            electionImp e = new electionImp();
            reg.bind("Banana", e);
            System.out.println("Election Server is Ready");
        }
        catch(RemoteException e){
            System.out.println(e);
        }
    }
}
