package GradeCalculatorAPI;

import java.util.HashMap;

import static org.junit.Assert.*;
import org.junit.*;

public class GradeCalculatorAPITest {

    private Assignment first;
    private HashMap<String,Node> rootContents;
    private Root root;
    private GradeCalculatorAPI api;

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
        Assignment APIfirst = (Assignment)rootContents.get("first");
        assertEquals("Checks if addAssignment properly adds an assignment with only a title defined",second,APIsecond);
        
        assertEquals("Checks if addAssignment doesn't add too much or subtract from the assignments",rootContents.values().size(),2);
        assertEquals("Checks if addAssignment doesn't do anything to the already added assignment",first,APIfirst);
        
    }

    @Test
    public void testAddAssignmentAllNamedRoot(){
        Assignment second = new Assignment(1,2,"second",false);
        api.addAssignment("second",1,2,false);
        Assignment APIsecond = (Assignment)rootContents.get("second");
        assertEquals("Checks if addAssignment doesn't add too much or subtract from the assignment",rootContents.values().size(),3);
    }

    @Test
    public void testCheckAssignmentExistsRootTrue(){

    }

    @Test
    public void testCheckAssignmentExistsRootFalse(){

    }

    @Test
    public void testRootDeleteAssignmentExists(){

    }

    @Test
    public void testRootDeleteAssignmentNonexists(){

    }

    @Test
    public void testRootSetPointsExists(){

    }

    @Test
    public void testRootSetPointsNonexists(){

    }

    @Test
    public void testSetTotalPointsRootExists(){

    }

    @Test
    public void testSetTotalPointsRootNonExists(){

    }
}