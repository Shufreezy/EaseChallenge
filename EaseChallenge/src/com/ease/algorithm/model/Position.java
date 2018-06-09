/**
 * 
 */
package com.ease.algorithm.model;

/**
 * @author Shufreezy
 *
 */
public class Position {
	int x;
	int y;
	SearchModel searchModel;
	
	public Position() {}
	
	public Position(Position clone) {
		this.x = clone.x;
		this.y = clone.y;
		this.searchModel = new SearchModel(clone.searchModel);
	}
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * @return the searchModel
	 */
	public SearchModel getSearchModel() {
		return searchModel;
	}
	/**
	 * @param searchModel the searchModel to set
	 */
	public void setSearchModel(SearchModel searchModel) {
		this.searchModel = searchModel;
	}
}
