import java.util.PriorityQueue;

public class TaskManager {
    private PriorityQueue<Task> tasks;

    public TaskManager(){
        tasks = new PriorityQueue<>(new PriorityTaskComparator());
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public void viewTasks(){
        PriorityQueue<Task> cloneTasks = new PriorityQueue<>(tasks);
        while (!cloneTasks.isEmpty()) {
            Task task = cloneTasks.poll();
            System.out.println("Task Name: " + task.getTaskName());
            System.out.println("Time: " + task.getTime());
            System.out.println("Priority: " + task.getPriority());
            System.out.println();
        }
    }
}
