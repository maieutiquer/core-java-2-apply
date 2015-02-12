package com.maieutiquer.listduplicatingfiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListDuplicatingFiles {
	
	private static boolean contentEquals(Path f1, Path f2) {
		if (f1.toFile().length() != f2.toFile().length()) {
			return false;
		}

		byte[] file1Bytes = null;
		byte[] file2Bytes = null;

		try {
			file1Bytes = Files.readAllBytes(f1);
			file2Bytes = Files.readAllBytes(f2);
		} catch (IOException e) {
			// TODO how should I handle this?
			e.printStackTrace();
		}

		if (Arrays.equals(file1Bytes, file2Bytes)) {
			return true;
		}

		return false;
	}

	private static List<Path> dedupeFilesList(List<Path> filesList) {
		for (int i = 0; i < filesList.size() - 1; i++) {
			for (int j = i + 1; j < filesList.size(); j++) {
				if (contentEquals(filesList.get(i), filesList.get(j))) {
					System.out.println(filesList.get(i));
					filesList.remove(i);
				}
			}
		}
		return filesList;
	}

	private static List<Path> listDuplicatingFiles(String dir) {

		// check if path exists and the app has access to it
		if (!Files.exists(Paths.get(dir))) {
			return null;
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

	public static void main(String[] args) {

		String directory = "C:/server/htdocs/dupes";

		List<Path> duplicatingFiles = listDuplicatingFiles(directory);

		System.out.println(duplicatingFiles);

	}

}
