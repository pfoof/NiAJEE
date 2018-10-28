package pl.gda.pg.eti.kask.javaee.jsf.business.boundary;

import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Owner;
import pl.gda.pg.eti.kask.javaee.jsf.business.Currency;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Keypart;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
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
    	
    	for(int i=1;i<5;++i) {
    		Owner user = new Owner(Integer.valueOf(i), "User"+i, "user."+i+"@gmail.com");
    		users.put(Integer.valueOf(i), user);
    	}
    	
    	Owner[] _users = users.values().toArray(new Owner[0]);
    	
        for(int i=1;i < 10; ++i) {
        	Keypart kp = new Keypart(Integer.valueOf(i), new byte[] {(byte)i,(byte)i,(byte)i}, asList(_users), Currency.DOGECOIN,  UUID.randomUUID());
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
    
    public void removeUser(Owner owner) {
    	for(Keypart keypart : findAllKeyparts()) {

    	    if(keypart.getOwner().contains(owner)) {
    			ArrayList<Owner> newOwners = new ArrayList<Owner>();

    			for( Owner owner1 : keypart.getOwner() )
    				if( ! owner1.equals(owner) ) {
    					newOwners.add(owner1);
    				}

    			keypart.setOwner(newOwners);
    	    }

    	}

        users.remove(owner.getId());
    }

    public void saveKeypart(Keypart keypart) {
        if (keypart.getId() == null) {
			if(keyparts.size()==0) keypart.setId(1);
            else keypart.setId(keyparts.lastKey() + 1);
        }

        keyparts.put(keypart.getId(), keypart);
    }
    
    public void saveUser(Owner owner) {
        if (owner.getId() == null) {
			if(users.size()==0) owner.setId(1);
            else owner.setId(users.lastKey() + 1);
        }

        users.put(owner.getId(), owner);
    }

    public Collection<Owner> findAllUsers() {
        return users.values();
    }

    public Owner findUser(int id) {
        return users.get(id);
    }

}
