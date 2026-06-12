package com.mycompany.mainapp;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

MessageManager manager = new MessageManager();
Scanner input = new Scanner(System.in);

// Populating the system
manager.insertMessage("+27834557896", "Did you get the cake?", "Sent", "MSGO1", "HASH1");
manager.insertMessage("+27838884567", "Where  are you? You are late! I have asked you to be on time.", "Stored", "MSG02", "HASH2");
manager.insertMessage("+27834484567", "Yohoooo, I am at your gate.", "Disregard", "MSG03", "HASH3");
manager.insertMessage("0838884567", "It is dinner time !", "Sent", "0838884567", "HASH4");
// Using target ID spec
manager.insertMessage("+27838884567", "Ok, I am leaving without you.", "Stored", "MSG05", "HASH5");

int selection = 0
while (selection != 5) {
System.out.println("MAIN APPLICATION MENU");
System.out.println("1.Send a New Message");
System.out.println("2.Review Disregarded Logs");
System.out.println("3.Manage Draft System");
System.out.println("4.Stored Messages Sub-Report Menu");
System.out.println("5. Exit Project");
System.out.print("Please select an option: ");
selection = input.nextInt();
input.nextInt();
//Clear scanner buffer

if (selection ==4) {
// Launching the nested submenu
System.out.println("SUB-MENU: STORED MESSAGES OPTION");
System.out.println("a.Display Senders and Recipients of Stored Items");
System.out.println("b.Identify Longest Stored Message");
System.out.println("c.Look up message content by ID");
System.out.println("d.Extract messages for a chosen Recipient");
System.out.println("e.Discard/Delete a message by Hash input");
System.out.println("f.Generate Full System Layout Report");
System.out.print("Choose operation flag (a-f): ");
String action = input.nextLine().trim().toLoweerCase();

switch (action) {
case "a": manager.printStoredSsendersAndRecipients();
break;
case "b": System.out.println("Longest Entry: " + manager.findLongestStoredMessage());
break;
case "c": System.out.print("Enter specific Message ID string to search: ");
String searchID = input.nextLine();
System.out.println(manager.searchByID(searchID));
break;
case "d": System.out.print("Provide the target phone number/recipient: ");
String targetPhone = input.nextLine();
manager.searchByRecipient(targetPhone);
break;
case "e": System.out.print("Enter Hash String code to wipe: ");
String targetHash = input.nextLine();
manager.deleteByHash(targetHash);
break;
case "f": manager.printFullReport();
break;
default: System.out.println("Invalid operation token entered.");
       }
   }
}
System.out.println("Shutting down messaging interface tool.Goodbye!");
   }
}    
    
       
