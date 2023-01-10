package practice.arraytolist;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import practice.arraytolist.Action;

public class ArrayToListConversionTesting {
	
	@Test
	public void givenMultiActionString_whenCreatingActionList_thenListCreated() {
		String actionString = "DEPLOY,MAP,ENABLE";
		
        List<Action> actionList = new ArrayList<>();
        Arrays.stream(actionString.split(",")).forEach(action -> actionList.add(Action.valueOf(action.toUpperCase())));
        
        Assertions.assertEquals(3, actionList.size());
	}
	
	@Test
	public void givenActionString_whenCreatingActionList_thenListCreated() {
		String actionString = "DIsABLE";
		
        List<Action> actionList = new ArrayList<>();
        Arrays.stream(actionString.split(",")).forEach(action -> actionList.add(Action.valueOf(action.toUpperCase())));
        
        Assertions.assertEquals(1, actionList.size());
        Assertions.assertEquals("DISABLE", actionList.get(0).getAction());
	}
	
	@Test
	public void givenInvalidActionString_whenCreatingActionList_thenThrowException() {
		String actionString = "rohit,DISable";
        List<Action> actionList = new ArrayList<>();
        
        assertThrows(Exception.class, () ->  Arrays.stream(actionString.split(",")).forEach(action -> actionList.add(Action.valueOf(action.toUpperCase()))));
	}
	

}
