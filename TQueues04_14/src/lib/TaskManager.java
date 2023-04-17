package lib;

public class TaskManager{
    private TQueue<String> taskQueue;
    public TaskManager() { taskQueue = new TQueue<String>();}

    public boolean addTask(String task){
        return taskQueue.put(task);
    }

    public String toString(){
        StringBuilder str = new StringBuilder(String.format("Zadania do realizacjii:%n"));
        int no=1;
        for(String task:taskQueue){
            str.append(String.format("%d.%s%n",no,task));
            no++;
        }
        return str.toString();
    }

    public String deleteTask(){
        return taskQueue.get();
    }
}