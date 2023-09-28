#ifndef PermanentEmployee_hpp
#define PermanentEmployee_hpp

#include "Employee.hpp"



class PermanentEmployee : public Employee
{                                           //When calling constructor first instantiate date class and access their members
public:
    PermanentEmployee();
    PermanentEmployee(int employeeNumber, string name, string surname, string title, double salaryCoefficient, Date birthDate) :
    Employee(employeeNumber, name, surname, title, salaryCoefficient, birthDate)
    {
        m_employeeType = 1;
        m_lengthServiceOtherInstitution = 0;
    }

    friend ostream& operator<<(ostream& output, const PermanentEmployee& emp);
    
    PermanentEmployee& operator=(PermanentEmployee const& other);
    
};

ostream& operator<<(ostream& output, const PermanentEmployee& emp);

#endif

