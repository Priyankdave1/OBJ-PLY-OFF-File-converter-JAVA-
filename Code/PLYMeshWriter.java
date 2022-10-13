package assignment;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class PLYMeshWriter implements MeshWriter{

	@Override
	public void write(String filename, HashSet<Polygon> polygons) throws Exception{
		// TODO Auto-generated method stub
		File file = new File(filename);
		
		FileWriter output = new FileWriter(file,true);
		PrintWriter printWriter = new PrintWriter(output);
		
		printWriter.printf("ply\n");
		printWriter.printf("format ascii 1.0\n");
		LinkedHashSet<Vertex> v = new LinkedHashSet<Vertex>();
		for(Polygon a : polygons) {
			for (Vertex b : a.vertices) {
				v.add(b);
			}
		}
		Vertex vert [] = new Vertex[v.size()];
		printWriter.printf("element vertex %d\n",v.size());
		printWriter.printf("property float32 x\n");
		printWriter.printf("property float32 y\n");
		printWriter.printf("property float32 z\n");
		printWriter.printf("element face %d\n",polygons.size());
		printWriter.printf("property list uint8 int32 vertex_indices\n");
		printWriter.printf("end_header\n");
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
					if (tex.equals(vert[index])) {
						count++;
						se = se +" " +index;
					}
				}
			}
			printWriter.printf("%d%s\n",count,se);
		}
		printWriter.close();
		
		
		
		
	}

}
