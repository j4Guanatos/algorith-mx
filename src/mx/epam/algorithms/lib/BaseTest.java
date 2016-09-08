/**
 * 
 */
package mx.epam.algorithms.lib;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Base test class for algorithm testing.
 * @author Ernesto Espinosa.
 */
public abstract class BaseTest {
	
	protected List<Path> inputs;
	protected List<Path> outputs;

	/**
	 * Initializer that gets the list of inputs and outputs.
	 */
	public BaseTest() {
		try (DirectoryStream<Path> stream = Files
				.newDirectoryStream(IOUtils.getClassFolderPath(this.getClass()), "*.in")) {
			Path output;
			String filename;
			
			this.inputs = new ArrayList<>();
			this.outputs = new ArrayList<>();
			
			for (Path entry : stream) {
				inputs.add(entry);
				filename = entry.getName(entry.getNameCount()-1).toString();
				output = entry.resolveSibling(filename.substring(0, filename.indexOf('.')) + ".out");
				outputs.add(output);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * @return
	 */
	public abstract Collection<Object[]> getTestData();
}
