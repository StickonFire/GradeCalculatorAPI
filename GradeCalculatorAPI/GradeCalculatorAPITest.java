package GradeCalculatorAPI;

import java.util.HashMap;

import static org.junit.Assert.*;
import org.junit.*;

public class GradeCalculatorAPITest {

    private Assignment first;
    private HashMap<String,Node> rootContents;
    private Root root;
    private GradeCalculatorAPI api;

    /**
     * Checks if a tested method has not affected the Assignments that it shouldn't.
     */
    public void checkOtherAssignmentsMaintained(String methodName, int expectedSize){
        Assignment APIfirst = (Assignment)rootContents.get("first");
        assertEquals("Checks if " + methodName + " has the right amount of assignments after.",rootContents.values().size(),expectedSize);
        assertEquals("Checks if " + methodName + " doesn't do anything to the already added assignment.",first,APIfirst);
    }

    @Before
    public void setUpEach(){
        first = new Assignment("first");
        rootContents = new HashMap<String,Node>();
        rootContents.put("first",first);
        root = new Root(rootContents);
        api = new GradeCalculatorAPI(root);
    }

    @Test
    public void testAddAssignmentTitleOnlyRoot(){
        Assignment second = new Assignment("second");
        api.addAssignment("second");
        Assignment APIsecond = (Assignment)rootContents.get("second");
        
        assertEquals("Checks if addAssignment properly adds an assignment with only a title defined",second,APIsecond);
        
        checkOtherAssignmentsMaintained("addAssignment(Title)",2);
    }

    @Test
    public void testAddAssignmentAllNamedRoot(){
        Assignment second = new Assignment(1,2,"second",false);
        api.addAssignment("second",1,2,false);
        Assignment APIsecond = (Assignment)rootContents.get("second");

        assertEquals("Check if addAssignment properly adds an assignment when using addAssignment with points set.",second,APIsecond);
        
        checkOtherAssignmentsMaintained("addAssignment(Title,points,totalPoints)",2);
    }

    @Test
    public void testCheckAssignmentExistsRootTrue(){
        assertTrue("Checks if checkAssignmentExists properly identifies that the given assignment exists.",api.checkAssignmentExists("first"));
        checkOtherAssignmentsMaintained("checkAssignmentExists",1);
    }

    @Test
    public void testCheckAssignmentExistsRootFalse(){
        assertFalse("Checks if checkAssignmentExists properly identifies a given assignment doesn't exist.",api.checkAssignmentExists("second"));
        checkOtherAssignmentsMaintained("checkAssignmentsExists(false)",1);
    }

    @Test
    public void testRootDeleteAssignmentExists(){
        api.deleteAssignment("first");
        assertEquals("Checks if deleteAssignment properly removes the only assignment inside.",rootContents.values().size(),0);
    }

    @Test
    public void testRootDeleteAssignmentNonexists(){
        boolean flag = true;
        try{
            api.deleteAssignment("second");
        }
        catch(Exception e){
            flag = false;
        }
        assertTrue("If this triggers, then deleteAssignment caused an error",flag);
        checkOtherAssignmentsMaintained("deleteAssignment",1);
    }

    @Test
    public void testRootSetPointsExists(){
        api.setPoints("first",3);
        Assignment result = (Assignment)rootContents.get("first");
        
        //Check if the assignment remains the same other than the points
        Assignment toCheck = new Assignment(3,0,"first",false);
        assertEquals("Makes sure that setPoints correctly sets the Assignment points to 3 and only that",toCheck,result);

        //Makes sure that no other changes are made.
        assertEquals("Makes sure that setPoints doesn't change the number of assignments.",1,rootContents.values().size());
    }

    @Test
    public void testRootSetPointsNonexists(){
        boolean triggered = false;
        try{
            api.setPoints("second",3);
        }
        catch(Exception e){
            triggered = true;
        }
        
        //Make sure that nothing happened.
        assertFalse("Make sure no error happened.",triggered);
        checkOtherAssignmentsMaintained("setPoints(nonexistant call)",1);
    }

    @Test
    public void testSetTotalPointsRootExists(){
        api.setTotalPoints("first",3);
        Assignment result = (Assignment)rootContents.get("first");
        
        //Check if the assignment remains the same other than the points
        Assignment toCheck = new Assignment(0,3,"first",false);
        assertEquals("Makes sure that setTotalPoints correctly sets the Assignment points to 3 and only that",toCheck,result);

        //Makes sure that no other changes are made.
        assertEquals("Makes sure that setTotalPoints doesn't change the number of assignments.",1,rootContents.values().size());
    }

    @Test
    public void testSetTotalPointsRootNonExists(){
        boolean noError = true;
        try{
            api.setPoints("second",4);
        }
        catch(Exception e){
            noError = false;
        }

        assertTrue("Make sure no error happened.",noError);
        checkOtherAssignmentsMaintained("setTotalPoints(nonexistant call)",1);
    }

    @Test
    public void testSetGradingStyleRoot(){

        assertEquals("Make sure that default for now is correct.",GradingStyle.PointSystemAddUp,root.grader);

        api.setGradingStyle(GradingStyle.PointSystemTotalDefined);

        assertEquals("Make sure that the grading style properly sets to PointSysTotalDefined",GradingStyle.PointSystemTotalDefined,root.grader);

        api.setGradingStyle(GradingStyle.PointSystemAddUp);

        assertEquals("Make sure that the grading style properly sets to PointSysTotalDefined",GradingStyle.PointSystemAddUp,root.grader);

        boolean error = false;
        try{
            api.setGradingStyle(GradingStyle.PointSystemAddUp);
        }
        catch(Exception e){
            error = true;
        }
        assertFalse("Make sure no error happens when running setGradingStyle",error);
        assertEquals("Make sure nothing happens if it is set the same.",GradingStyle.PointSystemAddUp,root.grader);
        
    }
}