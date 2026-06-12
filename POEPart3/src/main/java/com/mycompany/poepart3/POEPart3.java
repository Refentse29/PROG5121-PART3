package com.mycompany.poepart3;

import java.util.Locale;

public class MessageManager {

    public static void main(String[] args) {
        
// Setting a safe fixed minimum capacity for the parallel arrays
private final int MAX_LIMIT = 30;

// Core parallel tracking arrays 
private String[] recipients = new String[MAX_LIMIT];
private String[] messageTexts = new String[MAX_LIMIT];
private String[] messageFlags = new String[MAX_LIMIT];
// "Sent", "Stored", "Disregard"
private String[] messageIDs = new String[MAX_LIMIT];
private String[] messageHashes = new String[MAX_LIMIT];

// Counter to track how many slots are actually filled with data
private int currentSize = 0;

// Method to add a single message row into the parallel system
public void insertMessage(String recipient, String text, String flag, String id, String hash) {
    if (currentSize < MAX_LIMIT) {
recipients[currentSize] = recipient;
messageTexts[currentSize] = text;
messageFlags[currentSize] = flag;
messageIDs[currentSize] = id;
messageHashes[currentSize] = hash; 
currentSize++;
    }
}

// FEATURE A: Display sender/ recipient for all stored messages
public void printStoredSendersAndRecipients() {
System.out.println("LIST OF STORED MESSAGE CONTACTS");
boolean foundAny = false;
for (int i = 0; i < currentSize; i++) {
if ("Stored".equalsIgnoreCase(messageFlags[i])) {
System.out.println("ID: " + messageIDs[i] + " | Contact: " + recipients[i]);
foundAny = true;
     }    
}
if (!foundAny) {
System.out.println("No stored messages found in the database.");
    }
}

// FEATURE B: Find and return the single longest stored message text
public String findLongestStoredMessage() {
String longestText = "";
for (int i = 0; i < currentSize; i++) {
if ("Stored".equalsIgnoreCase(messageFlags[i]) && messageTexts[i] != null) {
if (messageTexts[i].length() > longestText.length()) {
longestText = messageText[i] ;   
      }
   }
}
return longestText;
}

// FEATURE C: Searching for a message ID and returning its details
public String searchByID(String targetID) {
for (int i = 0; i < currentSize; i++) { 
if (messageIDs[i] !=null && messageIDs[i].equalsIgnoreCase(targetID)) {
    return "Recipient: " + recipients[i] + "Message: " + ,messageTexts[i] + "";
   }
} 
   return "Message ID not found.";
}

// FEATURE D: Searching all messages (Sent or Stored) for a specific recipient
public void searchByRecipient(String targetRecipient) {
System.out.println("Searching records for: " + targetRecipient);
boolean matched = false;
for (int i = 0; i < currentSize; i++) {
if (recipients[i] ! = null && recipients[i].equalsIgnoreCase(targetRecipient)) {
    
// Filters to return only Sent or Stored records per requirements
if ("Sent".equalsIgnoreCase(messageFlags[i]) || "Stored".equalsIgnoreCase(messageFlags[i]) {
System.out.println("[" + messageFlags[i] + "]" + messageTexts[i]);
matched = true;
     }    
  }
}   
if (!matched) {
System.out.println("No matching records found for that recipient.");
   }
}

// FEATURE E: Delete a specific message by tracking down its unique hash
public boolean deleteByHash(String targetHash) {
for (int i = 0; i < currentSize; i++) {
if (messageHashes[i] ! = null && messageHashes[i].equals(targetHash)) {
String deletedText = messageTexts[i];

//Shifting elements left to close up the gap in the parallel array layout
for (int j = i; j < currentSize - 1; j++) {
recipients[j] = recipients[j + 1];
messageTexts[j] = messageTexts[j + 1];
messageFlags[j] = messageFlags[j + 1];
messageIDs[j] = messageIDs[j + 1];
messageHashes[j] messageHashes[j + 1];
}
currentSize--;
//Reducing size since one row is removed
System.out.println("Message: " + deletedText + "successfully deleted.");
   return true;
   }
}
   return false;
}

// FEATURE F: Printing a detailed layout report of all current active records
public void printFullReport() {
System.out.println("SYSTEM TASK REPORT");
for (int i = 0; i < currentSize; i++) {
System.out.println("Hash: " + messageHashes[i] + " | To: " + recipients[i] + " | Status: [" + messageFlags[i] + "]");
System.out.println("Content: " + messageTexts[i]);
  }
}

// Helper method used by JUnit tests to verify counts
public int getCurrentSize() {
    return this.currentSize;
  }
}
    
        
    
       
