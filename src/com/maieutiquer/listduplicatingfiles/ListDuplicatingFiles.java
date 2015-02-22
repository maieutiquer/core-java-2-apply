package com.maieutiquer.listduplicatingfiles;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class ListDuplicatingFiles {

	public static void main(String[] args) {

		String directory = "C:/server/htdocs/dupes";
		Deduper deduper = new Deduper();

		List<Path> duplicatingFiles = null;
		try {
			duplicatingFiles = deduper.listDuplicatingFiles(directory);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(duplicatingFiles);

	}

}
