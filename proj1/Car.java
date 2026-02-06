/**
 *
 * @author Duncan <br>
 * Purpose: A class that describes a motor vehicle<br>
 * <pre>
 * File: Car.java
 * Date: 99-99-9999
 * CSC 3102 Programming Project # 1
 * Instructor: Dr. Duncan 
 *
 * DO NOT REMOVE THIS NOTICE (GNU GPL V2):
 * Contact Information: duncanw@lsu.edu
 * Copyright (c) 2026 William E. Duncan
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>
 * </pre>
 */
public class Car implements CarAPI,Comparable<Car>
{
    /**
     * the year the vehicle was manufactured
     */
    private int year;
    /**
     * the make
     */
    private String make;
    /**
     * the model
     */
    private String model;
    /**
     * the type
     */
    private String type;
    /**
    * creates a dummy object: 1886 Benz No.1 Carriage
    */
    public Car()
    {
        year = 1886;
        make = "Benz";
        model = "No. 1";
        type = "Carriage";        
    }
    /**
     * creates a vehicle
     * @param yy the year 
     * @param mk the make
     * @param md the model 
     * @param ty the type
     * @throws IllegalArgumentException exception when <br>
     * <pre>
     * 1. year is before 1886
     * 2. the make, model or type does not have at least one character
     * </pre>
     */
    public Car(int yy, String mk, String md, String ty) throws IllegalArgumentException
    {
        if (yy < 1886)
            throw new IllegalArgumentException("The first vehicle was manufactured in 1886.");
        if (mk.length() == 0 || md.length() == 0 || ty.length() == 0)
            throw new IllegalArgumentException("The make, model and type must not be empty.");
        year = yy;
        make = mk;
        model = md;
        type = ty;    
    }

    @Override
    public int getYear() 
    {
        return year;
    }

    @Override
    public String getMake() 
    {
        return make;
    }
    
    @Override
    public String getModel() 
    {
        return model;
    }

    @Override
    public String getType() 
    {
        return type;
    }

    @Override
    public int compareTo(Car c) 
    {
        if (year != c.year)
            return year - c.year;
        if (make.compareTo(c.make) != 0)
            return make.compareTo(c.make);
        if (model.compareTo(c.model) != 0)
            return model.compareTo(c.model);
        return type.compareTo(c.type);        
    }
    
    @Override
    public String toString()
    {
        return String.format("[%d, %s, %s, %s]",year,make,model,type);
    }
}
