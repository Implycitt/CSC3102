import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;


/**
 * A testbed for the Heap implementation; sorts car data in various orders
 * @see HeapAPI.java, CarAPI.java
 * @author Duncan, Quentin
 * <pre>
 * File: FleetOrganizer.cpp
 * Date: 26-02-05
 * Course: csc 3102.001
 * Programming Project # 1
 * Instructor: Dr. Duncan 
 * 
 * Usage: FleetOrganizer <data-file> <order-key>
 * Note: Record for the vehicles must be organized in the data text file with 
 *       records, one per row, and with fields comma-delimited, as follows:
 *       <year>, <make>, <model>, <type>
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
public class FleetOrganizer 
{
    /**
     * @param args[0] <data-file>
     * @param args[1] <order-key>
     */
    public static void main(String[] args) throws IOException, PQueueException
    {
        String usage = "usage: FleetOrganizer <data-file> <order-key>\n";
        usage += "<data-file>:\n";
        usage += "Record for the vehicles must be organized in the data file with records, one per row,\n";
        usage +=  "and with fields comma-delimited, as follows:\n";
        usage += "<year>,<make>,<model>,<type>\n";
        usage += "<order-key>:\n";
        usage += "2 -> +make+model+type+year\n";
        usage += "1 -> +year+make+model+type\n";
        usage += "0 -> -type+year-make-model\n";
        usage += "-1 -> -year-make-model-type\n";
        usage += "-2 -> -make-model-type-year\n";
        
        int[] validKeys = {-2, -1, 0, 1, 2};
        String[] sorts = {"-make-model-type-year", "-year-make-model-type", "-type+year-make-model", "+year+make+model+type", "+make+model+type+year"};
        boolean valid = false;
        int orderKey;
        Comparator<Car> cmp = null;

        if (args.length == 0 || args.length == 1)
        {
          System.out.println(usage);
          return;
        }

        try
        {
          orderKey = Integer.parseInt(args[1]);
          for (int key: validKeys)
          {
            if (key == orderKey) valid = true;
          }
        } catch (Exception e) {
          System.out.println(e);
          System.out.println(usage);
          return;
        }

        if (!valid) 
        {
          System.out.println(usage);
          return;
        }
         
        switch (orderKey) {
            case 2:
                cmp = new Comparator<Car>() {
                    public int compare(Car a, Car b) {
                        int r = a.getMake().compareTo(b.getMake());
                        if (r != 0) return r;
                        r = a.getModel().compareTo(b.getModel());
                        if (r != 0) return r;
                        r = a.getType().compareTo(b.getType());
                        if (r != 0) return r;
                        return a.getYear() - b.getYear();
                    }
                };
                break;
            case 1:
                cmp = new Comparator<Car>() {
                    public int compare(Car a, Car b) {
                        int r = a.getYear() - b.getYear();
                        if (r != 0) return r;
                        r = a.getMake().compareTo(b.getMake());
                        if (r != 0) return r;
                        r = a.getModel().compareTo(b.getModel());
                        if (r != 0) return r;
                        return a.getType().compareTo(b.getType());
                    }
                };
                break;
            case 0:
                cmp = new Comparator<Car>() {
                    public int compare(Car a, Car b) {
                        int r = b.getType().compareTo(a.getType());
                        if (r != 0) return r;
                        r = a.getYear() - b.getYear();
                        if (r != 0) return r;
                        r = b.getMake().compareTo(a.getMake());
                        if (r != 0) return r;
                        return b.getModel().compareTo(a.getModel());
                    }
                };
                break;
            case -1:
                cmp = new Comparator<Car>() {
                    public int compare(Car a, Car b) {
                        int r = b.getYear() - a.getYear();
                        if (r != 0) return r;
                        r = b.getMake().compareTo(a.getMake());
                        if (r != 0) return r;
                        r = b.getModel().compareTo(a.getModel());
                        if (r != 0) return r;
                        return b.getType().compareTo(a.getType());
                    }
                };
            case -2:
                cmp = new Comparator<Car>() {
                    public int compare(Car a, Car b) {
                        int r = b.getMake().compareTo(a.getMake());
                        if (r != 0) return r;
                        r = b.getModel().compareTo(a.getModel());
                        if (r != 0) return r;
                        r = b.getType().compareTo(a.getType());
                        if (r != 0) return r;
                        return b.getYear() - a.getYear();
                    }
                };
                break;
          }

        PQueue<Car> cars = new PQueue<Car>(cmp);

        try {
            Scanner fileScan = new Scanner(new FileReader(args[0]));
            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    try {
                        int year = Integer.parseInt(parts[0].trim());
                        String make = parts[1].trim().toUpperCase();
                        String model = parts[2].trim().toUpperCase();
                        String type = parts[3].trim().toUpperCase();

                        cars.add(new Car(year, make, model, type));
                    } catch (NumberFormatException e){}
                }
            }
            fileScan.close();
        } catch (IOException e) {
            System.out.println(usage);
            return;
        }

        System.out.println(String.format("Fleet: %s", sorts[orderKey+2]));
        while (!cars.isEmpty())
        {
          System.out.println(cars.remove());
        }


    }    
}
