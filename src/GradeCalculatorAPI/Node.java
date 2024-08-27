package src.GradeCalculatorAPI;

import java.util.Map;
import java.util.HashMap;

interface Node{
    void changePoints(int points);
    void changeMaxPoints(int maxPoints);
}

class Root implements Node{
    Map<String,Node> assignments;

    Root(Map<String, Node> assignments){
        this.assignments = assignments;
    }

    public void changePoints(int newPoints) throws IllegalStateException{
        throw new IllegalStateException("Root doesn't have points to change.");
    }

    void addAssignment(Assignment assignment){
        this.assignments.put(assignment.name,assignment);
    }

    boolean checkAssignmentExists(String title){
        return assignments.containsKey(title);
    }
    
    /**
     * Since this is an unexpected call, this will do nothing.
     */
    public void changeMaxPoints(int maxPoints) {
        return;
    }

    Node getAssignment(String title){
        return assignments.get(title);
    }

    void removeAssignment(String title){
        assignments.remove(title);
    }
}

/**
 * A class that generates assignments.
 */
class AssignmentFactory{

    public static Assignment makeAssignmentOnlyName(String title){
        return new Assignment(title);
    }

    public static Assignment makeAssignment(String title, int points, int totalPoints, boolean isGraded){
        return new Assignment(points,totalPoints,title,isGraded);
    }
}

class Assignment implements Node{
    String name;
    int points;
    int totalPoints;
    boolean isGraded;

    Assignment(int points, int totalPoints, String name, boolean isGraded){
        this.name = name;
        this.points = points;
        this.totalPoints = totalPoints;
        this.isGraded = isGraded;
    }

    Assignment(String name){
        this.name = name;
    }

    public void changePoints(int newPoints){
        this.points = newPoints;
    }

    public void changeMaxPoints(int maxPoints){
        this.totalPoints = maxPoints;
    }

    boolean isGraded(){
        return this.isGraded;
    }

    void changeGraded(boolean newGraded){
        this.isGraded = newGraded;
    }
}