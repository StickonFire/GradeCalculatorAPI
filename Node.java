import java.util.Map;

interface Node{

}

class Root implements Node{
    Map<String,Node> assignments;

    void addAssignment(String title, int points, int maxPoint){

    }

    void addAssignment(String title){

    }

    boolean checkAssignmentExists(String title){
        return false;
    }

    Node getAssignment(){
        return null;
    }

    void removeAssignment(String title){

    }
}

class Assignment implements Node{
    String name;
    int score;
    int totalPoints;
    boolean isGraded;

    Assignment(int score, int totalPoints, String name){
        this.name = name;
        this.score = score;
        this.totalPoints = totalPoints;
    }

    Assignment(int totalPoints, String name){
        this.totalPoints = totalPoints;
        this.name = name;
    }

    Assignment(String name){
        this.name = name;
    }

    void changePoints(int newPoints){

    }

    void changeMaxPoints(int maxPoints){

    }

    boolean isGraded(){
        return false;
    }

    void changeGraded(boolean newGraded){
        
    }
}