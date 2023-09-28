#include "Trie.hpp"

string readFileIntoString(ifstream& inputFile)      //convert input content to one string
{
    return string((istreambuf_iterator<char>(inputFile)), istreambuf_iterator<char>());
}

vector<string> getStringArray(string my_string)     //convert file content into an array line by line
{
    vector<string> string_vector;
    stringstream ss(my_string);
    string temp;
    while(getline(ss, temp, '\n')){
        string_vector.push_back(temp);
      }
    return string_vector;
}


int main(int argc, char** argv)
{
    ifstream inputFile(argv[1]);
    string myString = "";
    myString = readFileIntoString(inputFile);                   //reading the input file with bunch of functions
    vector<string> stringVector = getStringArray(myString);
    
    
    vector<string> tempVect;
    
    Trie trie;          //instantiate trie data structure
    
    ofstream outputFile(argv[2]);       //output file for write data
    
    
    for(int i = 0; i < stringVector.size(); i++)
    {
        
        char firstLetter = stringVector[i][7];
        string firstStringLetter(1, firstLetter);
        
        if(stringVector[i].find("insert") != string::npos)
        {
            stringVector[i].erase(0, 7);
            stringVector[i].pop_back();
            string temp;
            stringstream ss(stringVector[i]);
            
            while(getline(ss, temp, ','))
                tempVect.push_back(temp);
            
            
            string key = tempVect[0];                   //this one's gonna use
            string value = tempVect[1];                 //this one's gonna use
                        
            if(trie.Search(key) && value == trie.GetValue(key))             //insert the word to the trie
            {
                outputFile << "\"" << key << "\"" << " already exist" << endl;
                
            }
            else if(trie.Search(key) && value != trie.GetValue(key))
            {
                trie.Insert(key, value);
                outputFile << "\"" << key << "\"" << " was updated" << endl;
            }
            else
            {
                trie.Insert(key, value);
                outputFile << "\"" << key << "\"" << " was added" << endl;
            }
            
            tempVect.clear();               //after every iteration clear the tempVect in order to avoid wrong words
            
        }
        
        
        else if(stringVector[i].find("search") != string::npos)
        {
            stringVector[i].erase(0, 7);
            stringVector[i].pop_back();
            
            string key = stringVector[i];           //this one's gonna use
            
            
            if(trie.SearchHelper(key) && trie.GetValue(key) == "$")               //all characters are in the trie but not have value
            {
                outputFile << "\"not enough Dothraki word\"" << endl;
            }
            else if(!trie.SearchSupporter(key) && trie.GetValue(key) == "$" && trie.CheckFirstLetter(firstStringLetter))       //for some point some characters are in the trie but other ones are not
            {
                outputFile << "\"incorrect Dothraki word\"" << endl;
            }
            else if(!trie.Search(key))              //if no character in the trie
            {
                outputFile << "\"no record\"" << endl;
            }
            else                                        //otherwise search the value and return its value
            {
                outputFile << "\"The English equivalent is " << trie.GetValue(key) << "\"" << endl;
            }
            
        }
        
        
        else if(stringVector[i].find("delete") != string::npos)
        {
            stringVector[i].erase(0,7);
            stringVector[i].pop_back();
            
            
            string key = stringVector[i];           //this one's gonna use
            
            
            if(trie.SearchHelper(key) && trie.GetValue(key) == "$")               //all characters are in the trie but not have value
            {
                outputFile << "\"not enough Dothraki word\"" << endl;
            }
            else if(!trie.SearchSupporter(key) && trie.GetValue(key) == "$" && trie.CheckFirstLetter(firstStringLetter))       //for some point some characters are in the trie but other ones are not
            {
                outputFile << "\"incorrect Dothraki word\"" << endl;
            }
            else if(!trie.Search(key))                //if no character in the trie
            {
                outputFile << "\"no record\"" << endl;
            }
            else
            {
                TrieNode* temp = trie.root;
                trie.Remove(temp, key, 0);                                                          //delete the key recursively
                outputFile << "\"" << key << "\"" << " deletion is successful" << endl;
            }
        }
        
        
        else if(stringVector[i].find("list") != string::npos)
        {
            TrieNode* temp = trie.root;
            int level = 0;
            char str[45];
            
            trie.Display(temp, str, level, outputFile);
        }
    }
    
}
