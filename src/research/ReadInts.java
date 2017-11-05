
package research;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadInts {
    
    Scanner z;
    public String data(File filename) throws FileNotFoundException {
        z=new Scanner(filename);
       
        
        String inter;
        String end = null;
        while(z.hasNext())
        {
            
            String key=z.next();
            
            if(key.startsWith("<Content>"))
            {
                inter=z.next();
                while(!inter.startsWith("<Date>"))
                {
                    end=end+" "+inter;
                    inter=z.next();
                }
            }
        }
        return end;
    }

}