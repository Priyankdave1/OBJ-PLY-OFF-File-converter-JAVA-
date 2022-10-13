package assignment;


import java.util.Objects;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class Vertex extends GraphicalObject{
	
	double x;
	double y;
	double z;
	
	public Vertex(double x_o, double y_o, double z_o) {
		 
		BigDecimal z_round = new BigDecimal(z_o).setScale(8, RoundingMode.HALF_UP);
		BigDecimal x_round = new BigDecimal(x_o).setScale(8, RoundingMode.HALF_UP);
		BigDecimal y_round = new BigDecimal(y_o).setScale(8, RoundingMode.HALF_UP);
		this.x = x_round.doubleValue();
		this.y = y_round.doubleValue();
		this.z = z_round.doubleValue();
	}
	@Override
	public int hashCode() {
		return Objects.hash(x, y, z);
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		return (this.x==other.x && this.y == other.y && this.z == other.z);
	}
	@Override
	public String toString() {
		return  x + " " + y + " " + z;
	}
	@Override
	public void transform(double[][] tmat) {
		// TODO Auto-generated method stub
			double new_x = this.x;
			double new_y = this.y;
			double new_z = this.z;
			double x_o = (new_x * tmat[0][0]) + (new_y * tmat[0][1]) + (new_z * tmat[0][2]);
			BigDecimal x_round = new BigDecimal(x_o).setScale(8, RoundingMode.HALF_UP);
			Double y_o = (new_x * tmat[1][0]) + (new_y * tmat[1][1]) + (new_z * tmat[1][2]);
			BigDecimal y_round = new BigDecimal(y_o).setScale(8, RoundingMode.HALF_UP);
			Double z_o = (new_x * tmat[2][0]) + (new_y * tmat[2][1]) + (new_z * tmat[2][2]);
			BigDecimal z_round = new BigDecimal(z_o).setScale(8, RoundingMode.HALF_UP);
			this.z = z_round.doubleValue();
			this.x=x_round.doubleValue();
			this.y=y_round.doubleValue();
	}
	
	
}
