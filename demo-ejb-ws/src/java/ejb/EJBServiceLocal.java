package ejb;

import javax.ejb.Local;


@Local
public interface EJBServiceLocal {

    int random();

}
