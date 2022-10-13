package assignment;


import java.util.HashSet;
import java.util.Objects;


public class Mesh extends GraphicalObject {
	HashSet<Polygon> polygons;
	MeshReader reader;
	MeshWriter writer;
	
	public void setReader (MeshReader m) {
		this.reader = m;
	}
	public void setWriter (MeshWriter m) {
		this.writer = m;
	}
	public void readFromFile (String f) throws Exception  {
		
		
		polygons = reader.read(f);

	}
	public void writeToFile (String f) throws Exception {
		writer.write(f,polygons);
	}
	@Override
	public void transform(double[][] tmat) {
		// TODO Auto-generated method stub
		for (Polygon p : this.polygons) {
			p.transform(tmat);
		}
	}
	@Override
	public int hashCode() {
		return Objects.hash(this.polygons);
				}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Mesh other = (Mesh) obj;
		for (Polygon v: this.polygons ) {
			int counter=0;
			for (Polygon ver: other.polygons) { 
				
				if(v.equals(ver)) {
					counter =1; 
				}
			}
			if (counter !=1) {
				return false;
			} 
		}
		return true;
	}
	
}
