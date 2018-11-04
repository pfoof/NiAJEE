package pl.gda.pg.eti.kask.javaee.jsf.business.boundary;

import java.io.Serializable;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;

import pl.gda.pg.eti.kask.javaee.jsf.business.entities.User;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Keypart;

@ApplicationScoped
public class StorageService implements Serializable {
	
	private final SortedMap<Integer, User> users = new TreeMap<>();
    private final SortedMap<Integer, Keypart> keyparts = new TreeMap<>();

    public Collection<User> getAllUsers() {
    	return users.values();
    }
    
    public User findUserById(Integer id) {
    	return users.get(id);
    }
    
    public void removeUser(User user) {
    	for(Keypart keypart : user.getKeyparts()) {
    		removeKeypart(keypart);
    	}
    	users.remove(user.getId());
    }
    
    public void saveUser(User user) {
    	if(user.getId() == null) {
    		if(users.isEmpty()) {
    			user.setId(Integer.valueOf(1));
    			users.put(user.getId(), user);
    		} else {
    			users.put(users.lastKey() + 1, user);
    		}
    	} else {
    		users.put(user.getId(), user);
    	}
    }
    
    public Collection<Keypart> getAllKeyparts() {
    	return keyparts.values();
    }
    
    public Keypart findKeypartById(Integer id) {
    	return keyparts.get(id);
    }
    
    public void removeKeypart(Keypart keypart) {
    	if(keypart.getOwner() != null)
    		keypart.getOwner().getKeyparts().remove(keypart);
    	keyparts.remove(keypart.getId());
    }
    
    public void saveKeypart(Keypart keypart) {
    	if(keypart.getOwner() != null) {
    		if( ! keypart
    				.getOwner()
    				.getKeyparts()
    				.contains(keypart)
    		) {
    			keypart.getOwner().getKeyparts().add(keypart);
    		}
    	}
    	
    	if(keypart.getId() == null) {
    		if(keyparts.isEmpty()) {
    			keypart.setId(Integer.valueOf(1));
    			keyparts.put(keypart.getId(), keypart);
    		} else {
    			keyparts.put(keyparts.lastKey() + 1, keypart);
    		}
    	} else {
    		keyparts.put(keypart.getId(), keypart);
    	}
    	
    }
    
}
