import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {

    private Todo todo = new Todo();
    private File data = new File("data.dat"); 

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }


    public void run()
    {
        if(!data.exists())
        {
            todo.run();
            save(data, todo);
        }
        else
        {
            try {
                FileInputStream fis = new FileInputStream(data);
                ObjectInputStream ois = new ObjectInputStream(fis);

                todo = (Todo) ois.readObject();
                ois.close();
                
            } 
            catch (ClassNotFoundException ex)
            {
                System.out.println();
                System.out.println("[error]: corrupted files");
                System.out.println();

            }
            catch (IOException e) {
                System.out.println();
                System.out.println("[error]: corrupted files");
                System.out.println();
            }
            todo.setQuit(false);
            todo.run();
            save(data, todo);

        }
    }


    private void save(File dest , Todo obj)
    {   
        try {
            FileOutputStream fos = new FileOutputStream(dest);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
        } catch (IOException ex) {
                System.out.println();
                System.out.println("[error]: corrupted files");
                System.out.println();
        }
    }

}
