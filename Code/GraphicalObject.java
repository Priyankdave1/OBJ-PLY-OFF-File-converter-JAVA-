package assignment;

public abstract class GraphicalObject {
	public abstract void transform (double [][] tmat);
	public void rotateXAxis (double theta) {
		double [][] mat = {{1,0,0},{0,Math.cos(theta),-Math.sin(theta)},{0,Math.sin(theta),Math.cos(theta)}};
		this.transform(mat);
	}
	public void rotateYAxis (double theta) {
		double [][] mat = {{Math.cos(theta),0,Math.sin(theta)},{0,1,0},{-(Math.sin(theta)),0,Math.cos(theta)}};
		this.transform(mat);
	}
	public void rotateZAxis (double theta) {
		double [][] mat = {{Math.cos(theta),-(Math.sin(theta)),0},{Math.sin(theta),Math.cos(theta),0},{0,0,1}};
		this.transform(mat);
	}
}
