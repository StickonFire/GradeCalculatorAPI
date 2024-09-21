package GradeCalculatorAPI;

import java.util.Map;
import java.util.HashMap;

enum GradingStyle{
    PointSystemTotalDefined, 
    PointSystemAddUp,
    WeightSystemEquals,
    WeightSystemAddUp,
    WeightSystemDefined
}

interface Node{
    void setPoints(int points);
    void setTotalPoints(int maxPoints);
    Fraction getGrade();
}

class Root implements Node{
    Map<String,Node> assignments;

    int totalPoints = 0;
    GradingStyle grader = GradingStyle.PointSystemAddUp;

    Root(Map<String, Node> assignments){
        this.assignments = assignments;
    }

    Root(Map<String, Node> assignments, GradingStyle grader){
        this.assignments = assignments;
        this.grader = grader;
    }


    void addAssignment(Assignment assignment){
        this.assignments.put(assignment.name,assignment);
    }

    boolean checkAssignmentExists(String title){
        return assignments.containsKey(title);
    }

    public void setPoints(int newPoints) throws IllegalStateException{
        throw new IllegalStateException("Root doesn't have points to change.");
    }

    public void setGradingStyle(GradingStyle grader){
        this.grader = grader;
    }

    public void setTotalPoints(int maxPoints) {
        this.totalPoints = maxPoints;
    }

    Node getAssignment(String title){
        return assignments.get(title);
    }

    void removeAssignment(String title){
        assignments.remove(title);
    }

    public Fraction getGrade(){
        Fraction result = new Fraction(0,0);
        switch(grader){
            case PointSystemAddUp:
                for(Node n : assignments.values()){
                    result.addToBoth(n.getGrade());
                }
                break;
            case PointSystemTotalDefined:
                result.setDenominator(this.totalPoints);
                for(Node n : assignments.values()){
                    result.addToNumerator(n.getGrade().getNumerator());
                }
                break;
            default:
                throw new IllegalStateException();
        }
        return result;
    }
    
}

/**
 * A class that generates assignments.
 */
class AssignmentFactory{

    public static Assignment makeAssignmentOnlyName(String title){
        return new Assignment(title);
    }

    public static Assignment makeAssignment(String title, int points, int totalPoints, boolean countGrade){
        return new Assignment(points,totalPoints,title,countGrade);
    }
}

class RootFactory{
    public static Root makeRoot(){
        return new Root(new HashMap<String,Node>());
    }
}

class Assignment implements Node{
    String name;
    int points = 0;
    int totalPoints = 0;
    boolean countGrade = false;

    Assignment(int points, int totalPoints, String name, boolean countGrade){
        this.name = name;
        this.points = points;
        this.totalPoints = totalPoints;
        this.countGrade = countGrade;
    }

    Assignment(String name){
        this.name = name;
    }

    public void setPoints(int newPoints){
        this.points = newPoints;
    }

    public void setTotalPoints(int maxPoints){
        this.totalPoints = maxPoints;
    }

    boolean countGrade(){
        return this.countGrade;
    }

    void setCountGrade(boolean newGraded){
        this.countGrade = newGraded;
    }

    @Override
    public boolean equals(Object argument){
        Assignment other;
        if(argument instanceof Assignment)
            other = (Assignment) argument;
        else
            return false;
        return this.name.equals(other.name) && this.points == other.points && 
          this.totalPoints == other.totalPoints && this.countGrade == other.countGrade;
    }

    public Fraction getGrade(){
        if(countGrade)
            return new Fraction(this.points,this.totalPoints);
        return new Fraction(0,0);
    }
}