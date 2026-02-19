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
        FileReader reader;  
        boolean valid = false;
        int iterator;
        String line= "";
        PQueue lines = new PQueue();
        int orderKey;

        if (args.length == 0 || args.length == 1)
        {
          System.out.println(usage);
          return;
        }

        try
        {
          reader = new FileReader(args[0]);
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
         
        while ((iterator = reader.read()) != -1) 
        {
          line += (char) iterator;
          if ((char) iterator == '\n') 
          {
            System.out.println(line);
            lines.add(line);
            line = "";
          }
        }
        
    }    
}
