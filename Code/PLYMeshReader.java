package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PLYMeshReader implements MeshReader {

	@Override
	public HashSet<Polygon> read(String f) throws FileNotFoundException, WrongFileFormatException {
		// TODO Auto-generated method stub
		File file = new File(f);
		 
		Scanner textfile = new Scanner(file);
		HashSet<Polygon> phash = new HashSet<Polygon>();
		Pattern pattern = Pattern.compile("ply");
		String l = textfile.nextLine();
		l = l.replaceAll("\\s+", " ");
		l = l.strip();
		Matcher matcher = pattern.matcher(l);
		if(!matcher.matches()) {
			textfile.close();
			throw new WrongFileFormatException("Wrong first line");
		}
		pattern = Pattern.compile("format\\sascii\\s1\\.0");
		l = textfile.nextLine();
		l = l.replaceAll("\\s+", " ");
		l = l.strip();
		matcher = pattern.matcher(l);
		if(!matcher.matches()) {
			textfile.close();
			throw new WrongFileFormatException("Wrong second line");
		}
		pattern = Pattern.compile("element\\svertex\\s\\d+");
		l = textfile.nextLine();
		l = l.replaceAll("\\s+", " ");
		l = l.strip();
		int num_vert;
		matcher = pattern.matcher(l);
		if(!matcher.matches()) {
			textfile.close();
			throw new WrongFileFormatException("Wrong third line");
		}
		else {
			String line[] = l.split(" ");
			num_vert = Integer.parseInt(line[2]);
		}
		pattern = Pattern.compile("property\\sfloat32\\sx");
		l = textfile.nextLine();
		l = l.replaceAll("\\s+", " ");
		l = l.strip();
		matcher = pattern.matcher(l);
		if(!matcher.matches()) {
			textfile.close();
			throw new WrongFileFormatException("Wrong fourth line");
		}
		pattern = Pattern.compile("property\\sfloat32\\sy");
		l = textfile.nextLine();
		l = l.replaceAll("\\s+", " ");
		l = l.strip();
		matcher = pattern.matcher(l);
		if(!matcher.matches()) {
			textfile.close();
			throw new WrongFileFormatException("Wrong fifth line");
		}
		pattern = Pattern.compile("property\\sfloat32\\sz");
		l = textfile.nextLine();
		l = l.replaceAll("\\s+", " ");
		l = l.strip();
		matcher = pattern.matcher(l);
		if(!matcher.matches()) {
			textfile.close();
			throw new WrongFileFormatException("Wrong sixth line");
		}
		pattern = Pattern.compile("element\\sface\\s\\d+");
		l = textfile.nextLine();
		l = l.replaceAll("\\s+", " ");
		l = l.strip();
		matcher = pattern.matcher(l);
		int num_faces;
		if(!matcher.matches()) {
			textfile.close();
			throw new WrongFileFormatException("Wrong seventh line");
		}
		else {
			String line[] = l.split(" ");
			num_faces = Integer.parseInt(line[2]);
		}
		pattern = Pattern.compile("property\\slist\\suint8\\sint32\\svertex_indices");
		l = textfile.nextLine();
		l = l.replaceAll("\\s+", " ");
		l = l.strip();
		matcher = pattern.matcher(l);
		if(!matcher.matches()) {
			textfile.close();
			throw new WrongFileFormatException("Wrong eighth line");
		}
		pattern = Pattern.compile("end_header");
		l = textfile.nextLine();
		l = l.replaceAll("\\s+", " ");
		l = l.strip();
		matcher = pattern.matcher(l);
		if(!matcher.matches()) {
			textfile.close();
			throw new WrongFileFormatException("Wrong ninth line");
		}
		
		Vertex [] ver = new Vertex[num_vert];
		for(int i = 0; i < num_vert ; i++) {
			l = textfile.nextLine();
			l = l.replaceAll("\\s+", " ");
			l = l.strip();
			pattern = Pattern.compile("(-?\\d+(\\.\\d+)?\\s+){2}(-?\\d+(\\.\\d+)?\\s*)");
			Matcher match = pattern.matcher(l);
			if (!match.matches()){
				textfile.close();
				throw new WrongFileFormatException("Wrong vertex format");
			}
			
			String m [] = l.split(" ");
			Vertex v = new Vertex(Double.parseDouble(m[0]),Double.parseDouble(m[1]), Double.parseDouble(m[2]));
			ver[i]= v;
			
			
		}
		
		int num = num_vert-1;
		for (int j = 0; j<num_faces; j++) {
			 l = textfile.nextLine();
			 l = l.replaceAll("\\s+", " ");
				l = l.strip();
			 String m [] = l.split(" ");
			pattern = Pattern.compile("\\s*\\d(\\s+\\d+){"+m[0]+"}\\s*");
			Matcher match = pattern.matcher(l);
			
			if (!match.matches()){
				textfile.close();
				throw new WrongFileFormatException("Wrong face format");
			}
			for(int ch = 1;ch<Integer.parseInt(m[0])+1;ch++ ) {
				if(!(0<= Integer.parseInt(m[ch]) && Integer.parseInt(m[ch])<=num)) {
					
					textfile.close();
					throw new WrongFileFormatException("No vertex: " + m[ch]);
				}
			}
			
			
			LinkedHashSet<Vertex> hvert = new LinkedHashSet<Vertex>();
			
			for(int k =1; k<Integer.parseInt(m[0])+1 ; k++ ) {
				Vertex v = ver[Integer.parseInt(m[k])];
				hvert.add(new Vertex(v.x,v.y,v.z));
				
			}
			
			Polygon pol = new Polygon(hvert);
			phash.add(pol);
			
		}
		textfile.close();
		
		
		return phash;
	}

}
