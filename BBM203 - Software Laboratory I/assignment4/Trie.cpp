#include "Trie.hpp"

TrieNode* getNode(void)
{
    TrieNode* pNode = new TrieNode;
    pNode->isWord = false;
    pNode->value = "";
    
    for(int i = 0; i < ALPHABET_SIZE; i++)
    {
        pNode->children[i] = NULL;
    }
    
    return pNode;
}


void Trie::Insert(string key, string value)
{
    TrieNode* temp = root;
    
    for(int i = 0; i < key.length(); i++)
    {
        int index = key[i] - 'a';
        
        if(!temp->children[index])
            temp->children[index] = getNode();
        
        temp = temp->children[index];
    }
    
    temp->isWord = true;
    temp->value = value;
}


bool Trie::Search(string key)
{
    TrieNode* temp = root;
    
    for(int i = 0; i < key.length(); i++)
    {
        int index = key[i] - 'a';
        if(!temp->children[index])
            return false;
        
        temp = temp->children[index];
    }
    
    return temp->isWord;
}


bool Trie::SearchHelper(string key)
{
    TrieNode* temp = root;
    
    for(int i = 0; i < key.length(); i++)
    {
        int index = key[i] - 'a';
        if(!temp->children[index])
            return false;
        
        temp = temp->children[index];
    }
    
    return true;
}


bool Trie::SearchSupporter(string key)
{
    TrieNode* temp = root;
    
    for(int i = 0; i < key.length(); i++)
    {
        int index = key[i] - 'a';
        if(!temp->children[index])
            return false;
        
        temp = temp->children[index];
    }
    
    return true;
}


bool Trie::CheckFirstLetter(string s)
{
    TrieNode* temp = root;
    
    for(int i = 0; i < s.length(); i++)
    {
        int index = s[i] - 'a';
        if(!temp->children[index])
            return false;
        
        temp = temp->children[index];
    }
    
    return true;
}


string Trie::GetValue(string key)
{
    if(Search(key))
    {
        TrieNode* temp = root;
        
        for(int i = 0; i < key.length(); i++)
        {
            int index = key[i] - 'a';
            temp = temp->children[index];
        }
        return temp->value;
    }
    
    else
        return "$";                 //this represents empty string
        
}


bool Trie::isEmpty(TrieNode* temp)
{
    for(int i = 0; i < ALPHABET_SIZE; i++)
    {
        if(temp->children[i])
            return false;
    }
    
    return true;
}


TrieNode* Trie::Remove(TrieNode* temp, string key, int level = 0)
{
    if(!temp)
        return NULL;
    
    if(level == key.size())
    {
        if(temp->isWord)
            temp->isWord = false;
        
        if(isEmpty(temp))
        {
            delete temp;
            temp = NULL;
        }
        
        return temp;
    }
    
    int idx = key[level] - 'a';
    
    temp->children[idx] = Remove(temp->children[idx], key, level + 1);
    
    if(isEmpty(temp) && temp->isWord == false)
    {
        delete temp;
        temp = NULL;
        
    }
    
    return temp;
}


bool Trie::isWordNode(TrieNode* temp)
{
    return temp->isWord != false;
}


void Trie::List(TrieNode* temp, string str, int level)
{
    static string stt;
    if(isWordNode(temp))
    {
        //str[level] = '\0';
        strVector.push_back(stt);
        if(temp->children[0])
            List(temp->children[0], stt, level + 1);
        stt.clear();
    }
    
    for(int i = 0; i < ALPHABET_SIZE; i++)
    {
        if(temp->children[i])
        {
            stt += i + 'a';
            List(temp->children[i], stt, level + 1);
        }
    }
}


void Trie::Display(TrieNode* temp, char* str, int level, ofstream& outputFile)
{
    if(isWordNode(temp))
    {
        str[level] = '\0';
        string myString;
        myString.assign(str);
        outputFile << myString << "(" << GetValue(myString) << ")" << endl;
    }
    
    for(int i = 0; i < ALPHABET_SIZE; i++)
    {
        if(temp->children[i])
        {
            str[level] = i + 'a';
            Display(temp->children[i], str, level + 1, outputFile);
        }
    }
}


void Trie::ClearIt()
{
    strVector.clear();
}


void Trie::ClearMyVector()
{
    tempVector.clear();
}


void Trie::Destroy(TrieNode* temp)
{
    if(temp != NULL)
    {
        delete temp;
        return;
    }
    
    for(TrieNode* child : temp->children)
    {
        Destroy(child);
    }
}


Trie::~Trie()                               //destructor for not leaking the memory
{
    Destroy(root);
}
