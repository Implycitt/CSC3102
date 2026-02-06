//package fleetorganizer;
/**
 *
 * @author Duncan <br>
 * Purpose: An interface that provides methods for a class that models a motor vehicle<br>
 * <pre>
 * File: CarAPI.java
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
public interface CarAPI 
{
  /**
    * gives the year manufactured
    * @return the year this vehicle was manufactured
    */
   int getYear();
   
   /**
    * gives the make of this vehicle
    * @return the make of this vehicle
    */
   String getMake();
   
   /**
    * gives the model of this vehicle
    * @return the model of this vehicle
    */
   String getModel();
   
   /**
    * gives the type of this vehicle
    * @return the type of this vehicle
    */
   String getType();
      
   /**
    * gives the vehicle record in format [year,make,model,type]
    * @return a string representation of this vehicle in the format [year,make,model,type]
    */
   @Override
    String toString();    
        /**
     * compares this Car and the specified Car
     * @param c a Car
     * @return a number less than 0 when this car comes before
     * the specified Car date; a number greater than 0 when this
     * car comes after the specified car; otherwise,0.
     * key: +year+make+model+type
     */
    public int compareTo(Car c);
}
