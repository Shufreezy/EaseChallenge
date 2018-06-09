package com.ease.filehandler.dto;

/**
 * @author Shufreezy
 *
 */
public class FileHandlerDto {
	Long[][] contents;
	Integer xLength;
	Integer yLength;

	/**
	 * @return the contents
	 */
	public Long[][] getContents() {
		return contents;
	}

	/**
	 * @param contents the contents to set
	 */
	public void setContents(Long[][] contents) {
		this.contents = contents;
	}

	/**
	 * @return the xLength
	 */
	public Integer getXLength() {
		return xLength;
	}

	/**
	 * @param xLength the xLength to set
	 */
	public void setXLength(Integer xLength) {
		this.xLength = xLength;
	}

	/**
	 * @return the yLength
	 */
	public Integer getYLength() {
		return yLength;
	}

	/**
	 * @param yLength the yLength to set
	 */
	public void setYLength(Integer yLength) {
		this.yLength = yLength;
	}
}