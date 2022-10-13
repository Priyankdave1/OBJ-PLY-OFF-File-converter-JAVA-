package assignment;

import java.util.LinkedHashSet;
import java.util.Objects;

public class Polygon extends GraphicalObject{
	LinkedHashSet<Vertex> vertices;

	public Polygon(LinkedHashSet<Vertex> vertices) {
		
		this.vertices = vertices;
	}

	public void transform(double[][] tmat) {
		// TODO Auto-generated method stub
		for (Vertex i : vertices) {
			i.transform(tmat);
		}
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(vertices);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Polygon other = (Polygon) obj;
		for (Vertex v: this.vertices ) {
			int counter=0;
			for (Vertex ver: other.vertices) 
			{
				
				if(v.equals(ver)) {
					counter =1;
					break;
				}
			}
			if (counter !=1) {
				
				return false;
			}
		}
		return true;
		
	}
	
}
