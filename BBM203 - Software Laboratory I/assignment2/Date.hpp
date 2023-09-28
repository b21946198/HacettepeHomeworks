#ifndef Date_hpp
#define Date_hpp

#include <iostream>

using namespace std;

class Date
{
private:
    int m_day;
    int m_month;
    int m_year;
    int m_appointmentDay;
    int m_appointmentMonth;
    int m_appointmentYear;
    
public:                     // split - to day month year
    Date();
    int GetDay() const {return m_day;}
    int GetMonth() const{return m_month;}
    int GetYear() const {return m_year;}
    int GetAppointmentDay() const {return m_appointmentDay;}
    int GetAppointmentMonth() const {return m_appointmentMonth;}
    int GetAppointmentYear() const {return m_appointmentYear;}
    
    void PrepareDate(string unpreparedDate);
    void PrepareAppointmentDate(string appointmentDate);
    
    bool operator<(Date const &obj);
    bool operator>(Date const &obj);
    bool operator<=(Date const &obj);
    bool operator>=(Date const &obj);
    bool operator==(Date const &obj);
    
};




#endif
