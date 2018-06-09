package com.ease.algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.ease.algorithm.model.Position;
import com.ease.algorithm.model.SearchModel;
import com.ease.filehandler.dto.FileHandlerDto;

/**
 * @author Shufreezy
 *
 */
public class Search {

	static Long[][] contents;
	static SearchModel highestDrop;
	static SearchModel longestDrop;

	public Map<String, SearchModel> processGrid(FileHandlerDto dto) {
		contents = dto.getContents();
		highestDrop = new SearchModel();
		longestDrop = new SearchModel();
		LinkedList<Position> searchQueue = new LinkedList<Position>();

		Position pos;

		// Traverse all elements initially
		// Initialize distance, drop to 0
		for (int row = 0; row < dto.getYLength(); row++) {
			for (int col = 0; col < dto.getXLength(); col++) {
				pos = new Position();

				pos.setX(col);
				pos.setY(row);

				SearchModel initial = new SearchModel(1L, 0L, contents[row][col], contents[row][col],
						contents[row][col] + "-");
				pos.setSearchModel(initial);

				searchQueue.add(pos);

			}
		}

		breadthFirstSearch(searchQueue);

		Map<String, SearchModel> returnValue = new HashMap<String, SearchModel>();

		highestDrop.setPath(highestDrop.getPath().substring(0, highestDrop.getPath().length() - 1));
		if (!highestDrop.equals(longestDrop)) {
			 longestDrop.setPath(longestDrop.getPath().substring(0, longestDrop.getPath().length() - 1));
		}

		returnValue.put("highestDrop", highestDrop);
		returnValue.put("longestDrop", longestDrop);

		return returnValue;
	}

	private void breadthFirstSearch(LinkedList<Position> searchQueue) {
		SearchModel currentSearch;

		Boolean hasMoved;

		while (!searchQueue.isEmpty()) {

			hasMoved = false;

			Position item = searchQueue.getFirst();

			currentSearch = item.getSearchModel();

			Long leftContent = null;
			Long upContent = null;
			Long rightContent = null;
			Long downContent = null;

			Long currentContent = contents[item.getY()][item.getX()];
			if (item.getX() - 1 >= 0) {
				leftContent = contents[item.getY()][item.getX() - 1];
			}
			if (item.getY() - 1 >= 0) {
				upContent = contents[item.getY() - 1][item.getX()];
			}
			if (item.getX() + 1 < contents.length) {
				rightContent = contents[item.getY()][item.getX() + 1];
			}
			if (contents.length != 0 && item.getY() + 1 < contents[0].length) {
				downContent = contents[item.getY() + 1][item.getX()];
			}

			currentSearch.setLastValue(currentContent);

			Position copyOfItem;

			// ENQUEUE LEFT
			if (leftContent != null && currentContent > leftContent) {
				hasMoved = true;
				copyOfItem = new Position(item);

				copyOfItem.setX(item.getX() - 1);
				copyOfItem.getSearchModel().setLength(copyOfItem.getSearchModel().getLength() + 1);
				copyOfItem.getSearchModel().setPath(copyOfItem.getSearchModel().getPath() + "" + leftContent + "-");

				searchQueue.add(copyOfItem);
			}
			// ENQUEUE UP
			if (upContent != null && currentContent > upContent) {
				hasMoved = true;
				copyOfItem = new Position(item);

				copyOfItem.setY(item.getY() - 1);
				copyOfItem.getSearchModel().setLength(copyOfItem.getSearchModel().getLength() + 1);
				copyOfItem.getSearchModel().setPath(copyOfItem.getSearchModel().getPath() + "" + upContent + "-");
				searchQueue.add(copyOfItem);
			}

			// ENQUEUE RIGHT
			if (rightContent != null && currentContent > rightContent) {
				hasMoved = true;
				copyOfItem = new Position(item);

				copyOfItem.setX(item.getX() + 1);
				copyOfItem.getSearchModel().setLength(copyOfItem.getSearchModel().getLength() + 1);
				copyOfItem.getSearchModel().setPath(copyOfItem.getSearchModel().getPath() + "" + rightContent + "-");
				searchQueue.add(copyOfItem);

			}

			// ENQUEUE DOWN
			if (downContent != null && currentContent > downContent) {
				hasMoved = true;
				copyOfItem = new Position(item);

				copyOfItem.setY(item.getY() + 1);
				copyOfItem.getSearchModel().setLength(copyOfItem.getSearchModel().getLength() + 1);
				copyOfItem.getSearchModel().setPath(copyOfItem.getSearchModel().getPath() + "" + downContent + "-");
				searchQueue.add(copyOfItem);
			}

			// NO MOVEMENTS
			if (!hasMoved) {
				if (longestDrop.getLength() < currentSearch.getLength()) {
					longestDrop = currentSearch;
				} else if (longestDrop.getLength() == currentSearch.getLength()) {
					if (longestDrop.getDrop() < currentSearch.getDrop()) {
						longestDrop = currentSearch;
					}
				}

				if (highestDrop.getDrop() < currentSearch.getDrop()) {
					highestDrop = currentSearch;
				} else if (highestDrop.getDrop() == currentSearch.getDrop()) {
					if (highestDrop.getLength() < currentSearch.getLength()) {
						highestDrop = currentSearch;
					}
				}

			}

			searchQueue.removeFirst();
		}

	}
}
