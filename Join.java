public class Join
{
  public static void main(String args[])
  {
   
//=============Declaring necessary Variables=============================
// Relation R (A,B,C,D) - can be understood as R(FirstName, MiddleName, LastName, Location)

String[][] R = { { "mark", "a", "scott", "ca" }, { "gary", "m", "tyler", "nj" },{ "jane" ,"w", "doe", "tx" },{ "jane" ,"w", "second", "tx" }};// Modify R here to run the program for two cases.

//Relation S (A,C)- can be understood as S(FirstName, LastName)
String[][] S = { { "mark", "benner" }, { "jane", "mitchell" } };

//Memory smaller than relation R
String[][] Memory = new String[2][2];

//Output Buffer as Array
String[][] output_buffer = new String[2][5];

//Input Buffer as Array
String[][] input_buffer = new String[2][4];

//Disk Storage as Array
String[][] disk_storage = new String[10][5];

int flag=0,OBPStateSave=0;

//pointer for disk's next position available to write.
int disk_pointer=0;

//Number of tuples contained in S.
int Sno=S.length;

//pointer for disk's next position available to write/ read.
int OBPointer=0;

//Number of tuples contained in R.
int Rno=R.length;

System.out.println("Tuples from Relation R:");
for(int i=0;i<Rno;i++)
{
  System.out.print("{ ");
  for(int j=0;j<4;j++)
{

  System.out.print(R[i][j]+"  ");
}
System.out.print("}");
System.out.println();
}
//================= Start the Join Application===============================
//Step 1: Load Relation S into Memory.
  for(int i=0;i<Sno;i++)
  {
    for(int j=0;j<2;j++)
  {
    Memory[i][j]=S[i][j];
  }
}


System.out.println("\n Tuples present in Memory (Relation S):");

for(int i=0;i<Memory.length;i++)
{
  System.out.print("{  ");
  for(int j=0;j<2;j++)
{

  System.out.print(Memory[i][j]+"  ");
}
System.out.print("}");
System.out.println();
}




int rPointer=0;

for (int r=0;r<Rno; r+=2)
{
    
    System.out.print("\n \n Tuple present in Input Buffer:");
    for(int i=0;i<2;i++)
    {   
        System.out.print("{ ");
        for (int q=0;q<4;q++)
        {
      	  input_buffer[i][q]=R[rPointer][q];
      	  System.out.print(input_buffer[i][q]+" ");
        }
        rPointer++;
         System.out.print(" }");
         System.out.println();
    }
       
    
        int j=0;
    for (int t=0; t<2;t++)
    {
      for(j=0;j<Sno;j++)
    {

        //Step 3: Performing Join on the basis R(A)=S(A)
		if(input_buffer[t][0]==Memory[j][0])
      {
          
             for(int k=0;k<4;k++)
             {
                //Copy the tuple from input buffer into output buffer.
                output_buffer[OBPointer][k]=input_buffer[t][k];
             }
             output_buffer[OBPointer][4]=Memory[j][1];
             //move output buffer pointer to next available location.
             OBPointer++;
          
          //In case of full buffer, copy tuples from output buffer to disk storage.
          if(OBPointer>=(output_buffer.length))
          {
        
           
            System.out.println("\n Tuple(s) present in Output Buffer:");
            for(int i=0;i<output_buffer.length;i++)
            {
              System.out.print("{  ");
                for(j=0;j<5;j++)
                {

                    System.out.print(output_buffer[i][j]+"  ");
                    disk_storage[disk_pointer][j]=output_buffer[i][j];
                    flag=1;
                }

                System.out.print("}");
                System.out.println();

                disk_pointer++;
            }
            output_buffer=null;
            output_buffer = new String[3][5];
            OBPStateSave=OBPointer;
            OBPointer=0;
             System.out.println("\n Clearing Buffer to accomodate the next set of tuples.");

        }
    else{
         System.out.println("\n Tuple(s) present in Output Buffer:");
       
         for(int p=0;p<OBPointer;p++)
         {

             System.out.print("{  ");
            for(int q=0;q<5;q++)
            {
                 System.out.print(output_buffer[p][q]+"  ");

            }

            System.out.print("}");
            System.out.println();

         }

        }


      }//99

    }//96
    }
   
  }//80


   
 for(int c=0;c<OBPointer;c++)
 {
      for(int d=0;d<5;d++)
      {
        //Copying tuples from output buffer to disk storage.
        disk_storage[disk_pointer][d]=output_buffer[c][d];
        flag=1;
      }
      disk_pointer++;
}
    // No Input to process?
    if(flag==0)
    {
    System.out.println("\n No Input to process.");
    }

   

    System.out.println("\n \n \n Tuples in the disk after R JOIN S:");
    
  for(int i=0;i<disk_pointer;i++)
  {
    System.out.print("{ ");
    for(int j=0;j<5;j++)
  {
    System.out.print(disk_storage[i][j]+"  ");
  }
  System.out.print("}");
  System.out.println();
}


  }
}