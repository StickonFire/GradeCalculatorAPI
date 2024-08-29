package src.GradeCalculatorAPI;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.HashMap;

public class NodeTest {
    @Test
    public void testAssignmentSetPoints(){
        //Basically makes sure that assignment can change points just fine.
        Assignment test = new Assignment("test");
        test.setPoints(1);
        assertEquals("Ensures that setPoints properly sets the assignment's points to 1",test.points,1);
    }

    @Test
    public void testAssignmentSetTotalPoints(){
        Assignment test = new Assignment("test");
        test.setTotalPoints(1);
        assertEquals("Ensures that setTotalPoints properly sets the assignmnet's totalPoints to 1", test.totalPoints,1);
    }

    @Test
    public void testAssignmentIsGraded(){
        Assignment test = new Assignment("test");
        test.isGraded = true;
        assertTrue("Checks if isGraded properly returns true",test.isGraded());
        test.isGraded = false;
        assertFalse("Checks if isGraded properly returns false",test.isGraded());
    }

    @Test
    public void testAssignmentSetIsGraded(){
        Assignment test = new Assignment("test");
        test.setIsGraded(true);
        assertTrue("Checks if setIsgraded properly answers true",test.isGraded);
        test.setIsGraded(false);
        assertFalse("Checks if setIsGraded properly sets isGraded to false",test.isGraded);

    }

    @Test
    public void testRootAddAssignment(){
        HashMap<String,Node> result = new HashMap<>();
        Root test = new Root(result);

        Assignment value = new Assignment("value");
        
        test.addAssignment(value);

        Assignment first = (Assignment)result.get("value");

        assertTrue("Make sure that addAssignment does place the assignment inside the root.",value.equals(first));
    }

    @Test
    public void testRootcheckAssignmentExistsAtRoot(){
        HashMap<String,Node> result = new HashMap<>();
        Root test = new Root(result);

        Assignment value = new Assignment("value");

        test.addAssignment(value);

        assertTrue("Make sure that checkAssignmentExists works at the Root level",test.checkAssignmentExists("value"));
    }

    @Test 
    public void testRootGetAssignmentRootLevel(){
        HashMap<String,Node> result = new HashMap<>();
        Root test = new Root(result);

        Assignment value = new Assignment("value");

        test.addAssignment(value);

        assertTrue("Make sure that checkAssignmentExists works at the Root level",value.equals(test.getAssignment("value")));
    }

    @Test
    public void testRootRemoveAssignmentRootLevel(){
        HashMap<String,Node> result = new HashMap<>();
        Root test = new Root(result);

        Assignment value = new Assignment("value");

        test.addAssignment(value);

        test.removeAssignment("value");


        assertFalse("Make sure that checkAssignmentExists works at the Root level",result.containsValue(value));
    }


}
