import Controller.StudentController;
import Model.Student;
import View.StudentView;

public class Main {
    public static void main(String[] args) {
        StudentView view = new StudentView();
        Student model = new Student();
        StudentController controller = new StudentController(model, view);
    }
}