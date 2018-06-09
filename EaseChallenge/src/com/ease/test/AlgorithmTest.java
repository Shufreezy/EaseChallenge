package com.ease.test;

import java.io.File;
import java.util.Map;

import org.junit.Test;

import com.ease.algorithm.Search;
import com.ease.algorithm.model.SearchModel;
import com.ease.filehandler.FileHandler;
import com.ease.filehandler.dto.FileHandlerDto;

import org.junit.Assert;

/**
 * @author Shufreezy
 *
 */
public class AlgorithmTest {
	
	/**
	 * UNIT TEST FOR SEARCH
	 */

	@Test
	public void test_1() {
		Long[][] contents = new Long[][] { { 4L, 8L, 7L, 3L }, { 2L, 5L, 9L, 3L }, { 6L, 3L, 2L, 5L },
				{ 4L, 4L, 1L, 6L } };

		FileHandlerDto dto = new FileHandlerDto();
		dto.setXLength(4);
		dto.setYLength(4);
		dto.setContents(contents);
		Search search = new Search();
		Map<String, SearchModel> returnVal = search.processGrid(dto);
		Assert.assertEquals("9-5-3-2-1", returnVal.get("longestDrop").getPath());
		Assert.assertEquals("9-5-3-2-1", returnVal.get("highestDrop").getPath());
	}

	@Test
	public void test_2() {
		Long[][] contents = new Long[][] { { 4L, 8L, 7L, 17L }, { 2L, 7L, 10L, 3L }, { 1L, 6L, 5L, 5L },
				{ 2L, 3L, 4L, 6L } };

		FileHandlerDto dto = new FileHandlerDto();
		dto.setXLength(4);
		dto.setYLength(4);
		dto.setContents(contents);
		Search search = new Search();
		Map<String, SearchModel> returnVal = search.processGrid(dto);
		Assert.assertEquals("10-7-6-5-4-3-2-1", returnVal.get("longestDrop").getPath());
		Assert.assertEquals("17-3", returnVal.get("highestDrop").getPath());
	}

	@Test
	public void test_3() {
		/**
		 * Is 7-5-2-1 May be tweaked to cater steeper path (7-5-3-1) Def'n of
		 * steep is difference of starting and ending elevation
		 */
		Long[][] contents = new Long[][] { { 5L, 2L, 9L }, { 7L, 5L, 2L }, { 6L, 3L, 1L } };

		FileHandlerDto dto = new FileHandlerDto();
		dto.setXLength(3);
		dto.setYLength(3);
		dto.setContents(contents);
		Search search = new Search();
		Map<String, SearchModel> returnVal = search.processGrid(dto);
		Assert.assertEquals("7-5-2-1", returnVal.get("longestDrop").getPath());
		Assert.assertEquals("9-2-1", returnVal.get("highestDrop").getPath());
	}

	@Test
	public void test_4() {
		Long[][] contents = new Long[][] { { 4L, 8L }, { 2L, 7L } };

		FileHandlerDto dto = new FileHandlerDto();
		dto.setXLength(2);
		dto.setYLength(2);
		dto.setContents(contents);
		Search search = new Search();
		Map<String, SearchModel> returnVal = search.processGrid(dto);
		Assert.assertEquals("8-4-2", returnVal.get("longestDrop").getPath());
		Assert.assertEquals("8-4-2", returnVal.get("highestDrop").getPath());
	}
	
	/**
	 * UNIT TEST for FILE HANDLING
	 */

	@Test
	public void file_test_1() {
		FileHandler fh = new FileHandler();
		FileHandlerDto dto = new FileHandlerDto();
		dto = fh.readFile(new File("").getAbsolutePath() + File.separator + "src" + File.separator + "com" + File.separator + "ease" + File.separator + "resources" + File.separator + "test_1.txt");
		Assert.assertEquals(new Integer(4), dto.getXLength());
		Assert.assertEquals(new Integer(4), dto.getYLength());
	}
	
	@Test
	public void file_test_2() {
		FileHandler fh = new FileHandler();
		FileHandlerDto dto = new FileHandlerDto();
		dto = fh.readFile(new File("").getAbsolutePath() + File.separator + "src" + File.separator + "com" + File.separator + "ease" + File.separator + "resources" + File.separator + "test_2.txt");
		Assert.assertEquals(new Integer(4), dto.getXLength());
		Assert.assertEquals(new Integer(4), dto.getYLength());
	}
	
	@Test
	public void file_test_3() {
		FileHandler fh = new FileHandler();
		FileHandlerDto dto = new FileHandlerDto();
		dto = fh.readFile(new File("").getAbsolutePath() + File.separator + "src" + File.separator + "com" + File.separator + "ease" + File.separator + "resources" + File.separator + "test_3.txt");
		Assert.assertEquals(new Integer(3), dto.getXLength());
		Assert.assertEquals(new Integer(3), dto.getYLength());
	}
	
	@Test
	public void file_test_4() {
		FileHandler fh = new FileHandler();
		FileHandlerDto dto = new FileHandlerDto();
		dto = fh.readFile(new File("").getAbsolutePath() + File.separator + "src" + File.separator + "com" + File.separator + "ease" + File.separator + "resources" + File.separator + "test_4.txt");
		Assert.assertEquals(new Integer(2), dto.getXLength());
		Assert.assertEquals(new Integer(2), dto.getYLength());
	}
}
