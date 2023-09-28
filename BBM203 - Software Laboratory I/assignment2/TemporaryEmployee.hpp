#ifndef TemporaryEmployee_hpp
#define TemporaryEmployee_hpp

#include "Employee.hpp"




class TemporaryEmployee : public Employee
{                                           //When calling constructor first instantiate date class and access their members
public:
    TemporaryEmployee(int employeeNumber, string name, string surname, string title, double salaryCoefficient, Date birthDate) :
    Employee(employeeNumber, name, surname, title, salaryCoefficient, birthDate)
    {
        m_employeeType = 0;
        m_lengthServiceOtherInstitution = 0;
    }
    
    friend ostream& operator<<(ostream& output, const TemporaryEmployee& emp);
    
    TemporaryEmployee& operator=(TemporaryEmployee const& other);
    
    
};

ostream& operator<<(ostream& output, const TemporaryEmployee& emp);

#endif
