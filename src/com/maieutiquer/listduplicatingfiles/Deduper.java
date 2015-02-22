package com.maieutiquer.listduplicatingfiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Deduper {

	private boolean contentEquals(Path f1, Path f2) {
		if (f1.toFile().length() != f2.toFile().length()) {
			return false;
		}

		byte[] file1Bytes = null;
		byte[] file2Bytes = null;

		try {
			file1Bytes = Files.readAllBytes(f1);
			file2Bytes = Files.readAllBytes(f2);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		if (Arrays.equals(file1Bytes, file2Bytes)) {
			return true;
		}

		return false;
	}

	private List<Path> dedupeFilesList(List<Path> filesList) {

		List<Path> uniqueFiles =  new ArrayList<Path>(filesList);

		for (int i = 0; i < filesList.size() - 1; i++) {
			for (int j = i + 1; j < filesList.size(); j++) {
				if (contentEquals(filesList.get(i), filesList.get(j))) {
					uniqueFiles.remove(filesList.get(j));
					break;
				}
			}
		}
		return uniqueFiles;
	}

	// should probably be named listUniqueFiles
	public List<Path> listDuplicatingFiles(String dir) throws IOException {

		// check if path exists and the app has access to it
		if (!Files.exists(Paths.get(dir))) {
			throw new IOException("Path is not a directory");
		}

		List<Path> filesInFolder = null;

		try {
			filesInFolder = Files.walk(Paths.get(dir))
								.filter(Files::isRegularFile)
								.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<Path> filesInFolderNoDupes = dedupeFilesList(filesInFolder);

		return filesInFolderNoDupes;
	}

}
