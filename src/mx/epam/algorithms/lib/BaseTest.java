/**
 * 
 */
package mx.epam.algorithms.lib;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Base test class for algorithm testing.
 * @author Ernesto Espinosa.
 */
public abstract class BaseTest<I,O> implements Runnable {

	public void run() {
		System.out.println(IOUtils.getClassFolderPath(this.getClass()));
		
		try (DirectoryStream<Path> stream = Files
				.newDirectoryStream(IOUtils.getClassFolderPath(this.getClass()), "*.in")) {
			Path output;
			String filename;
			
			for (Path entry : stream) {
				filename = entry.getName(entry.getNameCount()-1).toString();
				output = entry.resolveSibling(filename.substring(0, filename.indexOf('.')) + ".out");
				
				System.out.println(output);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public abstract O parseAndExecute();
	
	public static void main(String...args) {
		new BaseTest<Object,Object>() {
			public Object parseAndExecute() {
				return null;
			}
		}.run();
	}
}
