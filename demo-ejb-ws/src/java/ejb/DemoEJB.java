
package ejb;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;

/**
 *
 * @author Aleks
 */
@WebService(serviceName = "DemoEJB")
@Stateless()
public class DemoEJB {

    @EJB
    private EJBServiceLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "random")
    public int random() {
        return ejbRef.random();
    } 
    
}
