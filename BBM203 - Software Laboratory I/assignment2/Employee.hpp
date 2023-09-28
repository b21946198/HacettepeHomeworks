#ifndef Employee_hpp
#define Employee_hpp

#include <iostream>
#include "Date.hpp"
using namespace std;


class Employee
{
protected:
    const int m_employeeNumber;
    int m_employeeType;         // 1 for permanent and 0 for temporary
    const string m_name;
    const string m_surname;
    string m_title;
    double m_salaryCoefficient;     // These are initialized by constructor
    const Date m_birthDate;
    
    Date m_dateOfAppointment;               // These can be accessed by Set functions if neccessary
    int m_lengthServiceOtherInstitution;
    
    
                                // When calling constructor first instantiate date class
public:
    Employee();
    Employee(int employeeNumber, string name, string surname, string title, double salaryCoefficient, Date birthDate) :
    m_employeeNumber (employeeNumber), m_name(name), m_surname(surname), m_title(title), m_salaryCoefficient(salaryCoefficient), m_birthDate(birthDate)
    {}
    int GetEmployeeNumber() const {return m_employeeNumber;}
    int GetEmployeeType() const {return m_employeeType;}
    string GetName() const {return m_name;}
    string GetSurname() const {return m_surname;}
    string GetTitle() const {return m_title;}
    void SetTitle(string title) {m_title = title;}
    double GetSalaryCoefficient() const {return m_salaryCoefficient;}
    void SetSalaryCoefficient(double salaryCoefficient) {m_salaryCoefficient = salaryCoefficient;}
    Date GetBirthDate() const {return m_birthDate;}     //reference dondurmek gerekebilir
    
    Date GetDateOfAppointment() const {return m_dateOfAppointment;}     //reference dondurmek gerekebilir
    void SetDateOfAppointment(Date dateOfAppointment) {m_dateOfAppointment = dateOfAppointment;}
    int GetLengthServiceOtherInstitution() const {return m_lengthServiceOtherInstitution;}
    void SetLengthServiceOtherInstitution(int lengthServiceOtherInstitution) {m_lengthServiceOtherInstitution = lengthServiceOtherInstitution;}
    
    Employee& operator=(Employee const& other);
    
    friend ostream& operator<<(ostream& output, const Employee& emp);
    
};

ostream& operator<<(ostream& output, const Employee& emp);

#endif
