import org.j2os.model.Car;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/*
    Bahador, Amirsam
 */
public class ClientMain {
    private static final Context CONTEXT;

    static {
        try {
            System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
            CONTEXT = new InitialContext();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        Car car = (Car) CONTEXT.lookup("j2os:org/erp/general/carInstance");
        car.start();
        CONTEXT.close();
    }
}