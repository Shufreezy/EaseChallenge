package com.ease;

import java.io.File;
import java.util.Map;

import com.ease.algorithm.Search;
import com.ease.algorithm.model.SearchModel;
import com.ease.filehandler.FileHandler;
import com.ease.filehandler.dto.FileHandlerDto;

public class MainRunner {

	public static void main(String[] args) {
		FileHandler fh = new FileHandler();
		FileHandlerDto dto = new FileHandlerDto();
		dto = fh.readFile(new File("").getAbsolutePath() + File.separator + "src" + File.separator + "com" + File.separator + "ease" + File.separator + "resources" + File.separator + "map.txt");
		Search search = new Search();
		Map<String, SearchModel> returnVal = search.processGrid(dto);
		System.out.println("Highest Drop Path: " + returnVal.get("highestDrop").getPath());
		System.out.println("Highest Drop Value: " + returnVal.get("highestDrop").getDrop());
		System.out.println("Highest Drop Length: " + returnVal.get("highestDrop").getLength());
		System.out.println("Longest Drop Path: " + returnVal.get("longestDrop").getPath());
		System.out.println("Longest Drop Value: " + returnVal.get("longestDrop").getDrop());
		System.out.println("Longest Drop Length: " + returnVal.get("longestDrop").getLength());
	}

}
