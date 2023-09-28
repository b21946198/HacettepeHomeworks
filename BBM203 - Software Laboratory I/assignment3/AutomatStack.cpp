#include "AutomatStack.hpp"


AutomatonStack::AutomatonStack()
{
    top = -1;
}

void AutomatonStack::Push(string x)            //add an element to the top of the list
{
    if(top == MAX_SIZE -1) return;
    
    A[++top] = x;
}

void AutomatonStack::Pop()                  //remove top element of the stack
{
    if(top == -1) return;
    
    top--;
}

string AutomatonStack::Top()                   //return top value of the stack
{
    if(top == -1) return "e";
    return A[top];
}

bool AutomatonStack::IsEmpty()              //check whether stack is empty
{
    return top == -1;
}

void AutomatonStack::Reset()                //reset the stack for next process
{
    top = -1;
}

void AutomatonStack::Display()              //or write to the file
{
    if(top == -1) return;
    int temp = top;
    for(; temp >= 0; temp--)
    {
        cout << A[temp] << " ";
    }
    cout << endl;
}

int AutomatonStack::Size()                 //return size of the stack
{
    int temp = 0;
    for(int i = 0; i <= top; i++)
    {
        temp++;
    }
    return temp;
}

bool AutomatonStack::Find(string st)            //return true if that element in the stack otherwise false
{
    for(int i = 0; i <= top; i++)
    {
        if (A[i] == st) {
            return true;
        }
    }
    return false;
}

string AutomatonStack::WholeContent()       //return whole content of the stack as string
{
    string str;
    for(int i = 0; i <= top; i++)
    {
        if(i == top)
        {
            str += A[i];
            break;
        }
        str += A[i] + ",";
    }
    return str;
}
