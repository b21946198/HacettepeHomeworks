#ifndef CircularArrayLinkedList_hpp
#define CircularArrayLinkedList_hpp

#include <iostream>
#include "Employee.hpp"
#include "TemporaryEmployee.hpp"
#include <vector>
using namespace std;                //That's for temporary ones
                                    //Order by Employee Number
                                    //Accessed by Employee Number
                                    //need head node
                                    //need these operations: insert, delete, find, list
#define MAX_SIZE 20


class CircularArrayLinkedList
{
private:
    //TemporaryEmployee CLLArray[MAX_SIZE];
    int head2;
    int avail = 0;
    
public:
    vector<TemporaryEmployee> CLLArray;
    void Insert(const TemporaryEmployee& temporaryEmployee);
    bool Find(int employeeNumber);
    TemporaryEmployee& Get(int employeeNumber);
    void Update(TemporaryEmployee& temporaryEmployee, string title, double salaryCoefficient);
    void Delete(int employeeNumber);
    void Display(int employeeNumber);
    int GetHead() const {return head2;}
    int GetAvail() const {return avail;}
    friend ostream& operator<<(ostream& output, const CircularArrayLinkedList& list);
};


ostream& operator<<(ostream& output, const CircularArrayLinkedList& list);


#endif
