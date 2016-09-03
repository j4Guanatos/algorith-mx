/**
 * 
 */
package mx.epam.algorithms.lib;

import java.io.IOException;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Base test class for algorithm testing.
 * @author Ernesto Espinosa.
 */
public abstract class BaseTest<I,O> implements Runnable {

	public void run() {
		try (DirectoryStream<Path> stream = Files
				.newDirectoryStream(IOUtils.getClassFolderPath(this.getClass()), "*.in")) {
			URI outputURI;
			Path output;
			
			for (Path entry : stream) {
				output = Paths.get(outputURI);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public abstract O parseAndExecute();
}
