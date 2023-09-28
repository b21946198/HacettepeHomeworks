#ifndef DoubleDynamicLinkedList_hpp
#define DoubleDynamicLinkedList_hpp

#include <iostream>
#include "Employee.hpp"
#include "PermanentEmployee.hpp"
using namespace std;                //That's for permanent ones
                                    //Order by Date of Appointment
                                    //Accessed by Employee Number
                                    //need head node
                                    //need these operations: add, delete, find, list

/*class Node
{
public:
    PermanentEmployee data;
    Node *next;
    Node *prev;
    PermanentEmployee& GetData() {return data;}
};*/

class DoubleDynamicLinkedList
{
public:
    class Node
    {
    public:
        PermanentEmployee data;
        Node *next;
        Node *prev;
        PermanentEmployee& GetData() {return data;}
        Node();
        Node(const PermanentEmployee& perm);
    };
    
    Node* head;
    DoubleDynamicLinkedList();
    DoubleDynamicLinkedList(const PermanentEmployee& perma);
    Node* getNewNode(const PermanentEmployee& permanentEmployee);
    void Insert(const PermanentEmployee& permanentEmployee);
    bool Find(int employeeNumber);
    PermanentEmployee& Get(int employeeNumber);
    void Update(PermanentEmployee& permanenetEmployee, string title, double salaryCoefficient);
    void Delete(int employeeNumber);
    void Display(int employeeNumber);
    
    
    friend ostream& operator<<(ostream& output, const DoubleDynamicLinkedList& list);           //implemented at cpp
    
};

ostream& operator<<(ostream& output, const DoubleDynamicLinkedList& list);

#endif
