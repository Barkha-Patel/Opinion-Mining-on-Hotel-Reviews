package research;
import java.util.Collection;
import java.util.List;
import java.io.StringReader;

import edu.stanford.nlp.process.Tokenizer;
import edu.stanford.nlp.process.TokenizerFactory;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import java.util.ArrayList;

class test3 {
    

  /**
   * The main method demonstrates the easiest way to load a parser.
   * Simply call loadModel and specify the path of a serialized grammar
   * model, which can be a file, a resource on the classpath, or even a URL.
   * For example, this demonstrates loading a grammar from the models jar
   * file, which you therefore need to include on the classpath for ParserDemo
   * to work.
   *
   * Usage: {@code java ParserDemo [[model] textFile]}
   * e.g.: java ParserDemo edu/stanford/nlp/models/lexparser/chineseFactored.ser.gz data/chinese-onesent-utf8.txt
   *
   */
  

  /**
   * demoDP demonstrates turning a file into tokens and then parse
   * trees.  Note that the trees are printed by calling pennPrint on
   * the Tree object.  It is also possible to pass a PrintWriter to
   * pennPrint if you want to capture the output.
   * This code will work with any supported language.
   */
  

  /**
   * demoAPI demonstrates other ways of calling the parser with
   * already tokenized text, or in some cases, raw text that needs to
   * be tokenized as a single sentence.  Output is handled with a
   * TreePrint object.  Note that the options used when creating the
   * TreePrint can determine what results to print out.  Once again,
   * one can capture the output by passing a PrintWriter to
   * TreePrint.printTree. This code is for English.
   */
  public String demoAPI(LexicalizedParser lp,String s) {
  // This option shows parsing a list of correctly tokenized words
/* String[] sent = { "This", "movie", "is", "a", "masterpiece", "." };
    List<CoreLabel> rawWords = Sentence.toCoreLabelList(sent);
    Tree parse = lp.apply(rawWords);
    ArrayList ar=parse.taggedYield();
    System.out.println(ar.toString());
    parse.pennPrint();
    System.out.println(); */
    // This option shows loading and using an explicit tokenizer
 //  String sent2 = " Does the player play dvd with audio and video? ";
    TokenizerFactory<CoreLabel> tokenizerFactory =
        PTBTokenizer.factory(new CoreLabelTokenFactory(), "");
    Tokenizer<CoreLabel> tok =
        tokenizerFactory.getTokenizer(new StringReader(s));
    List<CoreLabel> rawWords2 = tok.tokenize();
    Tree  parse = lp.apply(rawWords2);
    ArrayList ar=parse.taggedYield();
    //System.out.println(ar.toString());
    String st=ar.toString();
    

    TreebankLanguagePack tlp = lp.treebankLanguagePack(); // PennTreebankLanguagePack for English
    GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory();
    GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
    List<TypedDependency> tdl = gs.typedDependenciesCCprocessed();
    st=st+"$$"+tdl;
    return st;
    
/*
    //You can also use a TreePrint object to print trees and dependencies
  TreePrint tp = new TreePrint("penn,typedDependenciesCollapsed");
    tp.printTree(parse);*/
        
  }
  public static void main(String[] args) {
   
    test3 t3=new test3();
    String re;
    String parserModel = "edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz";
LexicalizedParser lp = LexicalizedParser.loadModel(parserModel);
    
      re=t3.demoAPI(lp,"after several years of torture in the hands of at&t customer service i am delighted to drop them , and look forward to august 2004 when i will convert our other 3 family-phones from at&t to t-mobile.  ");
      System.out.println(re);
    }
  }


