/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "AuthServer")
public class AuthServer {

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "addID")
    public String addId(@WebParam(name = "id") int id) throws IOException {
        String newID = id + "-" + (int)(Math.random()*100 + 1);
        String everything =  id + " " + newID;
        
        FileWriter f = new FileWriter("D:\\University and Writing\\University\\LIU\\CSCI511 Distributed OS\\Project\\Voters.txt", true);
        //Set true for append mode
        BufferedWriter writer = new BufferedWriter(f);    
        writer.write("\n"+everything);
        writer.close();
        return everything;
    }
}
