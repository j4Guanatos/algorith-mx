/**
 * 
 */
package mx.epam.algorithms.lib;

import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Extra utility for directories/files related tasks.
 * @author Ernesto Espinosa.
 */
public final class IOUtils {
	
	public static Path getClassesContainerFolderPath() {
		try {
			return Paths.get(IOUtils.class
					.getProtectionDomain()
					.getCodeSource().getLocation().toURI());
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Gets the class folder path.
	 * @param clazz Class to determine folder path.
	 * @return Folder path.
	 */
	public static <T> Path getClassFolderPath(Class<T> clazz) {
		String packageName;
		
		packageName = clazz.getPackage().getName().replace(
				".",
				FileSystems.getDefault().getSeparator());
		
		return getClassesContainerFolderPath().resolve(Paths.get(packageName));
	}
	
	/**
	 * Disabled constructor.
	 */
	private IOUtils() {
		throw new UnsupportedOperationException();
	}
}
