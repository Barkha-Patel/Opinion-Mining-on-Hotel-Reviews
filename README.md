# Opinion-Mining-on-Hotel-Reviews

### ABSTRACT
This project titled “Opinion Mining in Hotel Reviews” has the objective of recognizing and extracting features / aspects from reviews. The said task is done by using Natural Language Processing and Data Mining concepts. 

### Why to do aspect/feature extraction?

Opinion mining, is the field of study that analyzes people’s opinions, sentiments, evaluations, appraisals, attitudes, and emotions towards entities such as products, services, organizations, individuals, issues, events, topics, and their attributes.
One purpose is to evaluate the perception of people on a specific entity or product. When a customer or user writes a review on a product he/she not only comments on the product as a whole but also on its specific features. For example: the product camera has features/ aspects like picture quality, appearance, customer service, clarity etc. Hence the task of knowing the various aspects that are associated with a product is very important in Opinion Mining.


### Existing methods

In 2004, Minqing Hu and Bing Liu [1] by association rule mining gathered frequent words which are nouns as features. Then based on the observation that people use adjectives with features to express their opinions these adjectives appearing near such words were extracted but this method often extracted noises i.e. wrong features and opinion words associated with features. 
Zhuang, jing and feng [2] generated a feature list with association rule mining like hu and liu and then generated an opinion word list by statistical results on labeled data. Then by using these two lists they found feature and opinion pairs in a sentence and then to avoid getting wrong features they checked if the pair is valid by using dependency grammar. Stanford Dependency parser’s [3] rules were used; if the pair satisfies any one of the below relations then it’s a valid pair.

Dependency relation template 
Feature word
Opinion word
NN - amod - JJ
NN 
JJ
NN - nsubj - JJ
NN
JJ
NN - nsubj - VB - dobj - NN
The ﬁrst NN 
The last NN
VB - advmod - RB
VB
RB


Guang Qiu, Bing Liu, Jiajun Bu, Chun Chen [4] gave the double propagation algorithm in which a list of opinion words accumulated through the experiment of hu and liu [1] was used as a seed lexicon. Then using dependency relations of minipar parser the features were extracted and then using these new found features other opinion words were found then these new words were used to find new features and this process continues until no new opinion word or feature is found. 
In 2014, Liu and he [5] performed feature extraction on Chinese language data. They used adverb based approach to get opinion words from reviews. They said that Chinese use adverbs to show the degree to which they feel. For example in English: “The phone is very good” here adverb ‘very’ is used with opinion word ‘good’. Thus they extracted adjectives following or preceding an adverb as an opinion word then based on the observation by hu and liu [1] that features are always near opinion words; used these opinion words to get the features(nouns) near them.
Other methods are based on topic models and machine learning concepts.

#### The method proposed:

First generate an opinion word list by adverb based approach where all the adjectives used with adverbs are extracted from the reviews. After that extract all sentences from the reviews having these opinion words. Then Stanford’s Dependency Parser is used and if the following relations are satisfied then accordingly the features are extracted.
Dependency relation template

Feature word
NN - nsubj - JJ
NN
NN - amod - JJ
NN
NN- nn-NN
Both NN
 
Examples :
⎝	NN - nsubj – JJ
“The phonefeature is very goodopinion “
--The dependency relations of the sentence--
det(phone-2, the-1) 
nsubj(good-5, phone-2)
cop(good-5, is-3)
advmod(good-5, very-4)
root(ROOT-0, good-5)

: hence phone is extracted


⎝	NN- nn –NN
This dependency is for features that are phrases like battery life, customer service etc.
“The battery lifefeature is remarkableopinion”

--The dependency relations of the sentence--

det(life-3, The-1)
nn(life-3, battery-2)
nsubj(remarkable-5, life-3)
cop(remarkable-5, is-4)
root(ROOT-0, remarkable-5)

: Hence battery life is extracted


Then do feature pruning i.e. refine the extracted features to get rid of noises.


### How the proposed method seems to be better:

In the double propagation algorithm [4] the opinion seed list that they use is by using a list obtained from past experiments and hence it lacks the ability of being standalone in addition to that the other disadvantage is that some opinion words may be redundant and hence resulting in futile searches; This happens because depending on different products the opinion words preferred by reviewers might change. 

Liu and he [5] used adverb based approach on Chinese language but their observation holds true for English language as well and thus by using this method we can generate an opinion list from the reviews we have. This obliterates both the disadvantages of using a seed list in double propagation algorithm mentioned above as it generates a list from the reviews present and as the list is generated from the reviews itself opinion words are product specific. 

In the double propagation method it was observed by the authors that due to the propagation i.e. obtaining features and then based on them new features and hence forth until no new features and opinions are found, the precision (words that are not features were also extracted) decreased While on the other hand by doing no propagation the recall was drastically low i.e. not all features were extracted. Hence they went with the propagation algorithm to have balanced precision and recall. This recall problem occurred because of the small seed list of opinion words and in that many words being redundant which was not sufficient enough to grab all features resulting in a low recall and need of using new found opinion words to grab new features (propagation method).

My proposed method may overcome this problem because as no extracted opinion word is redundant most of the features will be extracted hence giving a good precision as well as a better recall.

Plus by adding and using the dependency “NN-nn-NN” we can get feature phrases like battery life, customer service which was not the case in the previous methods where battery and life were considered as different features while in reality they both together form a single feature.



### The test Data:

The hotel reviews 
	Reviews :http://sifaka.cs.uiuc.edu/~wang296/Data/index.html 
	Annotation: http://nemis.isti.cnr.it/~marcheggiani/datasets/
Latest paper using it is [6 ] 




### References:

1.	Mining Opinion Features in Customer Reviews by Minqing Hu and  Bing Liu
2.	Movie Review Mining and Summarization by Li Zhuang, Feng Jing and Xiao-Yan Zhu 
3.	Stanford typed dependencies manual by Marie-Catherine de Marneffe and Christopher D. Manning
4.	Opinion Word Expansion and Target Extraction through Double Propagation by  Guang Qiu, Bing Liu, Jiajun Bu and Chun Chen
5.	Combining user preference and user opinions for accurate recommendation by hongyan Liu , Jun He, Tingting Wang, Wenting Song and xiaoyang Du.
6.	Opinion Mining and Summarization of Hotel Reviews by Vijay B. Raut, D.D. Londhe
