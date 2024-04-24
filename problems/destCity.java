import java.util.HashSet;
import java.util.List;

public class destCity {
    public String destCity(List<List<String>> paths) {
        HashSet<String> pathSet = new HashSet<String>();
        for(List<String> p : paths){
            pathSet.add(p.get(0));
        }
    
          for(List<String> p : paths){
           if(pathSet.add(p.get(1))){
               return p.get(1);
           }
        }
    
        return null;
    
    }
}
