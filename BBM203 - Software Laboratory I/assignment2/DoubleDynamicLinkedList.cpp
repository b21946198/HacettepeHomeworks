#include "DoubleDynamicLinkedList.hpp"


DoubleDynamicLinkedList::Node::Node(){}

DoubleDynamicLinkedList::Node::Node(const PermanentEmployee& perm) : data(perm), next(NULL), prev(NULL) {}

DoubleDynamicLinkedList::Node* DoubleDynamicLinkedList::getNewNode(const PermanentEmployee& permanentEmployee)
{
    Node* newNode = new Node(permanentEmployee);
    newNode->prev = NULL;
    newNode->next = NULL;
    return newNode;
}
DoubleDynamicLinkedList::DoubleDynamicLinkedList()
{
    head = NULL;
}


void DoubleDynamicLinkedList::Insert(const PermanentEmployee& permanentEmployee)
{
    //Node* temp = getNewNode(permanentEmployee);
    Node* temp = new Node(permanentEmployee);
    if(head == NULL)
    {
        head = temp;
        //cout << head->data;
        return;
    }
    
    head->prev = temp;
    temp->next = head;
    head = temp;
    //cout << temp->data;
}

bool DoubleDynamicLinkedList::Find(int employeeNumber)
{
    Node* temp = head;
    while (temp != NULL)
    {
        if(temp->data.GetEmployeeNumber() == employeeNumber)
        {
            return true;
        }
        temp = temp->next;
    }
    return false;
}

PermanentEmployee& DoubleDynamicLinkedList::Get(int employeeNumber)
{
    Node* temp = head;
    while(temp != NULL)
    {
        if(temp->data.GetEmployeeNumber() == employeeNumber)
        {
            return temp->data;
        }
        temp = temp->next;
    }
    return head->data;
}

void DoubleDynamicLinkedList::Update(PermanentEmployee& permanentEmployee, string title, double salaryCoefficient)
{
    permanentEmployee.SetTitle(title);
    permanentEmployee.SetSalaryCoefficient(salaryCoefficient);
}

void DoubleDynamicLinkedList::Delete(int employeeNumber)
{
    if(head == NULL) return;
    
    Node* temp = head;
    
    while(/*temp->data.GetEmployeeNumber() == employeeNumber &&*/ temp!= NULL)
    {
        temp = temp->next;
    }
    temp->prev->next = temp->next;
    temp->next->prev = temp->prev;
    delete temp;
}

void DoubleDynamicLinkedList::Display(int employeeNumber)
{
    if(head == NULL) return;
    Node* temp = head;
    
    while(temp != NULL)
    {
        if(temp->data.GetEmployeeNumber() == employeeNumber)
        {
            cout << temp->data;
        }
        temp = temp->next;
    }
}


ostream& operator<<(ostream& output, DoubleDynamicLinkedList list)
{
    /*Node* temp = head;
    while(temp != NULL)
    {
        cout << temp->data << endl;
        temp = temp->next;
    }*/
    return output;
}
