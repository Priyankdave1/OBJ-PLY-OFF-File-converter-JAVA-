package assignment;

import java.io.File;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OBJMeshReader implements MeshReader{

	@Override
	public HashSet<Polygon> read(String f) throws Exception {
		
		File file = new File(f);
		
		Scanner textfile = new Scanner(file);
		
		Pattern pattern_v = Pattern.compile("^v((\\s-?\\d+(\\.\\d+)?)(E-?\\d+)?){3}");
		
		String l = "";
		LinkedHashSet<Vertex> hash_vert = new LinkedHashSet<Vertex>();
		while(textfile.hasNextLine()) {
			String line = textfile.nextLine();
			line=line.replaceAll("\\s+", " "); 
			line = line.strip();
			String vert_line []= line.split(" ");
			Matcher match = pattern_v.matcher(line);
			if (!match.matches()) { 
				
				for(int goin = 1; goin<vert_line.length;goin++) {
					try {
						Integer.parseInt(vert_line[goin]);
					} 
					catch(NumberFormatException e) {
						textfile.close();
						throw new WrongFileFormatException("Wrong format: "+vert_line[goin]+" is not an integer");
					}
					if(!(0 < Integer.parseInt(vert_line[goin]) && Integer.parseInt(vert_line[goin])<= hash_vert.size())) {
						
						textfile.close();
						throw new WrongFileFormatException("Wrong format for line");
					}
				} 
				Pattern pattern_f = Pattern.compile("f(\\s+\\d+){"+(vert_line.length-1)+"}");
				Matcher matche = pattern_f.matcher(line);
				if (!matche.matches()) {
					
					textfile.close();
					throw new WrongFileFormatException("Wrong vertex format");
				}
				l = line;
				break;
			}
			
			Vertex v = new Vertex(Double.parseDouble(vert_line[1]),Double.parseDouble(vert_line[2]),Double.parseDouble(vert_line[3]));
			hash_vert.add(v);
			
		}
		String fac [] = l.split(" ");
		Pattern pattern_f = Pattern.compile("f(\\s+\\d+){"+(fac.length-1)+"}");
		Vertex[] vertices_array = hash_vert.toArray(new Vertex[hash_vert.size()]);
		Matcher matche = pattern_f.matcher(l);
		
		
		HashSet<Polygon> hash_face = new LinkedHashSet<Polygon>();
		LinkedHashSet<Vertex> verts = new LinkedHashSet<Vertex>();
		for(int i =1 ; i<fac.length;i++) {
			Vertex v = vertices_array[Integer.parseInt(fac[i])-1];
			verts.add(new Vertex(v.x,v.y,v.z));
			
			
		}
		
		Polygon p = new Polygon(verts);
		hash_face.add(p);
		
		
		while(textfile.hasNextLine()) {
			 l = textfile.nextLine();
			 l= l.replaceAll("\\s+", " ");
			 l=l.strip();
			 fac  = l.split(" ");
			 pattern_f = Pattern.compile("f(\\s+\\d+){"+(fac.length-1)+"}");
			 matche = pattern_f.matcher(l);
			 for(int goin = 1; goin<fac.length;goin++) {
				 try {
						Integer.parseInt(fac[goin]);
					}
					catch(NumberFormatException e) {
						textfile.close();
						throw new WrongFileFormatException("Wrong format: "+fac[goin]+" is not an integer");
					}
					if(!(0 < Integer.parseInt(fac[goin]) && Integer.parseInt(fac[goin])<= hash_vert.size())) {
						
						textfile.close();
						throw new WrongFileFormatException("There is no vertex "+fac[goin]);
					}
				}
			if (!matche.matches()) {
				textfile.close();
				throw new WrongFileFormatException("Wrong format for face line");
			}
			 
			LinkedHashSet<Vertex> verti = new LinkedHashSet<Vertex>();
			 
			for(int i =1 ; i<fac.length;i++) {
				
				Vertex v = vertices_array[Integer.parseInt(fac[i])-1];
				verti.add(new Vertex(v.x,v.y,v.z));
				
				
			}
			
			
			Polygon po = new Polygon(verti);
			hash_face.add(po);
			
			
			
		}
		
		
		
		textfile.close();
		
		return hash_face;
	
		
	}

}
