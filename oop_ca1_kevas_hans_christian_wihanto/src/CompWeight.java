import java.util.Comparator;

public class CompWeight implements Comparator<NonMilkable> {

    @Override
    public int compare(NonMilkable o1, NonMilkable o2) {
        if (o1.getWeight()>o2.getWeight()){
            return 1;
        }else if(o1.getWeight()>o2.getWeight()){
            return -1;
        }
        return 0;
    }
}
