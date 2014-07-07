package other;
/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月7日 下午7:12:56
 * 合并两个有序数组为一个新的有序数组
 * http://blog.csdn.net/laozhaokun/article/details/37531247
 */
public class MergeTwoSortedArrays {
	public static int[] merge(int[] a, int[] b) {
		int lena = a.length;
		int lenb = b.length;
		int[] c = new int[lena + lenb];
		int i = 0, j = 0, k = 0;//分别代表数组a ,b , c 的索引
		while (i < lena && j < lenb) {
			if (a[i] < b[j])
				c[k++] = a[i++];
			else
				c[k++] = b[j++];
		}
		while (i < lena)
			c[k++] = a[i++];
		while (j < lenb)
			c[k++] = b[j++];
		return c;
	}

	public static void main(String[] args) {
		int[] c = merge(new int[] { 1, 2, 3, 4 }, new int[] { 0, 2, 4, 5,
				6, 7, 8 });
		for (int i = 0; i < c.length; i++)
			System.out.println(c[i]);
	}

}


