import java.util.Comparator;

public class CompAge implements Comparator<NonMilkable> {

    @Override
    public int compare(NonMilkable o1, NonMilkable o2) {
        if (o1.getAge()>o2.getAge()){
            return 1;
        }else if(o1.getAge()<o2.getAge()){
            return -1;
        }
        return 0;
    }
}
