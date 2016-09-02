/**
 * 
 */
package mx.epam.algorithms.lib;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Extra utility for directories/files related tasks.
 * @author Ernesto Espinosa.
 */
public final class IOUtils {

	/**
	 * Gets the class folder path.
	 * @param clazz Class to determine folder path.
	 * @return Folder path.
	 */
	public static <T> Path getClassFolderPath(Class<T> clazz) {
		try {
			return Paths.get(clazz
					.getProtectionDomain()
					.getCodeSource().getLocation().toURI());
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Disabled constructor.
	 */
	private IOUtils() {
		throw new UnsupportedOperationException();
	}
}
