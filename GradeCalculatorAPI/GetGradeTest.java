package GradeCalculatorAPI;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.HashMap;

public class GetGradeTest {

    private Assignment first;
    private Assignment second;
    private Assignment third;
    private HashMap<String,Node> rootContents;
    private Root root;

    @Before
    public void setUp(){
        first = new Assignment(1,2,"first",true);
        second = new Assignment(3,5,"second",false);
        third = new Assignment(2,2,"third",true);
        rootContents = new HashMap<String,Node>();
        root = new Root (rootContents);
        root.addAssignment(first);
        root.addAssignment(second);
        root.addAssignment(third);
        root.setGradingStyle(GradingStyle.PointSystemAddUp);
    }
    //Test Assignment get grade
    @Test
    public void testAssignmentGetGradeignoreGrade(){
        assertEquals("Make sure that a graded assignment correctly provides its grade as points/totalPoints",new Fraction(1,2),first.getGrade());
        assertEquals("Make sure that an ungraded assignment returns nothing for its grade",new Fraction(0,0),second.getGrade());
    }

    @Test
    public void testAssignmentGetGradeIsNotGraded(){
        assertEquals("Make sure that an ungraded assignment returns nothing for its grade",new Fraction(0,0),second.getGrade());
    }
    
    //Test Root get grade
    @Test
    public void testRootGetGrade1Ignored3TotalPointSystemAddUp(){
        assertEquals("Make sure that the root correctly ignores 1, and successfully adds the two others",new Fraction(3,4),root.getGrade());
    }

    @Test
    public void testRootGetGrade1Ignored3TotalPointSystemGiven(){
        root.setGradingStyle(GradingStyle.PointSystemTotalDefined);
        root.totalPoints = 15;
        assertEquals("Make sure that the root correctly ignores 1, and successfully adds the two others",new Fraction(3,15),root.getGrade());
    }

    @Test
    public void testRootGetGradeEmptyPointSytemAddUp(){
        Root emptyRoot = new Root(new HashMap<String,Node>());

        boolean noError = true;
        Fraction result = null;

        try{
            result = emptyRoot.getGrade();
        } catch (Exception e){
            noError = false;
        }

        assertTrue("Make sure that no error is triggered",noError);
        assertEquals("Make sure that an emptyRoot(with added up totalPoints) provides the correct answer.",new Fraction(0,0),result);
    }
    
    @Test
    public void testRootGetEmptyPointSystemGiven(){
        Root emptyRoot = new Root(new HashMap<String,Node>(),GradingStyle.PointSystemTotalDefined);
        emptyRoot.setTotalPoints(15);

        boolean noError = true;
        Fraction result = null;

        try{
            result = emptyRoot.getGrade();
        } catch(Exception e){
            noError = false;
        }

        assertTrue("Make sure that no error is triggered",noError);
        assertEquals("Make sure that an emptyRoot(with defined totalPoints) provides the correct answer.",new Fraction(0,15),result);
    }

    //GradeCalculatorAPI test getGrade
    @Test 
    public void testGradeCalculatorAPIGetGrade(){
        Root value = new MockRoot(new Fraction(1,2));
        GradeCalculatorAPI api = new GradeCalculatorAPI(value);

        assertEquals("Makes sure that GradeCalculatorAPI does run the root's getGrade to return the grade.",new Fraction(1,2),api.getGrade());
    }
}

class MockRoot extends Root{

    private Fraction score;

    MockRoot(Fraction score){
        super(null);

        this.score = score;
    }

    @Override
    public Fraction getGrade(){
        return this.score;
    }
}