package com.ease.algorithm.model;

public class SearchModel {
	Long length;
	Long drop;
	Long initialValue;
	Long lastValue;
	String path;
	
	public SearchModel(SearchModel clone) {
		this.length = clone.length;
		this.drop = clone.drop;
		this.initialValue = clone.initialValue;
		this.lastValue = clone.lastValue;
		this.path = clone.path;
	}
	
	public SearchModel(Long length, Long drop, Long initialValue, Long lastValue, String path) {
		super();
		this.length = length;
		this.drop = drop;
		this.initialValue = initialValue;
		this.lastValue = lastValue;
		this.path = path;
	}

	public SearchModel() {
		this.length = 0L;
		this.drop = 0L;
		this.initialValue = 0L;
		this.lastValue = 0L;
		this.path = "";
	}
	
	/**
	 * @return the length
	 */
	public Long getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(Long length) {
		this.length = length;
	}
	/**
	 * @return the drop
	 */
	public Long getDrop() {
		return initialValue - lastValue;
	}
	/**
	 * @return the initialValue
	 */
	public Long getInitialValue() {
		return initialValue;
	}

	/**
	 * @param initialValue the initialValue to set
	 */
	public void setInitialValue(Long initialValue) {
		this.initialValue = initialValue;
	}

	/**
	 * @return the lastValue
	 */
	public Long getLastValue() {
		return lastValue;
	}

	/**
	 * @param lastValue the lastValue to set
	 */
	public void setLastValue(Long lastValue) {
		this.lastValue = lastValue;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
}
