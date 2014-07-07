package other;
/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月7日 下午8:07:33
 * 对数组按照某一基准进行整理(此处为最右元素
 * http://blog.csdn.net/laozhaokun/article/details/37533695)
 */
public class ArrayPivot {
	public static void main(String[] args) {
		int[] c = pivot(new int[] { 2, 3, 5, 1, 6, 4 });
		for (int i = 0; i < c.length; i++)
			System.out.print(c[i] + ",");
	}

	public static int[] pivot(int[] a){
		int len = a.length;
		if(len <= 1)
			return a;
		int p = a[len - 1];
		int i = 0,temp = 0;;
		//第一次大于p的时候
		for(i=0;i<len;i++){
			if(a[i] > p){
				temp = a[i];
				a[i] = a[len - 1];
				a[len - 1] = temp;
				break;
			}
		}
		for(;i<len -1;i++){
			if(a[i+1] < a[i] && a[i+1] < p){
				temp = a[i+1];
				a[i+1] = a[i];
				a[i] = temp;
			}
		}
		return a;
	}
}
