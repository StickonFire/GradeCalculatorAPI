package GradeCalculatorAPI;

public class GradeCalculatorAPI {
    Root assignments;

    GradeCalculatorAPI(Root assignments){
        this.assignments = assignments;
    }

    void addAssignment(String name,int points, int totalPoints, boolean ignoreGrade){
        assignments.addAssignment(AssignmentFactory.makeAssignment(name, points, totalPoints, ignoreGrade));
    }

    void addAssignment(String name){
        assignments.addAssignment(AssignmentFactory.makeAssignmentOnlyName(name));
    }
 
    boolean checkAssignmentExists(String title){
        return assignments.checkAssignmentExists(title);
    }

    void deleteAssignment(String title){
        assignments.removeAssignment(title);
    }

    
    void setGradingStyle(GradingStyle gradingStyle){
        assignments.setGradingStyle(gradingStyle);
    }

    void setPoints(String title, int newPoints){
        Node target = assignments.getAssignment(title);
        if(target != null && target instanceof Assignment)
            target.setPoints(newPoints);
    }

    void setTotalPoints(String title, int totalPoints){
        Node target = assignments.getAssignment(title);
        if(target != null && target instanceof Assignment)
            target.setTotalPoints(totalPoints);
    }

    Fraction getGrade(){
        return assignments.getGrade();
    }

}
