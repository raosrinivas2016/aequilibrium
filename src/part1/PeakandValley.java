package part1;

public class PeakandValley {

	public static void main(String[] args) {
		PeakandValley pv=new PeakandValley();
		pv.testpeakandvalley();
	}

		public void testpeakandvalley()
		{
			int[] a={2,6,6,6,3};

			int i=0,j=i+1,k=j+1,p=0,v=0,c=0;
			if(a.length>=1)
				++p;
			while(k<a.length)
			{
				if(a[i]==a[j] && a[j]==a[k])
					++p;

				else if(a[j]>a[i] && a[j]>a[k])
					++p;

				else if(a[j]<a[i] && a[j]<a[k])
					++v;
				k++;
				i++;
				j++;
				c++;

			}
			System.out.println("valleys:"+v+"\t peaks:"+p);



		}
	}
