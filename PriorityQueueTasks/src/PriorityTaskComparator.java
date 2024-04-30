import java.util.Comparator;

public class PriorityTaskComparator implements Comparator<Task> {

    @Override
    public int compare(Task task1, Task task2){
        return task1.getPriority() - task2.getPriority();
    }

}
