import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Project
{
    private final String name;
    private final List<Task> tasks;
    //private int time = 0;
    boolean[] ids;


    public Project(String name, List<Task> tasks)
    {
        this.name = name;
        this.tasks = tasks;
        ids = new boolean[tasks.size()];
    }


    public int[] getEarliestSchedule()
    {
        int N = tasks.size();
        int[] schedule = new int[N];
        boolean[] visited = new boolean[N];
        schedule[0] = tasks.get(0).getDuration();

        topSort(N - 1, schedule, visited);

        return schedule;
    }


    public void topSort(int N, int[] schedule, boolean[] visited)
    {
        while(!visited[N - 1])
        {
            for(int j = 0; j < tasks.size(); j++)
            {
                Task task = tasks.get(j);

                if(visited[task.getTaskID()])
                    continue;

                boolean flag = true;

                for(int i = 0; i < task.getDependencies().size(); i++)
                {
                    int elt = task.getDependencies().get(i);
                    if (!visited[elt])
                    {
                        flag = false;
                        break;
                    }
                }

                if(flag)
                {
                    int time = getTaskDuration(task.getTaskID(), schedule);
                    schedule[task.getTaskID()] = time;
                    visited[task.getTaskID()] = true;
                    j = 0;
                }
            }
        }

        for(int i = 0; i < schedule.length; i++)
        {
            schedule[i] -= tasks.get(i).getDuration();
        }
    }


    public int getTaskDuration(int id, int[] schedule)
    {
        Task task = getTsk(id);
        int dur = 0;

        for(int ID : task.getDependencies())
        {
            if(schedule[ID] > dur)
                dur = schedule[ID];
        }

        return dur + task.getDuration();
    }


    public Task getTsk(int id)
    {
        for(Task task : tasks)
        {
            if(task.getTaskID() == id)
            {
                return task;
            }
        }

        return null;
    }


    public int getProjectDuration()
    {
        int projectDuration = 0;

        int[] schedule = getEarliestSchedule();

        projectDuration = tasks.get(schedule.length - 1).getDuration() + schedule[schedule.length - 1];

        return projectDuration;
    }

    public static void printlnDash(int limit, char symbol)
    {
        for (int i = 0; i < limit; i++) System.out.print(symbol);
        System.out.println();
    }


    public void printSchedule(int[] schedule)
    {
        int limit = 65;
        char symbol = '-';
        printlnDash(limit, symbol);
        System.out.println(String.format("Project name: %s", name));
        printlnDash(limit, symbol);

        // Print header
        System.out.println(String.format("%-10s%-45s%-7s%-5s", "Task ID", "Description", "Start", "End"));
        printlnDash(limit, symbol);

        for (int i = 0; i < schedule.length; i++)
        {
            Task t = tasks.get(i);
            System.out.println(String.format("%-10d%-45s%-7d%-5d", i, t.getDescription(), schedule[i], schedule[i] + t.getDuration()));
        }
        printlnDash(limit, symbol);
        System.out.println(String.format("Project will be completed in %d days.", tasks.get(schedule.length - 1).getDuration() + schedule[schedule.length - 1]));
        printlnDash(limit, symbol);
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;

        int equal = 0;

        for (Task otherTask : ((Project) o).tasks)
        {
            if (tasks.stream().anyMatch(t -> t.equals(otherTask)))
            {
                equal++;
            }
        }

        return name.equals(project.name) && equal == tasks.size();
    }


    public List<Task> getTasks()
    {
        return tasks;
    }

}
