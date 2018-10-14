package pl.gda.pg.eti.kask.javaee.jsf.business.boundary;

import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Owner;
import pl.gda.pg.eti.kask.javaee.jsf.business.Currency;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Keypart;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

import static java.util.Arrays.asList;
import static java.util.Calendar.FEBRUARY;
import static java.util.Calendar.OCTOBER;

@ApplicationScoped
public class KeypartsService implements Serializable {

    private final SortedMap<Integer, Keypart> keyparts = new TreeMap<>();

    private final SortedMap<Integer, Owner> users = new TreeMap<>();

    @PostConstruct
    public void init() {
    	
    	for(int i=1;i<3;++i) {
    		Owner user = new Owner(Integer.valueOf(i), "User"+i, "user."+i+"@gmail.com");
    		users.put(Integer.valueOf(i), user);
    	}
    	
    	Owner[] _users = users.values().toArray(new Owner[0]);
    	
        for(int i=1;i < 10; ++i) {
        	Keypart kp = new Keypart(Integer.valueOf(i), new byte[] {(byte)i,(byte)i,(byte)i}, _users[i%_users.length], Currency.DOGECOIN,  UUID.randomUUID());
        	keyparts.put(Integer.valueOf(i), kp);
        }
    }

    public Collection<Keypart> findAllKeyparts() {
        return keyparts.values();
    }

    public Keypart findKeypart(int id) {
        return keyparts.get(id);
    }

    public void removeKeypart(Keypart kp) {
        keyparts.remove(kp.getId());
    }

    public void saveKeypart(Keypart kp) {
        if (kp.getId() == null) {
            kp.setId(keyparts.lastKey() + 1);
        }

        keyparts.put(kp.getId(), kp);
    }

    public Collection<Owner> findAllUsers() {
        return users.values();
    }

    public Owner findUser(int id) {
        return users.get(id);
    }

}
