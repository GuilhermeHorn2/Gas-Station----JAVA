package misc;


public class main_misc {
	//private static long[][] cache = new long[999][999];//
    //private static int[] cache = new int[999]; 
	
	public static void main(String[] args) {
		
		//
	int[]a = {3,5,2,1,7};
	int[]b = {4,2,1,9,1};
	System.out.println(can_path(a,b));
		

		
	}
	private static int can_path(int[]v,int[]l){
		//first duplicate the arrays,because they are in a circular path
		int[]a = new int[2*v.length];
		int[]b = new int[2*v.length];
		
		int j = 0;
		for(int i = 0;i < v.length;i++){
			//
			a[i] = v[j];
			b[i] = l[j];
			j++;
		}
		for(int i = 0;i < v.length;i++) {
			a[j] = v[i];
			b[j] = l[i];
			j++;
		}
		
		int s = 0;
		int c = 0;
		int m = -1;
		for(int i = 0;i < a.length;i++) {
			//
			if(c == v.length) {
				//if s starting from i can remain > 0 v.length times,that index can visit all gas stations
				m = i-v.length;
				break;
			}
			s += a[i] - b[i];
			if(s < 0) {
				//reset s and c,because this index cant make the complete path
				s = 0;
				c = 0;
			}
			else if(s > 0) {
				c++;
			}
		}
		
		return m;
	}
	
	
}
	
		
	
	


	

	
	

