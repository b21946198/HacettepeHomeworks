#ifndef AutomatStack_hpp
#define AutomatStack_hpp
#include <stdio.h>
#include <iostream>
using namespace std;
#define MAX_SIZE 200

//Interface for Stack class
class AutomatonStack
{
    
private:
    string A[MAX_SIZE];
    int top;
    
public:
    AutomatonStack();
    void Push(string x);
    void Pop();
    string Top();
    bool IsEmpty();
    void Reset();
    void Display();
    int Size();
    bool Find(string st);
    string WholeContent();
};

#endif
