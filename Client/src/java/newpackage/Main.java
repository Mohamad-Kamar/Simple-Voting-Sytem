/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;
import election.election;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        //Connection with AuthServer
        
        try{
            System.out.println("Hey client, Enter your id:");
            int id = scan.nextInt();
            newpackage.AuthServer_Service service = new newpackage.AuthServer_Service();
            newpackage.AuthServer port = service.getAuthServerPort();
            java.lang.String result = port.addID(id);
            String strId = result.split(" ")[1];
            
            System.out.println("Your You code is "+strId+ ". Please note that your information is saved in a file for further checking.\n" +
            "Good Luck for your candidate.");
            }
        catch (Exception ex) {
        }



        
        //Connection with Election Server
        try{
            Registry myreg= LocateRegistry.getRegistry("127.0.0.1",1999);
            election e = (election) myreg.lookup("Banana");
            
            
            System.out.println("Hello please enter your id and code: ");
            int id = scan.nextInt();
            String strId = scan.nextLine().trim();
            //Call Auth Server
            
            boolean found = false;
            File myObj = new File("D:\\University and Writing\\University\\LIU\\CSCI511 Distributed OS\\Project\\Voters.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String []data = myReader.nextLine().trim().split(" ");
                if(data[0].equals(""+id) && data[1].equals(strId)){
                    found = true;
                    break;
                }
            }
            myReader.close();
            if(!found){
                System.out.println("Your id does not exist in the voters list, please register");
                System.exit(0);
            }
            //if the id and code were found in the file
            System.out.println("Login Successful");
            System.out.println("Choose a number - 1 for voting, 2 for announcing the winner, 3 to end: ");
            int input = scan.nextInt();
            boolean announced = false;
            while(input!= 3){
                if(input == 1){
                    if(announced){
                        System.out.println("Sorry you cant vote twice!");
                    }
                    else{
                        System.out.println("Enter your preffered Candidate name: ");
                        String name = scan.next();
                        e.vote(name);
                        System.out.println("Congratulations, you voted for "+ name);
                        announced = true;           }
                }
                else if(input == 2){
                    System.out.println("The winner is ");
                    System.out.println(e.announceWinner().name);
                }
                else if(input == 3){
                    System.out.println("Goodbye");
                    break;
                }
                System.out.println("Choose a number - 1 for voting, 2 for announcing the winner, 3 to end: ");
                input = scan.nextInt();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
