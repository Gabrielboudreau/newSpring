package com.nighthawk.spring_portfolio.mvc.calendar;
import java.lang.Math;
// Prototype Implementation

public class APCalendar {

    /** Returns true if year is a leap year and false otherwise.
     * isLeapYear(2019) returns False
     * isLeapYear(2016) returns True
     */          
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0){
            return true;
        }
        if (year % 100 == 0){
            return false;
        }
        if (year % 4 == 0){
            return true;
        } else {
            return false;
        }
    };
    private static int firstDayOfYear(int year) {
    
        int difference = Math.abs(year - 2024);
        int leapYear = Math.round(difference/4);
        int day = (((difference * 365) + leapYear)%7); 
        return day;
    }    
    static int dayOfYear(int month, int day, int year) {
        int dayInMonth[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sum = 0; 
        int newSum = 0;
        for(int i = 0; i < month; i++){
            sum = sum + dayInMonth[i];
        }
        newSum = day + sum-31;
        if (isLeapYear(year)&&(month > 3)){
            newSum = newSum + 1;
        }
        return newSum;
        }

    /** Returns the number of leap years between year1 and year2, inclusive.
     * Precondition: 0 <= year1 <= year2
    */ 
    public static int numberOfLeapYears(int year1, int year2) {
        int leapYears = 0;
        int i;
        for(Math.abs(i = year2- year1); i >= 0; i--){
            if (isLeapYear(i+year1)){
                leapYears++;
            }
            
        }
        return leapYears;
    }
  
    /** Returns the value representing the day of the week for the given date
     * Precondition: The date represented by month, day, year is a valid date.
    */
    public static int dayOfWeek(int month, int day, int year) { 
        int diff = 365*(year-2023);        
        int leap = numberOfLeapYears(year, 2023);
        int day2 = dayOfYear(month, day, year);
        int sum1 = 0;
        if (diff < 0){
            sum1 = diff + day2 - leap; 
            return sum1;
        } else {
            sum1 = diff+day2-leap;
            if (year<2025){
                sum1 = sum1-1;
            }
            sum1 = sum1 % 7;
            return sum1; 
        }
        
    }

    /** Tester method */
    public static void main(String[] args) {
        // Private access modifiers
        System.out.println("firstDayOfYear: " + APCalendar.firstDayOfYear(2022));
        System.out.println("dayOfYear: " + APCalendar.dayOfYear(12, 2, 2022));

        // Public access modifiers
        System.out.println("isLeapYear: " + APCalendar.isLeapYear(2022));
        System.out.println("numberOfLeapYears: " + APCalendar.numberOfLeapYears(2000, 2022));
        System.out.println("dayOfWeek: " + APCalendar.dayOfWeek(1, 1, 2024));
    }

}