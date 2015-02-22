package com.maieutiquer.listduplicatingfiles;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class ListDuplicatingFiles {

	public static void main(String[] args) {

		String directory = "C:/server/htdocs/dupes";
		Deduper deduper = null;
		try {
			deduper = new Deduper(directory);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		List<Path> duplicatingFiles = deduper.listDuplicatingFiles(directory);

		System.out.println(duplicatingFiles);

	}

}
