package chat;

import java.io.InputStream;

public class ResourceLoader {
	
	public static InputStream load(String path){
		return ResourceLoader.class.getResourceAsStream(path);
	}
}
