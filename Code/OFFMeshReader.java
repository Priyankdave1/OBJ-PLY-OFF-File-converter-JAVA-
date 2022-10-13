package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.regex.*;


public class OFFMeshReader implements MeshReader {
	
 
	@Override
	public HashSet<Polygon> read(String f) throws FileNotFoundException, WrongFileFormatException {
		// TODO Auto-generated method stub
		File file = new File(f);
		
		Scanner textfile = new Scanner(file);
		
		
		String fstln = textfile.nextLine();
		
		Pattern pattern = Pattern.compile("\\s*OFF\\s*");
		Matcher matcher = pattern.matcher(fstln);
		if (!matcher.matches()) {
			textfile.close();
			throw new WrongFileFormatException("Wrong first line");
		}
		
		
		String q = textfile.nextLine();
		q= q.replaceAll("\\s+", " ");
		q = q.strip();
		
		 pattern = Pattern.compile("\\s*\\d+\\s+\\d+\\s+\\d+\\s*");
		 matcher = pattern.matcher(q); 
		if (matcher.matches()==false){
			textfile.close();
			throw new WrongFileFormatException("Wrong second line");
		}
	
		
		 String list [] = q.split(" ");
		 
		 int num_vert = Integer.parseInt(list[0]);
		  
		 int num_faces = Integer.parseInt(list[1]); 
		 Pattern pat = Pattern.compile("(\\s*-?\\d+(\\.\\d+)?\\s+){2}(-?\\d+(\\.\\d+)?\\s*)");
		 HashSet<Polygon> p = new HashSet<Polygon>();
		 Vertex [] ver = new Vertex[num_vert];
		for(int i = 0; i < num_vert ; i++) {
			String l = textfile.nextLine();
			l=l.replaceAll("\\s+", " ");
			l=l.strip();
			Matcher match = pat.matcher(l);
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
			String l = textfile.nextLine();
			l=l.replaceAll("\\s+", " ");
			l=l.strip();
			String m [] = l.split(" ");
			
			
			
			pattern = Pattern.compile("\\s*\\d(\\s+\\d+){"+m[0]+"}\\s*(([0-9]\\s+||[1-9][0-9]\\s+||[1][0-9][0-9]\\s+||[2][0-4][0-9]\\s+||[2][5][0-5]\\s+){2}([0-9]\\s*||[1-9][0-9]\\s*||[1][0-9][0-9]\\s*||[2][0-4][0-9]\\s*||[2][5][0-5]\\s*))?");
			
			Matcher match = pattern.matcher(l);
			if (!match.matches()){
				
				textfile.close();
				throw new WrongFileFormatException("Faces format not correct");
			}
			for(int ch = 1;ch<Integer.parseInt(m[0])+1;ch++ ) {
				if(!(0<= Integer.parseInt(m[ch]) && Integer.parseInt(m[ch])<=num)) {
					
					textfile.close();
					throw new WrongFileFormatException("There is no vertex number greater than " + num_vert+" or less than 0");
				}
			}
			
			
			LinkedHashSet<Vertex> hvert = new LinkedHashSet<Vertex>();
			
			for(int k =0; k<Integer.parseInt(m[0]) ; k++ ) {
				Vertex v = ver[Integer.parseInt(m[k+1])];
				hvert.add(new Vertex(v.x,v.y,v.z));
				
			}
			
			Polygon pol = new Polygon(hvert);
			p.add(pol);
			
		}
		textfile.close();
		return p;
		
	}
}