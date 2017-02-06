package com.epam.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Catalog implements Set<News>, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private HashSet<News> catalog;
	
    public Catalog(){
        super();
        setСatalog(new HashSet<>());
    }

    public Set<News> getСatalog() {
		return catalog;
	}

	public void setСatalog(HashSet<News> catalog) {
		this.catalog = catalog;
	}

	@Override
	public boolean add(News arg0) {
		 if (arg0 == null){
	            throw new IllegalArgumentException("Element is null");
	        }
	        return catalog.add(arg0);
	}


	@Override
	public boolean addAll(Collection<? extends News> arg0) {
		if (arg0.contains(null)){
            throw new IllegalArgumentException("Collection contains null");
        }
        return catalog.addAll(arg0);
	}


	@Override
	public void clear() {
		catalog.clear();
	}


	@Override
	public boolean contains(Object arg0) {
		return catalog.contains(arg0);
	}


	@Override
	public boolean containsAll(Collection<?> arg0) {
		 return catalog.containsAll(arg0);
	}

	@Override
	public boolean isEmpty() {
		return catalog.isEmpty();
	}


	@Override
	public Iterator<News> iterator() {
		 return catalog.iterator();
	}

	@Override
	public boolean remove(Object arg0) {
		return catalog.remove(arg0);
	}


	@Override
	public boolean removeAll(Collection<?> arg0) {
		 return catalog.removeAll(arg0);
	}


	@Override
	public boolean retainAll(Collection<?> arg0) {
		  return catalog.retainAll(arg0);
	}

	@Override
	public int size() {
		return catalog.size();
	}


	@Override
	public Object[] toArray() {
		return catalog.toArray();
	}


	@Override
	public <T> T[] toArray(T[] arg0) {
		return catalog.toArray(arg0);
	}

}