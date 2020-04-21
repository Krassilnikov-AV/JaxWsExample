package ejb;

import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless
public class EJBService implements EJBServiceLocal {

    private Random rand;

    @PostConstruct
    public void init() {
        rand = new Random(1000);
    }

    @Override
    public int random() {
        return rand.nextInt();
    }

}
