import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;



public class Todo implements Serializable {
    private int currentid = 1;
    private ArrayList<Task> taskslList = new ArrayList<Task>();

    private boolean quit = false;

    public void setQuit(boolean quit) {
        this.quit = quit;
    }

    static Scanner sc = new Scanner(System.in);


    public void run(){
        
        do{
            System.out.println("----------MENU----------");
            System.out.println("1. List all Tasks");
            System.out.println("2. Add new Task");
            System.out.println("3. Mark Task done");                     
            System.out.println("4. Edit Task");
            System.out.println("5. Exit");

            System.out.print("> ");

            int option = sc.nextInt();
            sc.nextLine();
            parseOption(option);

        }
        while(!quit);

        sc.close();
        
    }

    private void parseOption(int option)
    {
        switch (option) {
            case 1:
                listTask();
                break;
            case 2:
                addTask();
                break;
            case 3:
                markingDone();
                break;
            case 4:
                editTask();
            case 5:
                quit = true;
                break;
            default:
                System.out.println("[message]: Select valid option");
                System.out.println();
                break;
        }
    }

    private void addTask()
    {
        System.out.print("Enter task message : ");
        String messg = sc.nextLine();
        Task temp = new Task(currentid,messg,LocalDate.now(),false);
        taskslList.add(temp);
        System.out.println("[message]: Task made Sucessfully ");
        System.out.println();
        currentid++;
    }

    private void listTask()
    {
        if(taskslList.size()>0)
        {
            for(Task i : taskslList)
            {
                System.out.println(i);
            }
        }
        else
        {
            System.out.println("[message]: No Task Left");
            System.out.println();
        }

    }

    private void markingDone()
    {
        if(taskslList.size()>0)
        {
            System.out.println();
            System.out.print("Enter the id of Task : ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("[message]: if Marked done task will be removed");
            taskslList.remove(id-1);
            System.out.println(String.format("[message]: Id no:%d Task marked done", id));
            System.out.println();
        }
        else
        {
            System.out.println("[message]: No Task Left");
            System.out.println();
        }
    }


    private void editTask()
    {
        if(taskslList.size()>0)
        {
            System.out.println();
            System.out.print("Enter the id of Task : ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println(String.format("[message]: Id no:%d Task marked done", id));
            System.out.println();
        }
        else
        {
            System.out.println("[message]: No Task Left");
            System.out.println();
        }
    }

}
