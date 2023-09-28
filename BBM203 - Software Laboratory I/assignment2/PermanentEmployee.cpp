#include "PermanentEmployee.hpp"

PermanentEmployee::PermanentEmployee() {}

ostream& operator<<(ostream& output, const PermanentEmployee& emp)
{
    output << "EMPLOYEE NUMBER: " << emp.m_employeeNumber << endl;
    output << "EMPLOYEE TYPE: " << emp.m_employeeType << endl;
    output << "NAME: " << emp.m_name << endl;
    output << "SURNAME: " << emp.m_surname << endl;
    output << "TITLE: " << emp.m_title << endl;
    output << "SALARY COEFFICIENT: " << emp.m_salaryCoefficient << endl;
    output << "BIRTH DAY: " << emp.m_birthDate.GetDay() << endl;
    output << "BIRTH MONTH: " << emp.m_birthDate.GetMonth() << endl;
    output << "BIRTH YEAR: " << emp.m_birthDate.GetYear() << endl;
    output << "APPOINTMENT DAY: " << emp.m_dateOfAppointment.GetAppointmentDay() << endl;
    output << "APPOINTMENT MONTH: " << emp.m_dateOfAppointment.GetAppointmentMonth() << endl;
    output << "APPOINTMENT YEAR: " << emp.m_dateOfAppointment.GetAppointmentYear() << endl;
    output << "LENGTH OF SERVICE IN OTHER INSTITUTION: " << emp.m_lengthServiceOtherInstitution << endl;
    
    return output;
}

PermanentEmployee& PermanentEmployee::operator=(PermanentEmployee const& other)
{
    return *this;
}
