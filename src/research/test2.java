package research;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;



/*Copyright  Feliks Rozenberg

                  Licensed under the Apache License, Version 2.0 (the "License");
                  you may not use this file except in compliance with the License.
                  You may obtain a copy of the License at

                      http://www.apache.org/licenses/LICENSE-2.0

                  Unless required by applicable law or agreed to in writing, software
                  distributed under the License is distributed on an "AS IS" BASIS,
                  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
                  See the License for the specific language governing permissions and
                  limitations under the License.*/
                  
                  

public class test2
  
{
  
  public static void main(String[] args)
  {
    String fileName = ".txt";
    Scanner input = null;
    System.out.println("The program is reading the file...");
    
    //reading the file
    try
    {
      input = new Scanner (new File(fileName));
    }
    catch(FileNotFoundException e)
    {
      System.out.println("Could not open the file " + fileName);
      System.exit(0);
    }
    input.useDelimiter("\\Z");
    //storing the text as a string and then after removing whitespaces in an array
    String str = input.next();
    String[] word;
    word = str.split("\\s+");
    int textSize= word.length/3;
    //extracting the POS and Lemmas and storing in corresponding arrays
    String[] arrPOS = new String[textSize];
    String[] arrLemma = new String[textSize];
    //index for the POS
    int k=1;
    //index for the Lemmas
    int l=2;
    //the array for the POS
    for(int i=0; i<textSize; i++)
    {
      if( (k>=word.length) ||   (l>=word.length))
        break;
      arrPOS[i] = word[k];
      arrLemma[i] = word[l];
      l= l+3;
      k= k+3;
    }
    

    
    //user inputs the parts of speech and distance
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Please input the Part of Speech of the first word: ");
    String posX = keyboard.next();
    System.out.println("Please input the Part of Speech of the second word: ");
    String posY = keyboard.next();
    System.out.println("Please input the maximal distance between the words: ");
    int d = keyboard.nextInt();
    String[] arrTmp = arrLemma.clone();
    List<String> lemmas = Arrays.asList(arrTmp);
    HashMap<String, Integer> lemmasCount = new HashMap<String, Integer>();
    HashMap<String, Integer[]> mapo11 = new HashMap <String, Integer[]>();
    Collections.sort(lemmas);
    System.out.println("The program is extracting collocations from a corpus. This might take a few minutes...Facebook is not any faster either! ");
    outer:  for (int i=0; i<arrPOS.length; i++)
    { 
      if (arrPOS[i].equals(posX))
      for (int j=i+1; j<d+i+1; j++)
      {
        if (j>=arrPOS.length) continue outer;
        if( (arrPOS[i].equals(posX)) && (arrPOS[j].equals(posY)))
        {
          String o11 = arrLemma[i]+ " "+ arrLemma[j];
          // if (o11.equals("new year"))
          //System.out.println(i +  " " +  arrLemma[i] + " " +j + " "+ arrLemma[j] + " " + posX + " " + posY);
          if (mapo11.containsKey(o11))
          {
            //System.out.println(o11);
            Integer[] arr = mapo11.get(o11);
            arr[0] += 1;
            
            mapo11.put(o11, arr);
          }
          else 
          {

            Integer[] counters = new Integer[3];
            counters[0]=1;
            if(!lemmasCount.containsKey(arrLemma[i]))
            {
            counters[1]=countLemma(arrLemma[i], lemmas, lemmasCount);
            lemmasCount.put(arrLemma[i], counters[1]);
            }
            else
             counters[1]= lemmasCount.get(arrLemma[i]);
            
            if(!lemmasCount.containsKey(arrLemma[j]))
            {
                counters[2]=countLemma(arrLemma[j], lemmas, lemmasCount);
                lemmasCount.put(arrLemma[j], counters[2]);
            }
                else
                 counters[2]= lemmasCount.get(arrLemma[j]);
            
            mapo11.put(o11, counters);
          }
        }
      }
      else continue outer;
    } 
    
    //calculating t statistics
    HashMap<String, Double> tStats = new HashMap<String,Double>();
    System.out.println("Calculating t statistics... ");
    tStatistic(mapo11, tStats, textSize);
    System.out.println("Sorting the results for t statistics... ");
    LinkedHashMap<String, Double> ordered = new LinkedHashMap<String, Double>();
    ordered = sortHashMapByValues(tStats, false);
    Set ref = ordered.keySet();
    Iterator it = ref.iterator();
    int countTop10=0;
    while (it.hasNext()) 
    {
     if (countTop10==10)
      break;
     String wordKey = (String)it.next();
     System.out.println("The collocation: " + wordKey + " and the t statistic is: " + ordered.get(wordKey));
     countTop10++;
    }
    
   //calculating x2 score
    HashMap<String, Double> x2scoreStats = new HashMap<String,Double>();
    System.out.println("Calculating x2 score... ");
    x2score(mapo11, x2scoreStats, textSize);
    System.out.println("Sorting the results for x2 score... ");
    LinkedHashMap<String, Double> orderedX2Score = new LinkedHashMap<String, Double>();
    orderedX2Score = sortHashMapByValues(x2scoreStats, false);
    Set ref2 = orderedX2Score.keySet();
    Iterator it2 = ref2.iterator();
    countTop10=0;
    while (it2.hasNext()) 
    {
     if (countTop10==10)
      break;
     String wordKey = (String)it2.next();
     System.out.println("The collocation: " + wordKey + " and the x2 score is: " + orderedX2Score.get(wordKey));
     countTop10++;
    } 
    
    //calculating log likelihood ratio
    HashMap<String, Double> logs = new HashMap<String,Double>();
    System.out.println("Calculating log likelihood ratios... ");
    logRatio(mapo11, logs, textSize);
    System.out.println("Sorting the results for log likelihood ratios... ");
    LinkedHashMap<String, Double> orderedLogs = new LinkedHashMap<String, Double>();
    orderedLogs = sortHashMapByValues(logs, false);
    Set ref3 = orderedLogs.keySet();
    Iterator it3 = ref3.iterator();
    countTop10=0;
    while (it3.hasNext()) 
    {
     if (countTop10==10)
      break;
     String wordKey = (String)it3.next();
     System.out.println("The collocation: " + wordKey + " and the log likelihood ratio is: " + orderedLogs.get(wordKey));
     countTop10++;
    }
    
    
    //calculating the pointwise mutual information
    HashMap<String, Double> pmis = new HashMap<String,Double>();
    System.out.println("Calculating the pointwise mutual information scores... ");
    pmi(mapo11, pmis, textSize);
    System.out.println("Sorting the results for the pointwise mutual information scores... ");
    LinkedHashMap<String, Double> orderedPMI = new LinkedHashMap<String, Double>();
    orderedPMI = sortHashMapByValues(pmis, false);
    Set ref4 = orderedPMI.keySet();
    Iterator it4 = ref4.iterator();
    countTop10=0;
    while (it4.hasNext()) 
    {
     if (countTop10==10)
      break;
     String wordKey = (String)it4.next();
     System.out.println("The collocation: " + wordKey + " and the pointwise mutual information score is: " + orderedPMI.get(wordKey));
     countTop10++;
    }
    
    
  }
  
