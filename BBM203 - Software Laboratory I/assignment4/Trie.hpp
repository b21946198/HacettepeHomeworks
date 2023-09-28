#ifndef Trie_hpp
#define Trie_hpp

#include <vector>
#include <string>
#include <fstream>
#include <sstream>
#include <algorithm>

using namespace std;

const int ALPHABET_SIZE = 26;

class TrieNode
{
public:
    char c;
    bool isWord;
    TrieNode* children[ALPHABET_SIZE];
    string value;
    
};

TrieNode* getNode(void);


class Trie
{
public:
    TrieNode* root = getNode();
    vector<string> strVector;
    vector<char*> tempVector;
    
    
public:
    
    void Insert(string key, string value);
    
    bool Search(string key);                    //main search function
    
    bool SearchHelper(string key);              //some helper functions to edge cases
    
    bool SearchSupporter(string key);           //some helper functions to edge cases
    
    bool CheckFirstLetter(string s);            //some helper functions to edge cases
    
    string GetValue(string key);
    
    TrieNode* Remove(TrieNode* temp, string key, int level);
    
    bool isEmpty(TrieNode* temp);
    
    bool isWordNode(TrieNode* temp);                //check whether a key has a value
    
    void List(TrieNode* temp, string str, int level);
    
    void Display(TrieNode* temp, char* str, int level, ofstream& outputFile);
    
    void ClearIt();
    
    void ClearMyVector();
    
    void Destroy(TrieNode* temp);
    
    ~Trie();
};

#endif
