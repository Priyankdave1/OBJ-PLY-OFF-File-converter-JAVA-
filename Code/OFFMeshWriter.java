package assignment;

import java.io.*;

import java.util.HashSet;
import java.util.LinkedHashSet;


public class OFFMeshWriter implements MeshWriter {

	@Override
	public void write(String filename, HashSet<Polygon> polygons) throws IOException {
		// TODO Auto-generated method stub
		File file = new File(filename);
		
		FileWriter output = new FileWriter(file,true);
		PrintWriter printWriter = new PrintWriter(output);
		printWriter.printf("OFF\n");
		
		LinkedHashSet<Vertex> v = new LinkedHashSet<Vertex>();
		for(Polygon a : polygons) {
			for (Vertex b : a.vertices) {
				v.add(b);
			}
		}
		Vertex vert [] = new Vertex[v.size()];
		
		printWriter.printf("%d %d 0\n",v.size(),polygons.size() );
		int temp=0;
		for(Vertex g: v) {
			vert[temp] = g;
			temp++;
			printWriter.printf("%f %f %f\n",g.x,g.y,g.z );
		}
		for(Polygon p :polygons) {
			int count=0;
			String se = "";
			for (Vertex tex : p.vertices) {
				for(int index = 0; index<vert.length ; index++) {
					if (tex.equals( vert[index])) {
						count++;
						se = se +" " +index;
					}
				}
			}
			printWriter.printf("%d%s 220 220 220\n",count,se);
		}
		printWriter.close();
		
	}

}
