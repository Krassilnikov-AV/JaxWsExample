
package ws;

import javax.annotation.PostConstruct;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Aleks
 */
@WebService(serviceName = "DemoWS")
public class DemoWS {

    @PostConstruct
    public void init() {}
    
    @WebMethod()
    public long sum (@WebParam(name="first")int x, @WebParam(name="second")int y) {
        return (long)x + y;
    }
    
    @WebMethod()
    public String toUpperCase (@WebParam(name="input") String input) {
        return input.toUpperCase();
    }
    
    @WebMethod(operationName = "info")
    public String info() {
        return "DemoWS Service";
    }
}
