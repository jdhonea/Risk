package com.risktakers.Risk;

import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class playerNotificationTest {

	@Test
	public void notifyTest() {
		player testPlayer = new player();
		testPlayer.playerNo = 1;
		playerNotification playerNoteTest = new playerNotification();
		playerNoteTest.notify(1);
		assertEquals(playerNoteTest.hasChanged(),false);
	}
}	