  //a method to count the number of occurence of lemmas
  public static int countLemma(String lemma, List<String> arrayLemma, HashMap<String, Integer> lemmasCount)
  {
    int firstOccurence = arrayLemma.indexOf(lemma);
    //System.out.println("First occurence: " + firstOccurence);
    int lastOccurence = arrayLemma.lastIndexOf(lemma);
//System.out.println("Last occurence: " + lastOccurence);
    int count = lastOccurence - firstOccurence + 1;
    //lemmasCount.put(lemma, count);
    return count;
  }
  
  //a method to compute the t statistic 
  private static void tStatistic(HashMap<String,Integer[]> data, HashMap<String,Double> results, int textSize)
  {
   Collection c = data.keySet();
   Iterator itr = c.iterator();
   while (itr.hasNext())
   {
    String key = (String) itr.next();
    Integer[] o = data.get(key);
    double o11= o[0];
    double o_1= o[1];
    double o1_= o[2];
    
    double e11 = (o1_*o_1)/textSize;
    double t=(o11-e11)/Math.sqrt(o11);
    results.put(key, t);
   }
   
  }
  
  private static void x2score(HashMap<String,Integer[]> data, HashMap<String,Double> results, int textSize)
  {
   Collection c = data.keySet();
    Iterator itr = c.iterator();
    while (itr.hasNext())
    {
     String key = (String) itr.next();
      Integer[] o = data.get(key);
      double o11= o[0];
      double o_1= o[1];
      double o1_= o[2];
      double o12= o1_ - o11;
      double o21= o_1 - o11;
      double o22= textSize - o1_ - o21;
      double e11= (o_1*o1_)/textSize;
      double e12= (o1_*(textSize-o_1))/textSize;
      double e21= ((textSize-o1_) * (o_1) )/textSize; 
      double e22= (textSize-o1_) * (textSize-o_1)/textSize;
      
      double x2= ((Math.pow((o11-e11),2))/e11) + ((Math.pow((o12-e12),2))/e12) + ((Math.pow((o21-e21),2))/e21)
      + ((Math.pow((o22-e22),2))/e22);
      
      results.put(key, x2);
     
    }
   
  }
  
//a method to compute the log likelihood ratios
  private static void logRatio(HashMap<String,Integer[]> data, HashMap<String,Double> results, int textSizeI)
  {
   Collection c = data.keySet();
   Iterator itr = c.iterator();
   while (itr.hasNext())
   {
    String key = (String) itr.next();
    Integer[] o = data.get(key);
    double textSize = textSizeI;
    double o11= o[0];
    double o_1= o[1];
    double o1_= o[2];
    double o12= o1_ - o11;
    double o21= o_1 - o11;
    double o22= textSize - o1_ - o21;
    double e11 = (o1_*o_1)/textSize;
    double e12= (o1_*(textSize-o_1))/textSize;
    double e21= ((textSize-o1_) * (o_1) )/ textSize; 
    double e22= (textSize-o1_) * (textSize-o_1)/textSize;
    
//    double error = Math.log10(o12/e12);
//    double error2 = Math.log10(o21/e21);
//    double error3 = Math.log10(o22/e22);
    
    //System.out.println("o21: " + o21);
   
    if (o12==0)
      o12++;
    
    if (o21==0)
      o21++;
    
    if (o22==0)
      o22++;
    
    double l = 2*((o11*Math.log10(((o11)/e11))) +(o12*Math.log10((o12)/e12))+(o21*Math.log10(((o21)/e21)))+(o22*Math.log10(((o22)/e22))));
    results.put(key, l);
    
    
   }
   
  }
  
