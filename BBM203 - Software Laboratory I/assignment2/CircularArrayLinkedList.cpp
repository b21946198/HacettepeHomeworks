#include "CircularArrayLinkedList.hpp"


void CircularArrayLinkedList::Insert(const TemporaryEmployee& temporaryEmployee)
{
    if(head2 == -1)
    {
        head2 = 0;
        CLLArray[0] = temporaryEmployee;
        avail++;
        return;
    }
    CLLArray.push_back(temporaryEmployee);
    //CLLArray[avail] = temporaryEmployee;
    avail++;
    /*if(avail > MAX_SIZE - 1)
    {
        avail = (avail + MAX_SIZE) % MAX_SIZE;
    }*/
}

bool CircularArrayLinkedList::Find(int employeeNumber)
{
    for(int i = 0; i < MAX_SIZE; i++)
    {
        if(CLLArray[i].GetEmployeeNumber() == employeeNumber)
        {
            return true;
        }
    }
    return false;
}

TemporaryEmployee& CircularArrayLinkedList::Get(int employeeNumber)
{
    for(int i = 0; i < MAX_SIZE; i++)
    {
        if(CLLArray[i].GetEmployeeNumber() == employeeNumber)
        {
            return CLLArray[i];
        }
    }
    return CLLArray[head2];
}

void CircularArrayLinkedList::Update(TemporaryEmployee& temporaryEmployee, string title, double salaryCoefficient)
{
    temporaryEmployee.SetTitle(title);
    temporaryEmployee.SetSalaryCoefficient(salaryCoefficient);
}

void CircularArrayLinkedList::Delete(int employeeNumber)
{
    for(int i = 0; i < avail; i++)
    {
        if(CLLArray[i].GetEmployeeNumber() == employeeNumber)
        {
            if(i == 0) head2++;
            for(int j = i + 1; j < avail; j++)
            {
                CLLArray[j] = CLLArray[j-1];
            }
        }
    }
}

void CircularArrayLinkedList::Display(int employeeNumber)
{
    for(int i = 0; i <= avail; i++)
    {
        if(CLLArray[i].GetEmployeeNumber() == employeeNumber)
        {
            cout << CLLArray[i] << endl;
        }
    }
}

ostream& operator<<(ostream& output, const CircularArrayLinkedList& list)
{
    for(int i = 0; i < MAX_SIZE; i++)
    {
        cout << list.CLLArray[i] << endl;
    }
    return output;
}
