package com.epam.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Users implements Set<User>, Serializable {

	private static final long serialVersionUID = 1L;

	private HashSet<User> users;
	
	public Users() {
		super();
		setUsers(new HashSet<>());
	}

	public HashSet<User> getUsers() {
		return users;
	}

	public void setUsers(HashSet<User> users) {
		this.users = users;
	}

	@Override
	public boolean add(User arg0) {
		 if (arg0 == null){
	            throw new IllegalArgumentException("Element is null");
	        }
	        return users.add(arg0);
	}


	@Override
	public boolean addAll(Collection<? extends User> arg0) {
		if (arg0.contains(null)){
            throw new IllegalArgumentException("Collection contains null");
        }
        return users.addAll(arg0);
	}

	@Override
	public void clear() {
		users.clear();
	}


	@Override
	public boolean contains(Object arg0) {
		return users.contains(arg0);
	}


	@Override
	public boolean containsAll(Collection<?> arg0) {
		 return users.containsAll(arg0);
	}

	@Override
	public boolean isEmpty() {
		return users.isEmpty();
	}


	@Override
	public Iterator<User> iterator() {
		 return users.iterator();
	}

	@Override
	public boolean remove(Object arg0) {
		return users.remove(arg0);
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		 return users.removeAll(arg0);
	}


	@Override
	public boolean retainAll(Collection<?> arg0) {
		  return users.retainAll(arg0);
	}

	@Override
	public int size() {
		return users.size();
	}

	@Override
	public Object[] toArray() {
		return users.toArray();
	}


	@Override
	public <T> T[] toArray(T[] arg0) {
		return users.toArray(arg0);
	}
}
