#include "Employee.hpp"
#include "TemporaryEmployee.hpp"
#include "PermanentEmployee.hpp"
#include "Date.hpp"
#include "CircularArrayLinkedList.hpp"
#include "DoubleDynamicLinkedList.hpp"


void AscendingOrder(const Employee& employee);
void AscendingDateOrder(const Employee& employee);
void CertainDate(const Employee& employee);
void GivenYear(const Employee& employee);
void GivenBirthDate(const Employee& employee);
void GivenMonth(const Employee& employee);
vector<Employee> vect;
vector<Employee> vect2;
vector<Employee> vect3;
vector<Employee> vect4;
vector<Employee> vect5;
vector<Employee> vect6;
int main()
{
    cout << "____ Employee Recording System ____" << endl;
    
    string instructions = "Please select for the following Menu Operation:\n"
                          "1) Appointment of a new employee\n"
                          "2) Appointment of a transferred employee\n"
                          "3) Updating the title and salary coefficient of an employee\n"
                          "4) Deletion of an employee\n"
                          "5) Listing the information of an employee\n"
                          "6) Listing employees ordered by employee number\n"
                          "7) Listing employees ordered by appointment date\n"
                          "8) Listing employees appointed after a certain date\n"
                          "9) Listing employees assigned in a given year\n"
                          "10) Listing employees born before a certain date\n"
                          "11) Listing employees born in a particular month\n"
                          "12) Listing the information of the last assigned employee with a given title\n";
    
    CircularArrayLinkedList circularArrayLinkedList;
    DoubleDynamicLinkedList doubleDynamicLinkedList;
    /*Date date;
    date.PrepareDate("1-1-1");
    PermanentEmployee perm(1234,"umut", "gungor", "xd", 1.2, date);
    //cout << perm;*/
    
    
    

    while(true)
    {
        cout << instructions;
        int option;
        cin >> option;
        
        switch (option)
        {
            case 1:
            {
                cout << "Please type the employee number" << endl;
                int employeeNumber;
                cin >> employeeNumber;
                
                cout << "Type the employee type" << endl;           //if 1 perm if 0 temp
                int employeeType;
                cin >>employeeType;
                
                cout << "Type the Name" << endl;
                string name;
                cin >> name;
                
                cout << "Type the surname" << endl;
                string surname;
                cin >> surname;
                
                cout << "Type title" << endl;
                string title;
                cin >> title;
                
                cout << "Type salary coefficient" << endl;
                double salaryCoefficient;
                cin >> salaryCoefficient;
                
                cout << "Type birth date" << endl;
                string birthDate;
                cin >> birthDate;
                Date date;
                date.PrepareDate(birthDate);
                
                cout << "Type appointment date" << endl;
                string appointmentDate;
                cin >> appointmentDate;
                date.PrepareAppointmentDate(appointmentDate);
                cout << endl;
                
                //insertion yapilacak ayni numaradan varsa insertion fonksiyonu bitecek     once find cagirilacak
                if(employeeType == 0)
                {
                    TemporaryEmployee temporaryEmployee(employeeNumber, name, surname, title, salaryCoefficient, date);
                    temporaryEmployee.SetDateOfAppointment(date);
                    
                    circularArrayLinkedList.Insert(temporaryEmployee);
                }
                
                else
                {
                    PermanentEmployee permanentEmployee(employeeNumber, name, surname, title, salaryCoefficient, date);
                    permanentEmployee.SetDateOfAppointment(date);
                    
                    doubleDynamicLinkedList.Insert(permanentEmployee);
                }
                
                break;
                
            }
                
                
            case 2:
            {
                cout << "Please type the employee number" << endl;
                int employeeNumber;
                cin >> employeeNumber;
                
                cout << "Type the employee type" << endl;           //if 1 perm if 0 temp
                int employeeType;
                cin >>employeeType;
                
                cout << "Type the Name" << endl;
                string name;
                cin >> name;
                
                cout << "Type the surname" << endl;
                string surname;
                cin >> surname;
                
                cout << "Type title" << endl;
                string title;
                cin >> title;
                
                cout << "Type salary coefficient" << endl;
                double salaryCoefficient;
                cin >> salaryCoefficient;
                
                cout << "Type birth date" << endl;
                string birthDate;
                cin >> birthDate;
                Date date;
                date.PrepareDate(birthDate);
                
                cout << "Type appointment date" << endl;
                string appointmentDate;
                cin >> appointmentDate;
                date.PrepareAppointmentDate(appointmentDate);
                
                cout << "Type length of service days" << endl;                      //option 1'de yok
                int lengthOfDays;
                cin >> lengthOfDays;
                cout << endl;
                
                //insertion yapilacak ayni numaradan varsa insertion fonksiyonu bitecek         once find cagirilacak
                if(employeeType == 0)
                {
                    TemporaryEmployee temporaryEmployee(employeeNumber, name, surname, title, salaryCoefficient, date);
                    temporaryEmployee.SetDateOfAppointment(date);
                    temporaryEmployee.SetLengthServiceOtherInstitution(lengthOfDays);
        
                    circularArrayLinkedList.Insert(temporaryEmployee);
                }
                
                else
                {
                    PermanentEmployee permanentEmployee(employeeNumber, name, surname, title, salaryCoefficient, date);
                    //PermanentEmployee* permanentEmployee = new PermanentEmployee(employeeNumber, name, surname, title, salaryCoefficient, date);
                    permanentEmployee.SetDateOfAppointment(date);
                    permanentEmployee.SetLengthServiceOtherInstitution(lengthOfDays);
                    
                    doubleDynamicLinkedList.Insert(permanentEmployee);
                }
                
                break;
                
            }
                
                
            case 3:
            {
                cout << "Please type the employee number" << endl;
                int employeeNumber;
                cin >> employeeNumber;
                
                if(circularArrayLinkedList.Find(employeeNumber))
                {
                    TemporaryEmployee temp = circularArrayLinkedList.Get(employeeNumber);
                    
                    cout << "Type the title" << endl;
                    string title;
                    cin >> title;
                    
                    cout << "Type salary coefficient" << endl;
                    double salaryCoefficient;
                    cin >> salaryCoefficient;
                    
                    circularArrayLinkedList.Update(temp, title, salaryCoefficient);
                }
                else if(doubleDynamicLinkedList.Find(employeeNumber))
                {
                    PermanentEmployee pemp = doubleDynamicLinkedList.Get(employeeNumber);
                    
                    cout << "Type the title" << endl;
                    string title;
                    cin >> title;
                    
                    cout << "Type salary coefficient" << endl;
                    double salaryCoefficient;
                    cin >> salaryCoefficient;
                    
                    doubleDynamicLinkedList.Update(pemp, title, salaryCoefficient);
                }
                
                break;
                
            }
                
                
            case 4:
            {
                cout << "Please type the employee number" << endl;
                int employeeNumber;
                cin >> employeeNumber;
                circularArrayLinkedList.Delete(employeeNumber);
                //doubleDynamicLinkedList.Delete(employeeNumber);
                break;
                
            }
                
                
            case 5:
            {
                cout << "Please type the employee number" << endl;
                int employeeNumber;
                cin >> employeeNumber;
                if(circularArrayLinkedList.Find(employeeNumber))
                {
                    circularArrayLinkedList.Display(employeeNumber);
                }
                else if(doubleDynamicLinkedList.Find(employeeNumber))
                {
                    doubleDynamicLinkedList.Display(employeeNumber);
                }
                break;
                
            }
                
                
            case 6:
            {
                int temp = circularArrayLinkedList.GetHead();
                while(temp < circularArrayLinkedList.GetAvail())
                {
                    AscendingOrder(circularArrayLinkedList.CLLArray[temp]);
                    temp++;
                }
                DoubleDynamicLinkedList::Node* temp_ptr = doubleDynamicLinkedList.head;
                while(temp_ptr != NULL)
                {
                    AscendingOrder(temp_ptr->data);
                    temp_ptr = temp_ptr->next;
                }
                for(int i = 0; i < vect.size(); i++)
                {
                    cout << vect[i] << endl;
                }
                
                break;
                
            }
                
                
            case 7:
            {
                int temp = circularArrayLinkedList.GetHead();
                while(temp < circularArrayLinkedList.GetAvail())
                {
                    AscendingDateOrder(circularArrayLinkedList.CLLArray[temp]);
                    temp++;
                }
                DoubleDynamicLinkedList::Node* temp_ptr = doubleDynamicLinkedList.head;
                while (temp_ptr != NULL)
                {
                    AscendingDateOrder(temp_ptr->data);
                    temp_ptr = temp_ptr->next;
                }
                for(int i = 0; i < vect2.size(); i++)
                {
                    cout << vect2[i] << endl;
                }
                
                break;
                
            }
                
                
            case 8:
            {
                cout << "Type appointment date" << endl;
                string appointmentDate;
                cin >> appointmentDate;
                Date givenAppointmentDate;
                givenAppointmentDate.PrepareAppointmentDate(appointmentDate);
                //bu givenAppointmentDate'ten sonra giren employee'lerin infolari yeniden eskiye gore listelenecek 04-07-2005 03-08-2001'den once       once butun employee'leri siralayacam 2 for ile
                
                int temp = circularArrayLinkedList.GetHead();
                while(temp < circularArrayLinkedList.GetAvail())
                {
                    if(circularArrayLinkedList.CLLArray[temp].GetDateOfAppointment() > givenAppointmentDate)
                    {
                        CertainDate(circularArrayLinkedList.CLLArray[temp]);
                    }
                    temp++;
                }
                DoubleDynamicLinkedList::Node* temp_ptr = doubleDynamicLinkedList.head;
                while(temp_ptr != NULL)
                {
                    if(temp_ptr->data.GetDateOfAppointment() > givenAppointmentDate)
                    {
                        CertainDate(temp_ptr->data);
                    }
                    temp_ptr = temp_ptr->next;
                }
                for(int i = 0; i < vect3.size(); i++)
                {
                    cout << vect3[i] << endl;
                }
                
                
                break;
                
            }
                
                
            case 9:
            {
                cout << "Type year" << endl;
                int givenYear;
                cin >> givenYear;
                //bu givenYear'da giren employee'lerin infolari eskiden yeniye gore listelenecek 03-08-2001 04-07-2005'ten once                     once butun employee'leri siralayacam 2 for ile
                
                int temp = circularArrayLinkedList.GetHead();
                while(temp < circularArrayLinkedList.GetAvail())
                {
                    if(circularArrayLinkedList.CLLArray[temp].GetDateOfAppointment().GetYear() == givenYear)
                    {
                        GivenYear(circularArrayLinkedList.CLLArray[temp]);
                    }
                    temp++;
                }
                DoubleDynamicLinkedList::Node* temp_ptr = doubleDynamicLinkedList.head;
                while(temp_ptr != NULL)
                {
                    if(temp_ptr->data.GetDateOfAppointment().GetYear() == givenYear)
                    {
                        GivenYear(temp_ptr->data);
                    }
                    temp_ptr = temp_ptr->next;
                }
                for(int i = 0; i < vect4.size(); i++)
                {
                    cout << vect4[i] << endl;
                }
                
                break;
                
            }
                
                
            case 10:
            {
                cout << "Type birth date" << endl;
                string birthDate;
                cin >> birthDate;
                Date givenBirthDate;
                givenBirthDate.PrepareDate(birthDate);
                //bu givenBirthDate'ten once dogan butun employee'lerin infolari artan employeeNumber'a gore listelenecek                       once butun employee'leri siralayacam 2 for ile
                int temp = circularArrayLinkedList.GetHead();
                while(temp < circularArrayLinkedList.GetAvail())
                {
                    if(circularArrayLinkedList.CLLArray[temp].GetBirthDate() > givenBirthDate)
                    {
                        GivenBirthDate(circularArrayLinkedList.CLLArray[temp]);
                    }
                    temp++;
                }
                DoubleDynamicLinkedList::Node* temp_ptr = doubleDynamicLinkedList.head;
                while (temp_ptr != NULL)
                {
                    if(temp_ptr->data.GetBirthDate() > givenBirthDate)
                    {
                        GivenBirthDate(temp_ptr->data);
                    }
                    temp_ptr = temp_ptr->next;
                }
                for(int i = 0; i < vect5.size(); i++)
                {
                    cout << vect5[i] << endl;
                }
                
                break;
                
            }
                
                
            case 11:
            {
                cout << "Type month" << endl;
                int month;
                cin >> month;
                //bu month'ta dogan butun employee'lerin infolari artan employeeNumber'a gore listelenecek    once butun employee'leri siralayacam 2 for ile(bu ve yukaridaki 3-4'unde kosula uygun)
                int temp = circularArrayLinkedList.GetHead();
                while (temp < circularArrayLinkedList.GetAvail())
                {
                    if(circularArrayLinkedList.CLLArray[temp].GetBirthDate().GetMonth() == month)
                    {
                        GivenMonth(circularArrayLinkedList.CLLArray[temp]);
                    }
                    temp++;
                }
                DoubleDynamicLinkedList::Node* temp_ptr = doubleDynamicLinkedList.head;
                while(temp_ptr != NULL)
                {
                    if(temp_ptr->data.GetBirthDate().GetMonth() == month)
                    {
                        GivenMonth(temp_ptr->data);
                    }
                    temp_ptr = temp_ptr->next;
                }
                for(int i = 0; i < vect6.size(); i++)
                {
                    cout << vect6[i] << endl;
                }
                
                break;
                
            }
                
                
            case 12:
            {
                cout << "Type title" << endl;
                string title;
                cin >> title;
                //bu title'a son atanan employee'nin infosu listelenecek                                     yine butun employee'ler arasindan secim yapmak lazim
                for(int i = 0; i < vect.size(); i++)
                {
                    if(vect[i].GetTitle() == title)
                    {
                        cout << vect[i] << endl;
                    }
                }
                
                break;
                
            }
                
            
            
            case -1:
                cout << "FINISHED!!!" << endl;                      //not neccessary
                return 0;
            
                
                
                
        }
        
        cout << endl;
        vect.clear();
        vect2.clear();
        vect3.clear();
        vect4.clear();
        vect5.clear();
        vect6.clear();
    }

}


