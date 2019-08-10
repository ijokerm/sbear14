public class Solution2{
	int i=0;
        int j=a.length-1;
        int temp=a[i];
        while(i<j){
            //从后向前找到第一个奇数
            while (i<j&&a[j]%2==0){
                j--;
            }

            //将倒数第一个奇数放到第一个偶数位置
            a[i]=a[j];

            //从前向后找到第一个偶数
            while (i<j&&a[i]%2!=0){
                i++;
            }

            //将第一个偶数放到第一个奇数位置
            a[j]=a[i];
        }

        //第一个位置的元素放到奇数偶数的分界处
        a[i]=temp;
        return a;
    }
}