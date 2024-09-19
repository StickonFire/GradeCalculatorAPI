package GradeCalculatorAPI;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.HashMap;

public class GetGradeTest {

    private Assignment first;
    private Assignment second;
    private HashMap<String,Node> rootContents;
    private Root root;

    @Before
    public void setUp(){
        first = new Assignment(1,2,"first",true);
        second = new Assignment(3,5,"second",false);
        rootContents = new HashMap<String,Node>();
        root = new Root (rootContents);
        root.addAssignment(first);
        root.addAssignment(second);
    }
    //Test Assignment get grade
    @Test
    public void testAssignmentGetGradeIsGraded(){
        assertEquals("Make sure that a graded assignment correctly provides its grade as points/totalPoints",new Fraction(1,2),first.getGrade());
        assertEquals("Make sure that an ungraded assignment returns nothing for its grade",new Fraction(0,0),second.getGrade());
    }

    @Test
    public void testAssignmentGetGradeIsNotGraded(){
        assertEquals("Make sure that an ungraded assignment returns nothing for its grade",new Fraction(0,0),second.getGrade());
    }
    
    //Test Root get grade


}
