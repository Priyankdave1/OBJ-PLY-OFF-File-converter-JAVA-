package assignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Testing {

	@Test
	void test_OBJ_wrong_v_format()  {
		Mesh mesh = new Mesh(); 
		mesh.setReader(new OBJMeshReader()); 
		try {
			mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/badobj.obj");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals( "Wrong vertex format", e.getMessage());
		} 
		
	}
	@Test
	void test_wrong_plyformat() {
		Mesh mesh = new Mesh(); 
		mesh.setReader(new PLYMeshReader()); 
		try {
			mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/badply.ply");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals( "Wrong fifth line", e.getMessage());
		}
	}
	@Test
	void test_OFF_car() {
		Mesh mesh = new Mesh(); 
		mesh.setReader(new OFFMeshReader()); 
		try {
			mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/car.off");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	@Test
	void test_good_OFF() {
		Mesh mesh = new Mesh(); 
		mesh.setReader(new OFFMeshReader()); 
		try {
			mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/goodoff.off");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} 
		
		
		
	}
	@Test
	void test_OBJ_car() {
		Mesh mesh = new Mesh(); 
		mesh.setReader(new OBJMeshReader()); 
		try {
			mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/car.obj");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	@Test
	void test_good_OBJ() {
		Mesh mesh = new Mesh(); 
		mesh.setReader(new OBJMeshReader()); 
		try {
			mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/goodobj.obj");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}  
		
		
	}
	@Test
	void test_PLY_car() {
		Mesh mesh = new Mesh(); 
		mesh.setReader(new PLYMeshReader()); 
		try {
			mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/car.ply");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	@Test
	void test_good_PLY() {
		Mesh mesh = new Mesh(); 
		mesh.setReader(new PLYMeshReader()); 
		try {
			mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/goodply.ply");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	@Test
	void test_wffe1off() {
		Mesh mesh = new Mesh(); 
		mesh.setReader(new OFFMeshReader()); 
		try {
			mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/wffe1off.off");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals( "Wrong first line", e.getMessage());
		} 
	} 
	@Test
	void test_wffe2off() {
		Mesh mesh = new Mesh(); 
		mesh.setReader(new OFFMeshReader()); 
		try {
			mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/wffe2off.off");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals( "Wrong second line", e.getMessage());
		} 
	}
	@Test
	void test_wffe3off() {
		Mesh mesh = new Mesh(); 
		mesh.setReader(new OFFMeshReader()); 
		try {
			mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/wffe3off.off");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals( "Wrong vertex format", e.getMessage());
		} 
	}
	@Test
	void test_wffe4off() {
		Mesh mesh = new Mesh(); 
		mesh.setReader(new OFFMeshReader()); 
		try {
			mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/wffe4off.off");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals( "Faces format not correct", e.getMessage());
			
		} 
	}
	@Test
	void test_wffe5off() {
		Mesh mesh = new Mesh(); 
		mesh.setReader(new OFFMeshReader()); 
		try {
			mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/wffe5off.off");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals( "There is no vertex number greater than 4 or less than 0", e.getMessage());
			
		} 
	}
	@Test
	void test_wffe1obj() {
		Mesh mesh = new Mesh(); 
		mesh.setReader(new OBJMeshReader()); 
		try {
			mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/wffe1obj.obj");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals( "Wrong format for line", e.getMessage());
			
		} 
	}
	@Test
	void test_wffe2obj() {
		Mesh mesh = new Mesh(); 
		mesh.setReader(new OBJMeshReader()); 
		try {
			mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/wffe2obj.obj");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals( "Wrong format: ss is not an integer", e.getMessage());
			
		} 
	}
	@Test
	void test_wffe3obj() {
		Mesh mesh = new Mesh(); 
		mesh.setReader(new OBJMeshReader()); 
		try {
			mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/wffe3obj.obj");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals( "Wrong format: 3. is not an integer", e.getMessage());
			
		} 
	}
	@Test
	void test_wffe4obj() {
		Mesh mesh = new Mesh(); 
		mesh.setReader(new OBJMeshReader()); 
		try {
			mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/wffe4obj.obj");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals( "There is no vertex 35", e.getMessage());
			
		} 
	}
	@Test
	void test_wffe1ply() {
		Mesh mesh = new Mesh(); 
		mesh.setReader(new PLYMeshReader()); 
		try {
			mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/wffe1ply.ply");
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			assertEquals( "Wrong first line", e.getMessage());
			
		} 
	}
	@Test
	void test_wffe2ply() {
		Mesh mesh = new Mesh(); 
		mesh.setReader(new PLYMeshReader()); 
		try {
			mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/wffe2ply.ply");
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			assertEquals( "Wrong second line", e.getMessage());
			
		} 
	}
	@Test
	void test_wffe3ply() {
		Mesh mesh = new Mesh(); 
		mesh.setReader(new PLYMeshReader()); 
		try {
			mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/wffe3ply.ply");
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			assertEquals( "Wrong vertex format", e.getMessage());
			
		} 
	}
	@Test
	void test_wffe4ply() {
		Mesh mesh = new Mesh(); 
		mesh.setReader(new PLYMeshReader()); 
		try {
			mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/wffe4ply.ply");
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			assertEquals( "Wrong fourth line", e.getMessage());
			
		} 
	}
	@Test
	void test_wffe5ply() {
		Mesh mesh = new Mesh(); 
		mesh.setReader(new PLYMeshReader()); 
		try {
			mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/wffe5ply.ply");
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			assertEquals( "Wrong third line", e.getMessage());
			
		} 
	}
	@Test
	void test_wffe6ply() {
		Mesh mesh = new Mesh(); 
		mesh.setReader(new PLYMeshReader()); 
		try {
			mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/wffe6ply.ply");
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			assertEquals( "Wrong fifth line", e.getMessage());
			
		} 
	}
	@Test
	void test_wffe7ply() {
		Mesh mesh = new Mesh(); 
		mesh.setReader(new PLYMeshReader()); 
		try {
			mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/wffe7ply.ply");
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			assertEquals( "Wrong sixth line", e.getMessage());
			
		} 
	}
	@Test
	void test_wffe8ply() {
		Mesh mesh = new Mesh(); 
		mesh.setReader(new PLYMeshReader()); 
		try {
			mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/wffe8ply.ply");
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			assertEquals( "Wrong seventh line", e.getMessage());
			
		} 
	}
	@Test
	void test_wffe9ply() {
		Mesh mesh = new Mesh(); 
		mesh.setReader(new PLYMeshReader()); 
		try {
			mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/wffe9ply.ply");
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			assertEquals( "Wrong eighth line", e.getMessage());
			
		}
	}
		@Test
		void test_wffe10ply() {
			Mesh mesh = new Mesh(); 
			mesh.setReader(new PLYMeshReader()); 
			try {
				mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/wffe10ply.ply");
			} catch (Exception e) {
				
				// TODO Auto-generated catch block
				assertEquals( "Wrong ninth line", e.getMessage());
				
			} 
		}
		@Test
		void test_wffe11ply() {
			Mesh mesh = new Mesh(); 
			mesh.setReader(new PLYMeshReader()); 
			try {
				mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/wffe11ply.ply");
			} catch (Exception e) {
				
				// TODO Auto-generated catch block
				assertEquals( "Wrong vertex format", e.getMessage());
				
			} 
		}
		@Test
		void test_wffe12ply() {
			Mesh mesh = new Mesh(); 
			mesh.setReader(new PLYMeshReader()); 
			try {
				mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/wffe12ply.ply");
			} catch (Exception e) {
				
				// TODO Auto-generated catch block
				assertEquals( "Wrong face format", e.getMessage());
				
			} 
		}
		@Test
		void test_wffe13ply() {
			Mesh mesh = new Mesh(); 
			mesh.setReader(new PLYMeshReader()); 
			try {
				mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/wffe13ply.ply");
			} catch (Exception e) {
				
				// TODO Auto-generated catch block
				assertEquals( "No vertex: 7", e.getMessage());
				
			} 
		}
		@Test
		void test_vertex_tostring() {
			Vertex v = new Vertex(4,5.9,8);
			assertEquals( "4.0 5.9 8.0", v.toString());
		}
	
		@Test
		void test_mesh_equals()  {
			Mesh mesh1 = new Mesh();
			mesh1.setReader(new OBJMeshReader());
			try {
				mesh1.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/car.obj");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mesh1.rotateYAxis(Math.PI/3);
			Mesh mesh = new Mesh(); 
			mesh.setReader(new OBJMeshReader()); 
			try {
				mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/car_rotated.obj");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertTrue(mesh1.equals(mesh));
			
		}
		@Test
		void test_mesh_notequals()  {
			Mesh mesh1 = new Mesh();
			mesh1.setReader(new OBJMeshReader());
			try {
				mesh1.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/goodobj.obj");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Mesh mesh = new Mesh(); 
			mesh.setReader(new OBJMeshReader()); 
			try {
				mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/car_rotated.obj");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertFalse(mesh1.equals(mesh));
			
		}
		@Test
		void test_OBJ_write()  {
			Mesh mesh1 = new Mesh();
			mesh1.setReader(new OBJMeshReader());
			try {
				mesh1.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/goodobj.obj");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mesh1.setWriter(new OBJMeshWriter());
			try {
				mesh1.writeToFile("/Users/priyankdave/eclipse-workspace/assignment/goodobj_written.obj");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Mesh mesh = new Mesh(); 
			mesh.setReader(new OBJMeshReader()); 
			try {
				mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/goodobj_written.obj");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertTrue(mesh1.equals(mesh));
			
		}
		@Test
		void test_OFF_write()  {
			Mesh mesh1 = new Mesh();
			mesh1.setReader(new OFFMeshReader());
			try {
				mesh1.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/goodoff.off");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mesh1.setWriter(new OFFMeshWriter());
			try {
				mesh1.writeToFile("/Users/priyankdave/eclipse-workspace/assignment/goodoff_written.off");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Mesh mesh = new Mesh(); 
			mesh.setReader(new OFFMeshReader()); 
			try {
				mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/goodoff_written.off");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertTrue(mesh1.equals(mesh));
			
		}
		@Test
		void test_PLY_write()  {
			Mesh mesh1 = new Mesh();
			mesh1.setReader(new PLYMeshReader());
			try {
				mesh1.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/goodply.ply");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mesh1.setWriter(new PLYMeshWriter());
			try {
				mesh1.writeToFile("/Users/priyankdave/eclipse-workspace/assignment/goodply_written.ply");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Mesh mesh = new Mesh(); 
			mesh.setReader(new PLYMeshReader()); 
			try {
				mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/goodply_written.ply");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertTrue(mesh1.equals(mesh));
			
		}
		@Test
		void test_rotateX()  {
			Mesh mesh1 = new Mesh();
			mesh1.setReader(new OBJMeshReader());
			try {
				mesh1.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/car.obj");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mesh1.rotateXAxis(2*Math.PI);
			Mesh mesh = new Mesh(); 
			mesh.setReader(new OBJMeshReader()); 
			try {
				mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/car.obj");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertTrue(mesh1.equals(mesh));
			
		}
		@Test
		void test_rotateZ()  {
			Mesh mesh1 = new Mesh();
			mesh1.setReader(new OBJMeshReader());
			try {
				mesh1.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/car.obj");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mesh1.rotateZAxis(2*Math.PI);
			Mesh mesh = new Mesh(); 
			mesh.setReader(new OBJMeshReader()); 
			try {
				mesh.readFromFile("/Users/priyankdave/eclipse-workspace/assignment/car.obj");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertTrue(mesh1.equals(mesh));
			
		}
		
	
	

}
