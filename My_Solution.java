package misc;


public class main_misc {
	//private static long[][] cache = new long[999][999];//
    //private static int[] cache = new int[999]; 
	
	public static void main(String[] args) {
		
		//
		int[]a = {1,100,1};
		int[]b = {20,20,20};
		/*int [] a = acumulate(v,1);
		for(int i = 0;i < a.length;i++) {
			System.out.print(" "+a[i]);
		}*/
		System.out.print(min_start(a,b));
		

		
	}
	private static int[] acumulate(int[]a,int idx) {
		//acumulate values in a circular array
		int []v = new int[a.length];
		int j = 0;
		for(int i = idx;i < a.length;i++) {
			if(i == idx) {
				v[j] = a[i];
				j++;
			}
			else {
				v[j] = a[i] + v[j-1];
				j++;
			}
		}
		int k = j;
        if(k < v.length) {
    		for(int i = 0;i < v.length-k;i++) {
    			v[j] = a[i] + v[j-1];
    			j++;
    			if(j >= v.length) {
    				break;
    			}
    		}
        }
		return v;
	}
	private static int can_path(int[]v,int[]l,int idx) {
		//
		int[] a = acumulate(v,idx);
		int[] b = acumulate(l,idx);
		for(int i = 0;i < a.length;i++) {
			if(a[i]-b[i] < 0) {
				return -1;
			}
		}
		return 1;
	} 
	private static int min_start(int[]a,int[]b) {
		//since i am searching from idx = 0 to n the first avaible path is the minimum
		int m = 0;
		int on_off = 1;
		for(int i = 0;i < a.length;i++) {
		if(on_off == 1) {
			m = i;
		}
			if(can_path(a,b,i) == 1) {
				if(m >= i) {
					m = i;
					on_off = 0;
				}
			}
		}
		if(on_off == 1) {
			//on_off is 1 so there was no path
			return -1;
		}
		else return m+1;
	}
	
	
}
	
		
	
	


	

	
	

