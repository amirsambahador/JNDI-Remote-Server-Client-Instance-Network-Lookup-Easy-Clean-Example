import org.j2os.model.Car;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

/*
    Bahador, Amirsam
 */
public class ServerMain {
    private static final Context CONTEXT;

    static {
        try {
            System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
            CONTEXT = new InitialContext();
            LocateRegistry.createRegistry(1099);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        CONTEXT.bind("j2os:org/erp/general/carInstance", new Car(Car.class.toString()));
        CONTEXT.close();
    }
}