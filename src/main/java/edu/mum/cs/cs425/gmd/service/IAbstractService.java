package edu.mum.cs.cs425.gmd.service;

import java.util.List;

public interface IAbstractService<T> {
	public abstract List<T> findAll();
	public abstract T save(T t);
	public abstract T findById(Long id);
	public abstract T update(T t);
	public abstract void delete(Long id);
}
