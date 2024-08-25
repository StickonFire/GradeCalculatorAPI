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

    void addAssignment(String title, int points, int maxPoint,boolean isGraded){
        this.assignments.put(title, new Assignment(points, maxPoint, title, isGraded));
    }

    void addAssignment(String title, int points, int maxPoint){
        this.assignments.put(title, new Assignment(points, maxPoint, title));
    }

    void addAssignment(String title, int maxPoint){
        this.assignments.put(title, new Assignment(maxPoint, title));
    }

    void addAssignment(String title){
        this.assignments.put(title, new Assignment(title));
    }

    boolean checkAssignmentExists(String title){
        return assignments.containsKey(title);
    }
    
    /**
     * Since t   his is an unexpected call, this will do nothing.
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

    Assignment(int points, int totalPoints, String name){
        this.name = name;
        this.points = points;
        this.totalPoints = totalPoints;
    }

    Assignment(int totalPoints, String name){
        this.totalPoints = totalPoints;
        this.name = name;
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