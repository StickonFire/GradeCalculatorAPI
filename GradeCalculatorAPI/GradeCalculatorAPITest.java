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
        
    }

    @Test
    public void testAddAssignmentAllNamedRoot(){

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