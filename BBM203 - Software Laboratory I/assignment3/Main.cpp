#include "AutomatStack.hpp"
#include <string>
#include <fstream>
#include <vector>
#include <sstream>
#include <algorithm>

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

bool Exist(string element, vector<string> vect)     //typical check element function
{
    for(int i = 0; i < vect.size(); i++)
    {
        if(vect[i] == element)
            return true;
    }
    return false;
}

int main(int argc, char** argv)
{
    ifstream dpdaFile(argv[1]);
    string myString = "";
    myString = readFileIntoString(dpdaFile);                //read first input file
    vector<string> stringVector = getStringArray(myString);
    
    vector<string> states;
    vector<string> alphabet;                    //input vectors
    vector<string> stackAlphabet;
    vector<string> transitionRules;
    
    for(int i = 0; i < stringVector.size(); i++)
    {
        if(stringVector[i].find("Q:") != string::npos)
        {
         states.push_back(stringVector[i]);
         continue;
        }
        else if(stringVector[i].find("A:") != string::npos)
           {
            alphabet.push_back(stringVector[i]);
            continue;
           }
        else if(stringVector[i].find("Z:") != string::npos)
        {
            stackAlphabet.push_back(stringVector[i]);
            continue;
        }
        else if(stringVector[i].find("T:") != string::npos)
        {
            transitionRules.push_back(stringVector[i]);
            continue;
        }
    }       //complete and arrange inputs
    
    for(int i = 0; i < states.size(); i++)
    {
        states[i].erase(0,2);
    }
    for(int i = 0; i < alphabet.size(); i++)
    {
        alphabet[i].erase(0,2);
    }
    for(int i = 0; i < stackAlphabet.size(); i++)
    {
        stackAlphabet[i].erase(0,2);
    }
    for(int i = 0; i < transitionRules.size(); i++)
    {
        transitionRules[i].erase(0,2);
    }
    
    vector<string> tempVect;
    for(int i = 0; i < states.size(); i++)
    {
        stringstream ss(states[i]);
        string temp;
        while(getline(ss, temp, '='))
        {
            tempVect.push_back(temp);
        }
    }
    tempVect[1].erase(0, 2);
    
    vector<string> possibleStates;                           //this is possible states: [q0, q1, q2 , q3, q4]
    {
        stringstream ss(tempVect[0]);
        string temp;
        while(getline(ss, temp, ','))
        {
            possibleStates.push_back(temp);
        }
        std::string::iterator end_pos = std::remove(possibleStates[possibleStates.size()-1].begin(), possibleStates[possibleStates.size()-1].end(), ' ');
            possibleStates[possibleStates.size()-1].erase(end_pos, possibleStates[possibleStates.size()-1].end());
        
    }
  
    vector<string> fiStates;                                //this is initial and final states: [q0, q0, q1]    always have 3 elements 1st & 2nd init. state 3rd final state
    {
        stringstream ss(tempVect[1]);
        string temp;
        while(getline(ss, temp, ','))
        {
            fiStates.push_back(temp);
        }
    }
    
    for(int i = 0; i < fiStates.size(); i++)
    {
        for(int j = 0; j < fiStates[i].size(); j++)
        {
            if(fiStates[i][j] == '(' || fiStates[i][j] == ')' || fiStates[i][j] == '[' || fiStates[i][j] == ']')
            {
                fiStates[i].erase(j,1);
            }
        }
    }
    
    vector<string> finalAlphabet;                           //this is alphabet A: { ( } )
    {
        stringstream ss(alphabet[0]);
        string temp;
        while(getline(ss, temp, ','))
        {
            finalAlphabet.push_back(temp);
        }
    }

    vector<string> finalStackAlphabet;                      //this is stack alphabet Z: { ( $
    {
        stringstream ss(stackAlphabet[0]);
        string temp;
        while(getline(ss, temp, ','))
        {
            finalStackAlphabet.push_back(temp);
        }
    }
    
    vector<vector<string>> transitionFunctions;                 //this is functions' list T:  q0, e ,e, q1, { , ... ,                     always have 5 columns
    vector<string> tempVector;
    
    for(int i = 0; i < transitionRules.size(); i++)
    {
        stringstream ss(transitionRules[i]);
        string temp;
        while(getline(ss, temp, ','))
        {
            tempVector.push_back(temp);
        }
        transitionFunctions.push_back(tempVector);
        tempVector.clear();
    }
    
    ifstream inputFile(argv[2]);
    string inputString = "";
    inputString = readFileIntoString(inputFile);
    vector<string> inputVector = getStringArray(inputString);
    
    vector<vector<string>> finalInputVector;                    //this is inputs' list: { ( ( } , ( ( , ... ,
    vector<string> temporaryVect;
    
    for(int i = 0; i < inputVector.size(); i++)
    {
        stringstream ss(inputVector[i]);
        string temp;
        while(getline(ss, temp, ','))
        {
            temporaryVect.push_back(temp);
        }
        finalInputVector.push_back(temporaryVect);
        temporaryVect.clear();
    }
    
    ofstream outputFile(argv[3]);                           //output file
    
    AutomatonStack automatonStack;
    string initial_state = fiStates[1];                     //q0
    string final_state = fiStates[2];                       //q1
    string current_state = initial_state;
    
    string next_state;
    string current_input;
    string temp_output;
    
    for(int i = 0; i < transitionFunctions.size(); i++)
    {
        if ( (Exist(transitionFunctions[i][0], possibleStates)) && ((Exist(transitionFunctions[i][1], finalAlphabet)) || (transitionFunctions[i][1] == "e"))
        && ((Exist(transitionFunctions[i][2], finalStackAlphabet)) || (transitionFunctions[i][2] == "e"))
        && (Exist(transitionFunctions[i][3], possibleStates)) && ((Exist(transitionFunctions[i][4], finalStackAlphabet)) || (transitionFunctions[i][4] == "e")) )
        {}
        else
        {
            outputFile << "Error [1]:DPDA description is invalid!" << endl;     //error message to the output file when inputs are invalid
            exit(0);            //terminate the program
        }
    }


    bool flag = false;
    
    while(finalInputVector.size() != 0)
    {
        vector<string> tempVect = finalInputVector[0];
        current_state = initial_state;
        if(tempVect.size() == 0)
        {
            outputFile << "ACCEPT" << endl << endl;
            finalInputVector.erase(finalInputVector.begin());
            continue;
        }
        
        while(tempVect.size() != 0 && current_state != final_state)
        {
            for(int i = 0; i < transitionFunctions.size(); i++)
            {
                current_input = transitionFunctions[i][1];
                
                if(tempVect.size() == 0)
                {
                    for(int j = 0; j < transitionFunctions.size(); j++)
                    {
                        if(transitionFunctions[j][0] == current_state && transitionFunctions[j][1] == "e")
                        {
                            if(transitionFunctions[j][2] == automatonStack.Top())
                            {
                                automatonStack.Pop();
                            }
                            if(transitionFunctions[j][4] != "e")
                            {
                                automatonStack.Push(transitionFunctions[j][4]);
                            }
                            temp_output = transitionFunctions[j][0] + "," + transitionFunctions[j][1] + "," + transitionFunctions[j][2] + " => " + transitionFunctions[j][3] + "," + transitionFunctions[j][4] +    " [STACK]:" + automatonStack.WholeContent();
                            outputFile << temp_output << endl;
                            break;
                        }
                    }
                    
                    flag = true;
                    break;
                }
                
                if(transitionFunctions[i][0] == current_state && current_input == tempVect[0] && (transitionFunctions[i][2] == automatonStack.Top() || transitionFunctions[i][2] == "e"))
                {
                    if(transitionFunctions[i][2] == automatonStack.Top())
                        automatonStack.Pop();
                    
                    if(transitionFunctions[i][4] != "e")
                    {
                        automatonStack.Push(transitionFunctions[i][4]);
                    }
                    
                    temp_output = transitionFunctions[i][0] + "," + transitionFunctions[i][1] + "," + transitionFunctions[i][2] + " => " + transitionFunctions[i][3] + "," + transitionFunctions[i][4]
                    + " [STACK]:" + automatonStack.WholeContent();
                    
                    outputFile << temp_output << endl;
                    
                    current_state = transitionFunctions[i][3];
                    tempVect.erase(tempVect.begin());
                    i = 0;
                }

                else if(transitionFunctions[i][0] == current_state && current_input == "e")
                {
                    if(transitionFunctions[i][2] == automatonStack.Top())
                    {
                        automatonStack.Pop();
                    }
                    if(transitionFunctions[i][4] != "e")
                    {
                        automatonStack.Push(transitionFunctions[i][4]);
                    }
                    
                    temp_output = transitionFunctions[i][0] + "," + transitionFunctions[i][1] + "," + transitionFunctions[i][2] + " => " + transitionFunctions[i][3] + "," + transitionFunctions[i][4]
                    + " [STACK]:" + automatonStack.WholeContent();
                    
                    outputFile << temp_output << endl;
                    
                    current_state = transitionFunctions[i][3];
                    i = 0;
                }
            }
            temp_output = "";
            if(flag)
                break;
        }
        
        if((automatonStack.IsEmpty()) || ((automatonStack.Size() == 1) && (automatonStack.Top() == "$")))
        {
            outputFile << "ACCEPT" << endl << endl;
        }
        else
        {
            outputFile << "REJECT" << endl << endl;
        }
        
        finalInputVector.erase(finalInputVector.begin());
        automatonStack.Reset();     //reset whole stack before every new input
    }

    dpdaFile.close();
    inputFile.close();              //close all files for possible errors
    outputFile.close();
    
}