  //a method to compute the pointwise mutual information score
  private static void pmi(HashMap<String,Integer[]> data, HashMap<String,Double> results, int textSize)
  {
   Collection c = data.keySet();
   Iterator itr = c.iterator();
   while (itr.hasNext())
   {
    String key = (String) itr.next();
    Integer[] o = data.get(key);
    double o11= o[0];
    double o_1= o[1];
    double o1_= o[2];
    
    double e11 = (o1_*o_1)/textSize;
    double mi= Math.log10( o11/e11);
    results.put(key, mi);
   }
   
  }
  
  //a method to sort the results by descending order
  public static LinkedHashMap<String, Double> sortHashMapByValues(HashMap passedMap, boolean ascending) 
  {

     List mapKeys = new ArrayList(passedMap.keySet());
   List mapValues = new ArrayList(passedMap.values());
   Collections.sort(mapValues);
   Collections.sort(mapKeys);

   if (!ascending)
   Collections.reverse(mapValues);

   LinkedHashMap someMap = new LinkedHashMap();
   Iterator valueIt = mapValues.iterator();
   while (valueIt.hasNext()) 
   {
   Object val = valueIt.next();
   Iterator keyIt = mapKeys.iterator();
    while (keyIt.hasNext()) 
    {
    Object key = keyIt.next();
     if (passedMap.get(key).toString().equals(val.toString())) 
     {
     passedMap.remove(key);
     mapKeys.remove(key);
     someMap.put(key, val);
     break;
     }
    }
   }
   return someMap;
   } 
  
}