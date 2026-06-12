package com.mycompany.messagemanagertest;

import org.junit.Test;
import static org.junit.Assert.*;

public class MessageManagerTest {

@Test
public void testLongestStoredMessageManagerExtraction() {
MessageManager testMgr = new MessageManager();
// Building test entries
testMgr.insertMessage("+27834557896", "Did you get the cake?", "Sent", "MSG01", "HASH1");
testMgr.insertMessage("+27838884567", "Where are you? You are late! I have asked you to be on time.", "Stored", "MSG02", "HASH2");
String expectedValue = "Where are you? You are late! I have asked you to be on time.";
assertEquals(expectedValue,testMgr.findLongestStoredMessage());       
}

@Test
public void testIDSearchHandling(){
MessageManager testMgr = new MessageManager();
testMgr.insertMessage("0838884567", "It is dinner time!", "Sent", "0838884567", "HASH4");
String result = testMgr.searchByID("0838884567");
// Verifying if the system properly captures the matching inner text flag
assertTrue(result.contains("It is dinner time!"));
}

@Test
public void testDataWipeByHash() {
MessageManager testMgr = new MessageManager();
testMgr.insertMessage("+27838884567", "Where are you?", "Stored", "MSG02" , "HASH2");
// Making sure it clears out index cleanly
boolean isDeleted = testMgr.deleteByHash("HASH2");
assertTrue(isDeleted);
assertEquals(0,testMgr.getCurrentSize());
}
