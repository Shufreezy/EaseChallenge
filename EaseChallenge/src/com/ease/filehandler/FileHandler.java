package com.ease.filehandler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.ease.filehandler.dto.FileHandlerDto;

/**
 * @author Shufreezy
 *
 */
public class FileHandler {
	public FileHandlerDto readFile(String fileName) {
		FileHandlerDto dto = new FileHandlerDto();
		String line = null;
		StringTokenizer st = null;
		String token = null;
		List<Long> contentCol;
		List<Long[]> contentRow = new ArrayList<Long[]>();
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null) {
				st = new StringTokenizer(line);
				contentCol = new ArrayList<Long>();
				while (st.hasMoreTokens()) {
					token = st.nextToken();
					if (dto.getXLength() == null) {
						dto.setXLength(Integer.parseInt(token));
					} else if (dto.getYLength() == null) {
						dto.setYLength(Integer.parseInt(token));
					} else {
						contentCol.add(Long.parseLong(token));
					}
				}
				contentRow.add(contentCol.toArray(new Long[dto.getYLength()]));
            }
			br.close();
		} catch (FileNotFoundException fnfException) {
			System.out.println("File not found: " + fileName);
		} catch (IOException ioException) {
			System.out.println("Error reading file: " + fileName);
		}
		
		contentRow.remove(0);
		
		dto.setContents(contentRow.toArray(new Long[dto.getYLength()][dto.getXLength()]));
		
		return dto;
	}
}
