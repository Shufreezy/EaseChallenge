package com.ease.test;

import java.util.Map;

import org.junit.Test;

import com.ease.algorithm.Search;
import com.ease.algorithm.model.SearchModel;
import com.ease.filehandler.dto.FileHandlerDto;

/**
 * @author Shufreezy
 *
 */
public class AlgorithmTest {

	@Test
	public void test_1() {
		Long[][] contents = {
				{ 4L, 8L, 7L, 3L },
				{ 2L, 5L, 9L, 3L },
				{ 6L, 3L, 2L, 5L },
				{ 4L, 4L, 1L, 6L }
		};
		
		FileHandlerDto dto = new FileHandlerDto();
		dto.setXLength(4);
		dto.setYLength(4);
		dto.setContents(contents);
		Search search = new Search();
		Map<String, SearchModel> returnVal = search.processGrid(dto);
		System.out.println(returnVal.get("longestDrop").getPath());
		System.out.println(returnVal.get("highestDrop").getPath());
	}

}
