import java.util.Scanner;
public class light
{
  public static long  numofFlips;
  public static  int[] arr;
  public static  boolean allLightOn;

  public static void init(int n)
  {
     arr=new int[n+1];     
     for (int i=1;i<arr.length;i++)//turning on all the bulbs with 1's
     arr[i]=1;

  }
  public static void printsq()
  {
 
    for(int i=1;i<arr.length;i++)
    {
     
    System.out.printf("%d ",arr[i]);//for printing arrays containing number 1's and 0's representing if light bulb is on or off.
    
    }

  }
  
  public static void lightoff(int n) //recursive light off function.
  { 
   
    if (n==1){//base case for lightoff function
      arr[n]=0; 
      printsq();System.out.printf(" Turn OFF light %d\n",n);
      numofFlips++;  //counts number of flips
     
    }
   else
   {
     if(n>=2){
       lightoff(n-2); 
       
       arr[n]=0;
       printsq(); System.out.printf(" Turn OFF light %d\n",n);  
       numofFlips++;
       lighton(n-2);
       lightoff(n-1);
     }
     
   }
  }


  public static void lighton(int n)
  { 
   
   if (n==1){
      arr[n]=1;
      printsq();
      numofFlips++;
     System.out.printf(" Turn ON light %d\n",n); 
    }
   else
   { 
     if(n>=2){
       lighton(n-2);
      
       arr[n]=1;
       printsq();
       numofFlips++;
       System.out.printf(" Turn ON light %d\n",n);
   
       lightoff(n-2);
       lighton(n-1);
     }
       
  

 
   }
  }
  public static void main(String[] args)
  {
    numofFlips=0;
    Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
   init(n);//All lights were on initially not a big to deal to do the other way
   printsq(); System.out.printf(" %d lights are ON initially\n",n); 
   lightoff(n);
   System.out.println(numofFlips);
 
  }
}