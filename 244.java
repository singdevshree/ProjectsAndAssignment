package BagIntersection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class BagIntersection
{

        public static void main(String[] args)
        {
            ArrayList<List<String>> R = new ArrayList<List<String>>();
            ArrayList<List<String>> S = new ArrayList<List<String>>();
            Map<List<String>, Integer> disk_storage = new HashMap<>();
            
            
            R.add(Arrays.asList(new String []{"jim"}));
            R.add(Arrays.asList(new String []{"tom"}));
            R.add(Arrays.asList(new String []{"tom"}));
            R.add(Arrays.asList(new String []{"marc"}));
            
            S.add(Arrays.asList(new String []{"jim"}));
            S.add(Arrays.asList(new String []{"tom"}));
            S.add(Arrays.asList(new String []{"tony"}));
            S.add(Arrays.asList(new String []{"marc"}));
            
            int index =0;
                    
            
            //Checking the condition specified and takes tuples as input for relations: B(R) > M > B(S)
            
            
                Map<List<String>, Integer> sMemory = new HashMap<>();
                Map<List<String>, Integer> output = new HashMap<>();
                
                
                   
            
            //Read S into M-1 buffer, associate with each distinct tuple a count:
                        for(List<String> i : S)
                        {
                            
                             sMemory.put(i, index);
                             index++;
                            
                        }
                        System.out.println("\n");
                        System.out.println("Relation R : "+R);
                        System.out.println("Relation S : "+S);
                        System.out.println("\n");
                        System.out.println("S in Memory  : "+sMemory.keySet());
            
            //Read a tuple t of R:
                //If t occur in S, then we copy t to the output.
                    
                        for(List<String> rMemory : R)
                        {
                            System.out.println("\nLooking for tuple of R from memory: "+rMemory +" in the S in Memory. ");
                            if(sMemory.containsKey(rMemory))
                            { 
                                
                                output.put(rMemory,output.get(rMemory) == null ? 1 : output.get(rMemory) + 1);
                            }
                         System.out.println("Processing within Memory");
                        System.out.println("S in Memory  : "+sMemory.keySet());
                        System.out.println("Output Buffer"+output.keySet());
                        }
            
                       //Moving to disk storage when output buffer is full
                        int num=0;
                        if (output.size()>2)
                            {
                            for(List<String> i : output.keySet())
                        {
                            
                             disk_storage.put(i, num);
                             num++;
                            
                        }
                        }
                        System.out.println("\n");
                        System.out.println("Bag Intersection R n S in Disk Storage:");
                        System.out.println(disk_storage.keySet());
            
            
            
        
        }

                    
        
}