void AscendingOrder(const Employee& employee)
{
    vect.push_back(employee);
    for (int i = 0; i < vect.size(); i++)
    {
        for (int j = i+1; j < vect.size(); j++)
        {
            if(vect[i].GetEmployeeNumber() > vect[j].GetEmployeeNumber())
            {
                Employee temp = vect[i];
                vect[i] = vect[j];
                vect[j] = temp;
            }
        }
    }
}


void AscendingDateOrder(const Employee& employee)
{
    vect2.push_back(employee);
    for(int i = 0; i < vect2.size(); i++)
    {
        for(int j = i+1; j < vect2.size() ; j++)
        {
            if(vect2[i].GetDateOfAppointment() > vect2[j].GetDateOfAppointment())
            {
                Employee temp = vect2[i];
                vect2[i] = vect2[j];
                vect2[j] = temp;
            }
        }
    }
}


void CertainDate(const Employee& employee)
{
    vect3.push_back(employee);
    for(int i = 0; i < vect3.size(); i++)
    {
        for(int j = i+1; j < vect3.size(); j++)
        {
            if(vect3[i].GetDateOfAppointment() < vect3[j].GetDateOfAppointment())
            {
                Employee temp = vect3[i];
                vect3[i] = vect3[j];
                vect3[j] = temp;
            }
        }
    }
}


