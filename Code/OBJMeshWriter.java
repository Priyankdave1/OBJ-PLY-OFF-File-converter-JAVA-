package assignment;

import java.io.File;
import java.io.FileWriter;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class OBJMeshWriter implements MeshWriter{

	@Override
	public void write(String filename, HashSet<Polygon> polygons) throws Exception {
		// TODO Auto-generated method stub
		File file = new File(filename);
		
		FileWriter output = new FileWriter(file);
		PrintWriter printWriter = new PrintWriter(output);
		LinkedHashSet<Vertex> v = new LinkedHashSet<Vertex>();
		for(Polygon a : polygons) {
			for (Vertex b : a.vertices) {
				v.add(b);
			}
		}
		Vertex vert [] = new Vertex[v.size()];
		int temp=0;
		for(Vertex g: v) {
			vert[temp] = g;
			temp++;
			printWriter.printf("v %f %f %f\n",g.x,g.y,g.z );
		}
		
		for(Polygon p :polygons) {
			
				
				String se = "";
				for (Vertex tex : p.vertices) {
					for(int index = 0; index<vert.length ; index++) {
						if (tex.equals( vert[index])) {
							
							se = se +" " +(index+1);
						}
					}
				}
				printWriter.printf("f%s\n",se);
			}
		printWriter.close();
		}
		
		
	

}
