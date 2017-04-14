/**
 * Created by dos on 25.10.2016.
 */
public class MainDog implements MainAnimal{
    String name;
    String Type;
    @Override
    public void setName(String Name) {
        name = Name;
    }

    @Override
    public void setType(String Type) {
        this.Type = Type;
    }
}
