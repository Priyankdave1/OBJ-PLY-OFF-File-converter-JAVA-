package assignment;

import java.util.HashSet;

public interface MeshReader {
	public  HashSet<Polygon> read(String f) throws Exception;
	
}