void GivenYear(const Employee& employee)
{
    vect4.push_back(employee);
    for(int i = 0; i < vect4.size(); i++)
    {
        for(int j = i+1; j < vect4.size(); j++)
        {
            if(vect4[i].GetDateOfAppointment() > vect4[j].GetDateOfAppointment())
            {
                Employee temp = vect4[i];
                vect4[i] = vect4[j];
                vect4[j] = temp;
            }
        }
    }
}

void GivenBirthDate(const Employee& employee)
{
    vect5.push_back(employee);
    for (int i = 0; i < vect5.size(); i++)
    {
        for (int j = i+1; j < vect5.size(); j++)
        {
            if(vect5[i].GetEmployeeNumber() > vect5[j].GetEmployeeNumber())
            {
                Employee temp = vect5[i];
                vect5[i] = vect5[j];
                vect5[j] = temp;
            }
        }
    }
}

void GivenMonth(const Employee& employee)
{
    vect6.push_back(employee);
    for (int i = 0; i < vect6.size(); i++)
    {
        for (int j = i+1; j < vect6.size(); j++)
        {
            if(vect6[i].GetEmployeeNumber() > vect6[j].GetEmployeeNumber())
            {
                Employee temp = vect6[i];
                vect6[i] = vect6[j];
                vect6[j] = temp;
            }
        }
    }
}
