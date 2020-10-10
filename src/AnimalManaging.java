import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

public class AnimalManaging<T>{
    private List animals;

    public AnimalManaging(){
        this.animals=new ArrayList<T>();
    }

    public void addAnimal(T t){
        animals.add(t);
    }

    public void removeAnimal(String name){
        for(int i=0;i<animals.size();i++){
            if(((Animal)animals.get(i)).getName().equals(name)){
                animals.remove(animals.get(i));
                return;
            }
        }
    }

    public void reviseAnimal(String name,T replacement){
       for(int i=0;i<animals.size();i++) {
           if (((Animal)animals.get(i)).getName().equals(name)){
               animals.set(i,replacement);
               return;
           }
       }
    }

    public void sortAge(){
        for(int i=0;i<animals.size()-1;i++){
            for(int j=0;j<animals.size()-i-1;j++){
                if(((Animal)animals.get(j)).getAge()>((Animal)animals.get(j+1)).getAge()){
                    T temp=(T)animals.get(j);
                    animals.set(j,(T)animals.get(j+1));
                    animals.set(j+1,temp);
                }
            }
        }
    }

    public ListIterator<T> getIterator(){
        return animals.listIterator();
    }

    public int length(){
        return this.animals.size();
    }

    public T get(int index){
        return (T)animals.get(index);
    }
}