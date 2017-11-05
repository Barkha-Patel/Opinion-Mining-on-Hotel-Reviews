/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package research;
import java.io.IOException;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.util.*; 

/**
 *
 * @author Barkha
 */
public class pos {
 
 
    
        String mpos(List<String> s){
        String sample=new String();
        sample=s.toString();
        MaxentTagger tagger = new MaxentTagger("taggers/english-left3words-distsim.tagger");
        sample=sample.toLowerCase();
        sample=sample.replaceAll("[^a-zA-Z\\s]"," ");
        String tagged = tagger.tagString(sample);
        return tagged;
        
    }
            
            
    
    
}
