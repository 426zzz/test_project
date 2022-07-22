package org.lyz.test_project.test;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) throws IOException {
		File pFile = new File("F:") ;
		File file = new File(pFile, "\\1.txt") ;
		file.getName();
		file.getPath();
		file.getAbsolutePath();
		file.getParent();
		file.exists();
		file.canWrite();
		file.canRead();
		file.isFile();
		file.isDirectory();
		file.lastModified();
		file.length();
		new File("F:\\test").mkdir();
		new File("F:\\2.txt").createNewFile();
		file.delete();
		
	} 
}
