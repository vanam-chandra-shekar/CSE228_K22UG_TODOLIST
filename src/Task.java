import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable{
    public int id;
    public String mssg;
    public LocalDate creationDate;
    public boolean done;

    Task(int id , String message , LocalDate creationDate , boolean done )
    {
        this.id = id;
        this.mssg = message;
        this.creationDate = creationDate;
        this.done = done;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", mssg=" + mssg + ", creationDate=" + creationDate + ", done=" + done + "]";
    }
    
}
