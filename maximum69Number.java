class Solution {
    public int maximum69Number (int num) {
    int count=0;
        int n=num;
		//finding total number of digits
        while(n>0)
        {
            n=n/10;
            count++;
        }
        int[] arr=new int[count];
		//inserting all digits into an array
        while(num>0)
        {
            arr[count-1]=num%10;
            num=num/10;
            count--;
        }
		//replacing first 6 with 9 and then break the loop
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==9)
                continue;
            else
            {
                arr[i]=9;
                break;
            }
        }
		//converting array value into integer
        int newNum=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            newNum=newNum*10+arr[i];
        }
        return newNum;
}
}