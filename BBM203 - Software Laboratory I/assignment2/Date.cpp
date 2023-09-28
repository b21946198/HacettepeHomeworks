#include "Date.hpp"
Date::Date()
{
    m_day = 0;
    m_month = 0;
    m_year = 0;
    m_appointmentDay = 0;
    m_appointmentMonth = 0;
    m_appointmentYear = 0;
}
void Date::PrepareDate(string unpreparedDate)
{
    
    string delimiter = "-";
    string token1 = unpreparedDate.substr(0, unpreparedDate.find(delimiter));           // day
    unpreparedDate.erase(0, unpreparedDate.find(delimiter) + delimiter.length());
    
    string token2 = unpreparedDate.substr(0, unpreparedDate.find(delimiter));           // month
    unpreparedDate.erase(0, unpreparedDate.find(delimiter) + delimiter.length());
    
    string token3 = unpreparedDate.substr(0, unpreparedDate.find(delimiter));           // year
    unpreparedDate.erase(0, unpreparedDate.find(delimiter) + delimiter.length());
    
    m_day = stoi(token1);
    m_month = stoi(token2);
    m_year = stoi(token3);
    
}

void Date::PrepareAppointmentDate(string appointmentDate)
{
    string delimiter = "-";
    string token1 = appointmentDate.substr(0, appointmentDate.find(delimiter));           // day
    appointmentDate.erase(0, appointmentDate.find(delimiter) + delimiter.length());
    
    string token2 = appointmentDate.substr(0, appointmentDate.find(delimiter));           // month
    appointmentDate.erase(0, appointmentDate.find(delimiter) + delimiter.length());
    
    string token3 = appointmentDate.substr(0, appointmentDate.find(delimiter));           // year
    appointmentDate.erase(0, appointmentDate.find(delimiter) + delimiter.length());
    
    m_appointmentDay = stoi(token1);
    m_appointmentMonth = stoi(token2);
    m_appointmentYear = stoi(token3);
    
}


bool Date::operator<(const Date &obj)
{
    if(m_year < obj.GetYear()) {return true;}
    else if(m_year == obj.GetYear() && m_month < obj.GetMonth()) {return true;}
    else if(m_year == obj.GetYear() && m_month == obj.GetMonth() && m_day < obj.GetDay()) {return true;}
    else {return false;}
}

bool Date::operator>(const Date &obj)
{
    if(m_year > obj.GetYear()) {return true;}
    else if(m_year == obj.GetYear() && m_month > obj.GetMonth()) {return true;}
    else if(m_year == obj.GetYear() && m_month == obj.GetMonth() && m_day > obj.GetDay()) {return true;}
    else {return false;}
}

bool Date::operator<=(const Date &obj)
{
    if(m_year <= obj.GetYear()) {return true;}
    else if(m_year == obj.GetYear() && m_month <= obj.GetMonth()) {return true;}
    else if(m_year == obj.GetYear() && m_month == obj.GetMonth() && m_day <= obj.GetDay()) {return true;}
    else {return false;}
}

bool Date::operator>=(const Date &obj)
{
    if(m_year >= obj.GetYear()) {return true;}
    else if(m_year == obj.GetYear() && m_month >= obj.GetMonth()) {return true;}
    else if(m_year == obj.GetYear() && m_month == obj.GetMonth() && m_day >= obj.GetDay()) {return true;}
    else {return false;}
}

bool Date::operator==(const Date &obj)
{
    if(m_year == obj.GetYear() && m_month == obj.GetMonth() && m_year == obj.GetYear()) {return true;}
    else{return false;}
}
